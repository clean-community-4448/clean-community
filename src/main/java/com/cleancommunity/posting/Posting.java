package com.cleancommunity.posting;

public class Posting {

    private int id;
    private String title;
    private String description;
    private String associatedUsername;
    private String location;
    private boolean accepted;
    private boolean completed;
    private boolean flagged;

    // Used for creating posting from database
    Posting(int id, String title, String description, String submitter, String location, Boolean accepted) {

        setId(id);
        setTitle(title);
        setDescription(description);
        setAssociatedUsername(submitter);
        setLocation(location);
        setAccepted(accepted);
    }

    Posting(String request, int id) {

        // API needs to be defined

        this.id = id;
    }

    public Posting() {

        // This constructor should be removed after development.
        // It requires the com.cleancommunity.user update the id at a later date ...
    }


    public boolean isValid() {

        // What determines if a com.cleancommunity.posting is valid?

        return true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAssociatedUsername() {
        return associatedUsername;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getLocation() {
        return location;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssociatedUsername(String username) {
        this.associatedUsername = username;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public String toString() {
        String returnStr = String.format("%d|%s|%s|%s|%s|%b",
                this.id, this.title, this.description, this.associatedUsername, this.location, this.accepted);

        return returnStr;
    }
}



