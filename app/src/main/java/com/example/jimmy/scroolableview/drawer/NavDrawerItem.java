package com.example.jimmy.scroolableview.drawer;

/**
 * Created by Jimmy on 3/5/2016.
 */
public class NavDrawerItem {
    private String title;
    private int image;
    private String counter;

    public NavDrawerItem() {}

    public NavDrawerItem(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }
}
