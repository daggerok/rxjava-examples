package com.github.daggerok.app.actors;

import akka.actor.AbstractActorWithTimers;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//tag::content[]
@Slf4j
public class PrinterActor extends AbstractActorWithTimers {

  @Getter
  @RequiredArgsConstructor
  public static class EchoMessage {
    final String message;
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(EchoMessage.class, echoMessage -> {
          final String message = echoMessage.message;
          System.out.println("message = " + message);
          log.info("received message: {}", message);
          this.getContext().getSystem().log().info("received: {}", message);
        })
        .build()
        ;
  }
}
//end::content[]
