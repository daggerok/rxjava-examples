package com.github.daggerok.app.actors;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//tag::content[]
@RequiredArgsConstructor
public class GreetingActor extends AbstractActorWithTimers {

  final ActorRef printerActor;

  @Getter
  @RequiredArgsConstructor
  public static class EchoMessage {
    final String message;
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(Object.class, anyObject -> {
          System.out.println("sending message..");
          getContext().getSystem().log().info("O.oOooOOOoOO__");
          printerActor.tell(new EchoMessage("olololo!"), self());
        })
        .build()
        ;
  }
}
//end::content[]
