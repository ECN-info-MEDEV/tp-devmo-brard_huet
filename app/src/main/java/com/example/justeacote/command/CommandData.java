package com.example.justeacote.command;

public class CommandData {
    private String commandName;
    private int commandImgId;
    private String commandDescription;
    private String commandLocalisation;

    public CommandData(String commandName, int commandImgId, String commandDescription, String commandLocalisation) {
        this.commandName = commandName;
        this.commandImgId = commandImgId;
        this.commandDescription = commandDescription;
        this.commandLocalisation = commandLocalisation;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public int getCommandImgId() {
        return commandImgId;
    }

    public void setCommandImgId(int commandImgId) {
        this.commandImgId = commandImgId;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public String getCommandLocalisation() {
        return commandLocalisation;
    }

    public void setCommandLocalisation(String commandLocalisation) {
        this.commandLocalisation = commandLocalisation;
    }
}
