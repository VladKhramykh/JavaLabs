package com.belstu.restdto;

public class Login {
    private long id;
    private String content;

    public Login(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
