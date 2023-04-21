package com.exam.assignment.models;

public class Post {
    private int ID;
    private int year;
    private String author;
    private String title;
    private String topic;
    private String fontOfText;

    public Post(int year, String author, String title, String topic, String fontOfText) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.topic = topic;
        this.fontOfText = fontOfText;
    }

    public Post(int ID, int year, String author, String title, String topic, String fontOfText) {
        this.ID = ID;
        this.year = year;
        this.author = author;
        this.title = title;
        this.topic = topic;
        this.fontOfText = fontOfText;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getFontOfText() {
        return fontOfText;
    }

    public void setFontOfText(String fontOfText) {
        this.fontOfText = fontOfText;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ID=" + ID +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", fontOfText='" + fontOfText + '\'' +
                '}';
    }
}
