package com.example.demo.service.CalculoMassaCorporea.Strategy;

import com.example.demo.errors.MedidasErro;
import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.model.MedidasAntropometricas;
import com.example.demo.service.CalculoMassaCorporea.strategys.IMCStrategy;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IMCStrategyTests {

    @Test
    public void testIMCStrategy() {
        IMCStrategy imcStrategy = new IMCStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 1.75, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = imcStrategy.calcular(medidas);
        if (resultado.isRight()) {
            double imcCalculado = resultado.get();
            double esperado = 70.0 / (1.75 * 1.75);
            assertEquals(esperado, imcCalculado, 0.01, "O IMC calculado está incorreto.");
        } else {
            fail("O cálculo de IMC falhou: " + resultado.getLeft().getMessage());
        }
    }

    @Test
    public void testIMCStrategyPesoZero() {
        IMCStrategy imcStrategy = new IMCStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(0.0, 1.75, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = imcStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IMC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIMCMEDIDAZERADA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIMCStrategyPesoNegativo() {
        IMCStrategy imcStrategy = new IMCStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(-70.0, 1.75, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = imcStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IMC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIMCMEDIDANEGATIVA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIMCStrategyAlturaNegativa() {
        IMCStrategy imcStrategy = new IMCStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, -1.75, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = imcStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IMC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIMCMEDIDANEGATIVA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIMCStrategyAlturaZero() {
        IMCStrategy imcStrategy = new IMCStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 0.0, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = imcStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IMC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIMCMEDIDAZERADA, resultado.getLeft().getMessage());
    }
}
