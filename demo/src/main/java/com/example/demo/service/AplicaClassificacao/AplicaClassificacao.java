package com.example.demo.service.AplicaClassificacao;

import com.example.demo.errors.MedidasErro;
import com.example.demo.model.MedidasAntropometricas;
import com.example.demo.service.CalculoMassaCorporea.interfaces.ICalculoMassaCoporea;
import com.example.demo.service.Classificador.Interface.IClassificadorIMC;
import io.vavr.control.Either;

public class AplicaClassificacao {
    private IClassificadorIMC classificadorIMC;
    private ICalculoMassaCoporea calculoMassaCoporea;
    private MedidasAntropometricas medidas;


    public AplicaClassificacao(IClassificadorIMC classificadorIMC, ICalculoMassaCoporea calculoMassaCoporea, MedidasAntropometricas medidas) {
        this.classificadorIMC = classificadorIMC;
        this.calculoMassaCoporea = calculoMassaCoporea;
        this.medidas = medidas;
    }

    public String getClassificacao() {
        return classificadorIMC.classificar(getResultadoCalculo());
    }

    public Either<MedidasErro,Double> getResultadoCalculo() {
        return calculoMassaCoporea.calcular(medidas);
    }







}
