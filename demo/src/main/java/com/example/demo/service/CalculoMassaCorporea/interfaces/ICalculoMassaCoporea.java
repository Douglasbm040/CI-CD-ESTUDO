package com.example.demo.service.CalculoMassaCorporea.interfaces;

import com.example.demo.errors.MedidasErro;
import com.example.demo.model.MedidasAntropometricas;
import io.vavr.control.Either;

public interface ICalculoMassaCoporea {
    Either<MedidasErro, Double> calcular(MedidasAntropometricas medida);
}
