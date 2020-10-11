package com.example.finalprojectapp.data.entities;
public class NewsFeedPublished {
    private String title;
    private String image;
    private String datetime;
    private NewsFeedUser user;
    private ActionsPoints actionPoints;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() { return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public NewsFeedUser getUser() {
        return user;
    }

    public void setUser(NewsFeedUser user) {
        this.user = user;
    }

    public ActionsPoints getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(ActionsPoints actionPoints) {
        this.actionPoints = actionPoints;
    }
}
