package com.example.demo.service.Classificador.Interface;

import com.example.demo.errors.MedidasErro;
import com.example.demo.service.CalculoMassaCorporea.interfaces.ICalculoMassaCoporea;
import io.vavr.control.Either;

public interface IClassificadorIMC {
    String classificar(Either<MedidasErro,Double> resultaCalculado);
}
