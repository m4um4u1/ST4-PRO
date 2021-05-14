package dk.sdu.mmmi.semproject.commandhandler;

import java.util.Scanner;
import java.util.Set;

public class Main {
        public static void main(String[] args) {

            CommandUA cua = new CommandUA();
            cua.commandUA();
            CommandHandler ch = new CommandHandler();

            System.out.println("Welcome to Brew, we will now serve you!");
        boolean running = true;
        try(Scanner s = new Scanner(System.in)){
            while(running) {
                switch(s.nextLine().toLowerCase()) {
                    case "start":
                        System.out.println("Starting the machine!");
                        ch.start();
                        break;
                    case "stop":
                        System.out.println("Stopping the machine!");
                        ch.stop();
                        break;
                    case "reset":
                        System.out.println("Reset configuration!");
                        ch.reset();
                        break;
                    case "abort":
                        System.out.println("Aborting!");
                        ch.abort();
                        break;
                    case "clear":
                        System.out.println("Clearing!");
                        ch.clear();
                        break;
                }
            }
        }
    }
}

