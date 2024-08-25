package com.example.demo.service.CalculoMassaCorporea.Strategy;

import com.example.demo.errors.MedidasErro;
import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.model.MedidasAntropometricas;
import com.example.demo.service.CalculoMassaCorporea.strategys.IACStrategy;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IACStrategyTests {

    @Test
    public void testIACStrategy() {
        IACStrategy iacStrategy = new IACStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 1.75, 100.0);
        // Act
        Either<MedidasErro, Double> resultado = iacStrategy.calcular(medidas);
        if (resultado.isRight()) {
            double iacCalculado = resultado.get();
            double esperado = (100.0 / (1.75 * Math.sqrt(1.75))) - 18;
            assertEquals(esperado, iacCalculado, 0.01, "O IAC calculado está incorreto.");
        } else {
            fail("O cálculo de IAC falhou: " + resultado.getLeft().getMessage());
        }
    }

    @Test
    public void testIACStrategyCircunferenciaQuadrilZero() {
        IACStrategy iacStrategy = new IACStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 1.75, 0.0);
        // Act
        Either<MedidasErro, Double> resultado = iacStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IAC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIACMEDIDAZERADA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIACStrategyCircunferenciaQuadrilNegativa() {
        IACStrategy iacStrategy = new IACStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 1.75, -100.0);
        // Act
        Either<MedidasErro, Double> resultado = iacStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IAC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIACMEDIDANEGATIVA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIACStrategyAlturaNegativa() {
        IACStrategy iacStrategy = new IACStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, -1.75, 100.0);
        // Act
        Either<MedidasErro, Double> resultado = iacStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IAC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIACMEDIDANEGATIVA, resultado.getLeft().getMessage());
    }

    @Test
    public void testIACStrategyAlturaZero() {
        IACStrategy iacStrategy = new IACStrategy();
        MedidasAntropometricas medidas = new MedidasAntropometricas(70.0, 0.0, 100.0);
        // Act
        Either<MedidasErro, Double> resultado = iacStrategy.calcular(medidas);
        // Assert
        assertTrue(resultado.isLeft(), "Esperava-se uma falha no cálculo de IAC.");
        assertEquals(MessageErrorMedida.MESSAGERRORIACMEDIDAZERADA, resultado.getLeft().getMessage());
    }
}
