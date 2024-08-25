package com.example.demo.factory;

import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.model.TicketCalculoIMC;
import com.example.demo.service.AplicaClassificacao.AplicaClassificacao;
import com.example.demo.service.CalculoMassaCorporea.strategys.IACStrategy;
import com.example.demo.service.CalculoMassaCorporea.strategys.IMCStrategy;
import com.example.demo.service.Classificador.strategy.IACClassificadorStrategy;
import com.example.demo.service.Classificador.strategy.IMCClassificadorStrategy;
import com.example.demo.utils.FormasCalculoUteis;
import io.vavr.control.Either;

public class GerenciadorCalculo {
    public static Either<Exception,AplicaClassificacao> executar(TicketCalculoIMC ticket){
        if (ticket.formaCalulo == FormasCalculoUteis.IMC){
            System.out.println("entro no IMC" + ticket.formaCalulo);
            return Either.right(new AplicaClassificacao(new IMCClassificadorStrategy(),new IMCStrategy(),ticket.medida));
        } else if (ticket.formaCalulo == FormasCalculoUteis.IAC) {
            System.out.println("entro no IAC" + ticket.formaCalulo);
            return Either.right(new AplicaClassificacao(new IACClassificadorStrategy(ticket.genero),new IACStrategy(),ticket.medida));
        } else{
            return Either.left(new Exception(MessageErrorMedida.MESSAGEERROCALCULONAOCADASTRADO)) ;
        }
    }
}
