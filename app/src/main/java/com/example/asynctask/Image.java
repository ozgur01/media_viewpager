package com.example.asynctask;

public class Image implements Media{

    private String url;
    private int type;


    public Image(String url, int type)
    {
        this.type = type;
        this.url = url;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public int getType() {
        return this.type;
    }
}
