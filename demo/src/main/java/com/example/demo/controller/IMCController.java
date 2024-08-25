package com.example.demo.controller;

import com.example.demo.errors.ErrorMedidaNegativa;
import com.example.demo.errors.ErrorMedidaZerada;
import com.example.demo.errors.MedidasErro;
import com.example.demo.errors.utils.MessageErrorMedida;
import com.example.demo.factory.GerenciadorCalculo;
import com.example.demo.model.TicketCalculoIMC;
import com.example.demo.service.AplicaClassificacao.AplicaClassificacao;
import io.vavr.control.Either;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/calcular")
public class IMCController {
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Map<String, String> calcular(@RequestBody TicketCalculoIMC ticket) {
        Map<String, String> response = new HashMap<>();
        Either<Exception,AplicaClassificacao> classificacao = GerenciadorCalculo.executar(ticket);
         if (classificacao.isRight()) {
             AplicaClassificacao resultadoclassificacao = classificacao.getOrNull();
             if (resultadoclassificacao == null) {
                 response.put("message", "Não foi possivel gerar classificação");
             } else {
                 String classificacaoCalculada = resultadoclassificacao.getClassificacao();
                 response.put("message", classificacaoCalculada);
             }
         }else {
            response.put("message", classificacao.getLeft().getMessage());
         }

        return response;
    }

    @GetMapping
    public String ping() {
        return "pong";
    }
}
