package com.example.demo.service.CalculoMassaCorporea.strategys;

import com.example.demo.errors.ErrorMedidaNegativa;
import com.example.demo.errors.ErrorMedidaZerada;
import com.example.demo.errors.MedidasErro;
import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.model.MedidasAntropometricas;
import com.example.demo.service.CalculoMassaCorporea.interfaces.ICalculoMassaCoporea;
import io.vavr.control.Either;

public class IMCStrategy implements ICalculoMassaCoporea {
    @Override
    public Either<MedidasErro, Double> calcular(MedidasAntropometricas medida) {
        if (medida.getAltura() == 0 || medida.getPeso() == 0)
            return Either.left(new ErrorMedidaZerada(MessageErrorMedida.MESSAGERRORIMCMEDIDAZERADA));
        if (medida.getAltura() < 0 || medida.getPeso() < 0)
            return Either.left(new ErrorMedidaNegativa(MessageErrorMedida.MESSAGERRORIMCMEDIDANEGATIVA));
        return Either.right(medida.getPeso() / (medida.getAltura()*medida.getAltura()));
    }
}
