package com.springboot.intellij.resthibernatejpa.customexception;

public class PersonNotFoundException extends RuntimeException{
    private String message;

    public PersonNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public PersonNotFoundException() {
    }
}
