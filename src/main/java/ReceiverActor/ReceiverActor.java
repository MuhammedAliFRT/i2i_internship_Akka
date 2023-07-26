package ReceiverActor;

import akka.actor.AbstractActor;

public class ReceiverActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> { //gelen mesajın trünü belirtir
                    System.out.println("Received message: "+ message);

                    // Send a message back to the sender actor in akkaDemo1
                    getSender().tell("Hi from Actor2", getSelf()); //gelen mesaja gönderilecek mesaj
                })
                .build();
    }
}