package com.example.justeacote.command;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justeacote.R;

import java.util.List;

public class CommandAdapter extends RecyclerView.Adapter<CommandAdapter.ViewHolder>{
    private List<CommandData> commandData;
    private CommandActivity activity;

    public CommandAdapter(List<CommandData> commandData, CommandActivity activity) {
        this.commandData = commandData;
        this.activity = activity;
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // On créé une view à partir d'un fichier xml template
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.command_item, parent, false);
        CommandAdapter.ViewHolder viewHolder = new CommandAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CommandAdapter.ViewHolder holder, int position) {
        // On récupère la donnée à la position donnée
        final CommandData data = this.commandData.get(position);

        // On modifie le ViewHolder pour y affihcer nos données dessus
        holder.commandDescriptionTextView.setText(data.getCommandDescription()); // Le nom de la commande
        holder.commandNameTextView.setText(data.getCommandName()); // Le nom de la commande
        holder.commandLocalisationTextView.setText(data.getCommandLocalisation()); // Le nom de la commande
        holder.commandImgView.setImageResource(activity.getCommandImageFromLabel(data.getCommandImgId())); // L'image de la commande
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Permet d'afficher un message à chaque fois que l'utilisateur clique sur un élément de la liste déroulante
                Toast.makeText(view.getContext(), "Click sur commande : "+data.getCommandName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Permet de récupérer le nombre d'éléments dans le menu déroulant
     * @return nombre d'éléments du menu déroulant
     */
    @Override
    public int getItemCount() {
        return commandData.size();
    }

    /**
     * Permet de mettre à jour le menu déroulat lors de l'ajout d'une donnée
     * Cette donnée sera insérée à la fin de menu déroulant
     * @param cData donnée à insérer
     */
    public void update(CommandData cData) {
        commandData.add(cData);
        this.notifyItemInserted(this.getItemCount());
    }

    /**
     * Permet de supprimer une donnée du menu déroulant à une position donnée
     * @param position position de la donnée à supprimer
     */
    public void delete(int position) {
        commandData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,commandData.size());
    }

    /**
     * Classe représentant la structure xml des données à afficher
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView commandImgView;
        public TextView commandNameTextView;
        public TextView commandDescriptionTextView;
        public TextView commandLocalisationTextView;

        public RelativeLayout relativeLayout;
        /**
         * Récupère tous les éléments à modifier en fonction des données du template xml
         * @param itemView template
         */
        public ViewHolder(View itemView) {
            super(itemView);
            this.commandImgView = (ImageView) itemView.findViewById(R.id.commandItemImg);
            this.commandNameTextView = (TextView) itemView.findViewById(R.id.commandItemTitle);
            this.commandDescriptionTextView = (TextView) itemView.findViewById(R.id.commandItemDescription);
            this.commandLocalisationTextView = (TextView) itemView.findViewById(R.id.commandItemLocalisation);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.commandItemRelativeLayout);
        }
    }
}
