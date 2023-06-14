package com.example.myapplication2;

import com.google.firebase.Timestamp;

public class Zametki {
    public String title;
    public String content;
    public Timestamp timestamp;

    public Zametki() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void setTimestamp(com.google.firebase.Timestamp now) {
    }
}
