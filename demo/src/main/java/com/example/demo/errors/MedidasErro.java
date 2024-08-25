package com.example.demo.errors;

public abstract class MedidasErro extends Exception {
    public MedidasErro(String message) {
        super(message);
    }

    public MedidasErro(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getErrorCode();
}
