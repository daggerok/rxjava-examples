package com.github.daggerok.app;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.github.daggerok.app.actors.GreetingActor;
import com.github.daggerok.app.actors.PrinterActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//tag::content[]
@Slf4j
@Configuration
public class AkkaConfig {

  @Bean
  public ActorSystem actorSystem() {
    return ActorSystem.create("spring-akka-gradle-system");
  }

  @Bean
  public ActorRef printerActor(final ActorSystem actorSystem) {
    return actorSystem.actorOf(Props.create(PrinterActor.class), "PrinterActor");
  }

  @Bean
  public ActorRef greetingActor(final ActorSystem actorSystem, ActorRef printerActor) {
    return actorSystem .actorOf(Props.create(GreetingActor.class, printerActor), "GreetingActor");
  }

  @Bean
  public ApplicationRunner actorsApp(final ActorRef greetingActor) {
    return args -> {
      actorSystem().log().info("just greeting...");
      greetingActor.tell(new PrinterActor.EchoMessage("ololo!"), ActorRef.noSender());
    };
  }
}
//end::content[]
