package com.example.justeacote.command;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CommandData.class, ProducteurData.class}, version = 1, exportSchema = false)
public abstract class CommandRoomDatabase extends RoomDatabase {
    public abstract CommandDao commandDao();

    private static volatile CommandRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CommandRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CommandRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CommandRoomDatabase.class, "database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                CommandDao dao = INSTANCE.commandDao();
                dao.deleteAll();
                ProducteurData producteur = new ProducteurData(1,"farmer", "Richard", "Bob", "Je suis un artisan du coin, j'espère que mes jus vous plairont ! ");
                dao.insertProducteur(producteur);
                producteur = new ProducteurData(2,"farmer1", "Maison", "Franck", "Avec Franck, c'est la surereté d'un jus d'un goût incomarable et à prix compétitif ! ");
                dao.insertProducteur(producteur);
                producteur = new ProducteurData(3,"farmer2", "La Belle", "Michelle", "Les plus beaux jus de fruit de la région sont proposés ches moi. On rentrouve du jus de pomme, de cassis et même de la goyave ! ");
                dao.insertProducteur(producteur);
                producteur = new ProducteurData(4,"farmer3", "XVI", "François", "Les fruits font la révolution dans mes jus de fruit ! Si vous vous sentez l'âme royaliste, n'hésitez pas à commander un de mes délicieux jus de fruit ! ");
                dao.insertProducteur(producteur);
                CommandData command = new CommandData(741, "Incroyable commande", "grapejuice", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 4);
                dao.insert(command);
                command = new CommandData(147, "Incroyable commande", "juice", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 1);
                dao.insert(command);
                command = new CommandData(852, "Incroyable commande", "juice1", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 2);
                dao.insert(command);
                command = new CommandData(258, "Incroyable commande", "juice2", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 1);
                dao.insert(command);
                command = new CommandData(963, "Incroyable commande", "jusorange", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 4);
                dao.insert(command);
                command = new CommandData(369, "Incroyable commande", "juspomme", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes", 3);
                dao.insert(command);
                command = new CommandData(123, "Super commande", "Benoit", "Un super jus de pomme et du jus d'orange", "qq part rue de Verdun", 1);
                dao.insert(command);
                command = new CommandData(321, "Meilleur jus de Nantes", "juice1", "Ce n'est pas une arnaque, ce jus saura vous enchanter les papilles !", "Tout en bas de nantes", 4);
                dao.insert(command);
                command = new CommandData(456, "Jus de Raisin", "juice", "Tout est dans le titre, pas besoin d'en dire plus, achetez !", "a gauche de Nantes", 2);
                dao.insert(command);
                command = new CommandData(654, "Jus de figue", "grapejuice", "Ici, vous aurez un jus de figue fantastique !", "Bois des figues", 1);
                dao.insert(command);
                command = new CommandData(789, "La faise du jus", "juice", "Miam, les bonnes fraises !", "la fraiseraie", 3);
                dao.insert(command);
                command = new CommandData(987, "Petit délice matinal", "juice2", "Quoi de mieux que de se réveiller avec un bon jus d'orange le matin ?", "Dans un oranger", 4);
                dao.insert(command);


            });
        }
    };
}
