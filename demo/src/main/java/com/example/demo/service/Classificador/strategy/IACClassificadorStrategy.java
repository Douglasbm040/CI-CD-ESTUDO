package com.example.demo.service.Classificador.strategy;

import com.example.demo.errors.MedidasErro;
import com.example.demo.service.Classificador.Interface.IClassificadorIMC;
import com.example.demo.utils.GenerosUteis;
import io.vavr.control.Either;

public class IACClassificadorStrategy implements IClassificadorIMC {
    private int genero;

    public IACClassificadorStrategy(int genero) {
        this.genero = genero;
    }

    @Override
    public String classificar(Either<MedidasErro, Double> resultaCalculado) {
        if (resultaCalculado.isRight()) {
            if (genero == GenerosUteis.MASCULINO) {
                if (resultaCalculado.getOrNull() < 8) {
                    return "Sua classificação: Gordura abaixo do normal";
                } else if (resultaCalculado.getOrNull() <= 20) {
                    return "Sua classificação: Gordura normal";
                } else if (resultaCalculado.getOrNull() <= 25) {
                    return "Sua classificação: Sobrepeso";
                } else {
                    return "Sua classificação: Obesidade";
                }
            } else {
                if (resultaCalculado.getOrNull() < 21) {
                    return "Sua classificação: Gordura abaixo do normal";
                } else if (resultaCalculado.getOrNull() <= 33) {
                    return "Sua classificação: Gordura normal";
                } else if (resultaCalculado.getOrNull() <= 38) {
                    return "Sua classificação: Sobrepeso";
                } else {
                    return "Sua classificação: Obesidade";
                }
            }

        }else return resultaCalculado.getLeft().getMessage();
    }
}
