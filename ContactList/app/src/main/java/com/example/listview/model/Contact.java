package com.example.listview.model;

public class Contact {
    private String name,Ph;
    private int imageResId;

    public Contact(String name, int imageResId,String Ph) {
        this.name = name;
        this.imageResId = imageResId;
        this.Ph=Ph;
    }

    public String getName() {
        return name;
    }
    public String getPh() {
        return Ph;
    }

    public int getImageResId() {
        return imageResId;
    }
}
