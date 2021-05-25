package tempsensor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Publisher pub = new Publisher();
        pub.readId();
        pub.readName();
        pub.readSymbol();
        pub.subscribeToNode();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'Enter' to quit the program");
        scanner.nextLine();
        System.exit(0);
    }
}
