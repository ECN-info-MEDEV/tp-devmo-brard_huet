package com.example.justeacote.command;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "command")
public class CommandData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String commandName;
    @NonNull
    private String commandImgId;
    @NonNull
    private String commandDescription;
    @NonNull
    private String commandLocalisation;

    public CommandData(int id,@NonNull String commandName,@NonNull String commandImgId,@NonNull String commandDescription,@NonNull String commandLocalisation) {
        this.id = id;
        this.commandName = commandName;
        this.commandImgId = commandImgId;
        this.commandDescription = commandDescription;
        this.commandLocalisation = commandLocalisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(@NonNull String commandName) {
        this.commandName = commandName;
    }

    @NonNull
    public String getCommandImgId() {
        return commandImgId;
    }

    public void setCommandImgId(@NonNull String commandImgId) {
        this.commandImgId = commandImgId;
    }

    @NonNull
    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(@NonNull String commandDescription) {
        this.commandDescription = commandDescription;
    }

    @NonNull
    public String getCommandLocalisation() {
        return commandLocalisation;
    }

    public void setCommandLocalisation(@NonNull String commandLocalisation) {
        this.commandLocalisation = commandLocalisation;
    }
}
