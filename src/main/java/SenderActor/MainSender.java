package SenderActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Scanner;


public class MainSender {

    public static void main(String[] args)  {

        Config config = ConfigFactory.load("App.conf");


        ActorSystem system = ActorSystem.create("SenderSystem", config);


        ActorRef sender = system.actorOf(Props.create(SenderActor.class), "sender");


        sender.tell("Hi from Actor1", ActorRef.noSender());

        System.out.println("You can write 0 to quit anytime");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (!input.equals("0")){
            input = scan.next();
        }
        system.terminate();

    }

}