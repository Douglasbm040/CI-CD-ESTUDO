package com.example.demo.service.CalculoMassaCorporea.strategys;

import com.example.demo.errors.ErrorMedidaNegativa;
import com.example.demo.errors.ErrorMedidaZerada;
import com.example.demo.errors.MedidasErro;
import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.model.MedidasAntropometricas;
import com.example.demo.service.CalculoMassaCorporea.interfaces.ICalculoMassaCoporea;
import io.vavr.control.Either;

public class IACStrategy implements ICalculoMassaCoporea {
    @Override
    public Either<MedidasErro, Double> calcular(MedidasAntropometricas medida) {
        if (medida.getCircunferenciaQuadril() == 0 || medida.getAltura() == 0)
            return Either.left(new ErrorMedidaZerada(MessageErrorMedida.MESSAGERRORIACMEDIDAZERADA));
        if (medida.getCircunferenciaQuadril() < 0 || medida.getAltura() < 0)
            return Either.left(new ErrorMedidaNegativa(MessageErrorMedida.MESSAGERRORIACMEDIDANEGATIVA));
        return Either.right((medida.getCircunferenciaQuadril() / (medida.getAltura() * Math.sqrt(medida.getAltura()))) - 18);
    }
}
