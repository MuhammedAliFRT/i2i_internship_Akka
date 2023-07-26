package ReceiverActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Scanner;

public class MainReceiver
{
    public static void main( String[] args )  {

        Config config = ConfigFactory.load("App.conf"); //App.conf yapılandırma dosyası yükleme


        ActorSystem system = ActorSystem.create("ReceiverSystem", config); //Actro sistemi oluşturma configyapılandırma ayarları


        ActorRef receiver = system.actorOf(Props.create(ReceiverActor.class), "receiver"); //Receiver sınıfından actor oluşturma

        System.out.println("You can write 0 to quit anytime");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (!input.equals("0")){
            input = scan.next();
        }
        system.terminate();

    }
}