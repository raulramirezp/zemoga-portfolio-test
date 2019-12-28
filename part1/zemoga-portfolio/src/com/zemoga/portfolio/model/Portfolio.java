package com.zemoga.portfolio.model;

public class Portfolio {
    private Integer id;
    private String description;
    private String imageURl;
    private String title;
    private String twitterUserName;

    public Portfolio(Integer id, String description, String imageURl, String title, String twitterUserName){
        this.id = id;
        this.description = description;
        this.imageURl = imageURl;
        this.title = title;
        this.twitterUserName = twitterUserName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("{");
        sb.append("id : " + this.getId() + ", ");
        sb.append("description : " + this.getDescription() + ", ");
        sb.append("image: " + this.getImageURl() + ", ");
        sb.append("title : " + this.getTitle() + ", ");
        sb.append("twitter : " + this.getTwitterUserName() + "}");
        return sb.toString();
    }
}
