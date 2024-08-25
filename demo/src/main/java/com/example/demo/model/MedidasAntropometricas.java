package com.example.demo.model;

public class MedidasAntropometricas {
    private double peso;
    private double altura;
    private double circunferenciaQuadril;

    public MedidasAntropometricas(double peso, double altura, double circunferenciaQuadril) {
        this.peso = peso;
        this.altura = altura;
        this.circunferenciaQuadril = circunferenciaQuadril;
    }

    public double getCircunferenciaQuadril() {
        return circunferenciaQuadril;
    }

    public void setCircunferenciaQuadril(double circunferenciaQuadril) {
        this.circunferenciaQuadril = circunferenciaQuadril;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
