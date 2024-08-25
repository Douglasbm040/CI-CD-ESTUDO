package com.example.demo.service.Classificador.strategy;

import com.example.demo.errors.MedidasErro;
import com.example.demo.service.Classificador.Interface.IClassificadorIMC;
import io.vavr.control.Either;

public class IMCClassificadorStrategy implements IClassificadorIMC {
    @Override
    public String classificar(Either<MedidasErro, Double> resultaCalculado) {
        if (resultaCalculado.isRight()){
            if (resultaCalculado.getOrNull() < 18.5) {
                return "Sua classificação: Abaixo do peso";
            } else if (resultaCalculado.getOrNull() >= 18.5 && resultaCalculado.getOrNull() < 24.9) {
                return "Sua classificação: Peso normal";
            } else if (resultaCalculado.getOrNull() >= 25 && resultaCalculado.getOrNull() < 29.9) {
                return "Sua classificação: Sobrepeso";
            } else if (resultaCalculado.getOrNull() >= 30 && resultaCalculado.getOrNull() < 34.9) {
                return "Sua classificação: Obesidade grau 1";
            } else if (resultaCalculado.getOrNull() >= 35 && resultaCalculado.getOrNull() < 39.9) {
                return "Sua classificação: Obesidade grau 2";
            } else {
                return "Sua classificação: Obesidade grau 3";
            }
        }else{
            return resultaCalculado.getLeft().getMessage();
        }

    }
}
