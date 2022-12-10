package com.chungbot.models;

public class NoticeItem {
    private int nid;
    private String title;
    private String writer;
    private String date;
    private String prevContent;

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

    public String getPrevContent() {
        return prevContent;
    }

    public void setPrevContent(String prevContent) {
        this.prevContent = prevContent;
    }
}
