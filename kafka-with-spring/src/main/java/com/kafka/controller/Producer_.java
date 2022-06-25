package com.kafka.controller;

import com.kafka.model.Pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer_ {

  private final KafkaTemplate<String, Pessoa> kafkaTemplate;

  public Producer_(KafkaTemplate<String, Pessoa> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @GetMapping("/kafka")
  public ResponseEntity<?> kafkaProducer() {
    final Pessoa pessoa = new Pessoa(String.valueOf(Math.random()), "Jakson", "Jakson@gmail.com");

    ListenableFuture<SendResult<String, Pessoa>> sended = kafkaTemplate.send("teste", 0, "transferencia", pessoa);

    sended.addCallback(sucess(), failed());

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  SuccessCallback<SendResult<String, Pessoa>> sucess() {
    return e -> {
      System.out.println("SuccessCallback: " + e.getProducerRecord() + "\n");
    };
  }

  FailureCallback failed() {
    return t -> {
      System.out.println("FailureCallback: " + t.getMessage() + "\n");
    };
  }
}
