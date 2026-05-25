package com.ms.EmailMS.service;

import com.ms.EmailMS.domain.EmailDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tools.jackson.databind.exc.UnrecognizedPropertyException;

import java.time.Instant;

@Slf4j
@Component
public class EmailConsumer {

    @Value("${broker.queue.email.name}")
    private String routingKey;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void emailConsumer(@Payload @Valid EmailDTO dto){
        Instant now = Instant.now();
        try {
            log.info("Email consumido da Fila {}, transação ocorrida em: {}, mensagem consumida em: {}."
                    ,routingKey, dto.getTransactionTime().toString(), now.toString());
        }
        catch (UnrecognizedPropertyException e){
            log.error("Erro na conversão para JSON, campos recebidos incompatíveis{}", e.getPropertyName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
