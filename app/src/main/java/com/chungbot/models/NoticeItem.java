package com.chungbot.models;

public class NoticeItem {
    private int nid;
    private String title;
    private String writer;
    private String date;
    private String content;

    public NoticeItem() { };

    public NoticeItem(int nid, String title, String writer, String date, String content) {
        this.nid = nid;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
