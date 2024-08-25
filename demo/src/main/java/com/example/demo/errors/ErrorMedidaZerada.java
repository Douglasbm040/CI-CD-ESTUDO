package com.example.demo.errors;

public class ErrorMedidaZerada extends MedidasErro{
    private static final int ERROR_CODE = 1002;

    public ErrorMedidaZerada(String message) {
        super(message);
    }

    public ErrorMedidaZerada(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
}
