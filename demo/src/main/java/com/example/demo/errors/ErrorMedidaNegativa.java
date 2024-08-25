package com.example.demo.errors;

public class ErrorMedidaNegativa extends MedidasErro {
    private static final int ERROR_CODE = 1001;

    public ErrorMedidaNegativa(String message) {
        super(message);
    }

    public ErrorMedidaNegativa(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
}
