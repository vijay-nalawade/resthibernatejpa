package com.springboot.intellij.resthibernatejpa.customexception;

public class PersonAlreadyExists extends RuntimeException{
    private String message;

    public PersonAlreadyExists(String message) {
        super(message);
        this.message = message;
    }

    public PersonAlreadyExists() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
