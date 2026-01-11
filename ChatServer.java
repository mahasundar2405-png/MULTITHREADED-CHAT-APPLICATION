import java.util.*;

/*
 * MULTI THREADED CHAT APPLICATION (SIMULATION)
 * Online Compiler Friendly Version
 */

public class ChatApplication {

    static class ClientHandler extends Thread {
        String clientName;
        List<String> messages;

        ClientHandler(String name, List<String> msgs) {
            clientName = name;
            messages = msgs;
        }

        public void run() {
            for (String msg : messages) {
                System.out.println(clientName + ": " + msg);
                try {
                    Thread.sleep(500); // simulate delay
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter mode (server/client):");
        String mode = sc.nextLine();

        if (mode.equalsIgnoreCase("server")) {
            System.out.println("Server started");
            System.out.println("Waiting for clients...");

            // Simulated clients
            List<String> client1Msgs = Arrays.asList(
                    "Hello everyone",
                    "How are you?"
            );

            List<String> client2Msgs = Arrays.asList(
                    "Hi!",
                    "I am Client 2"
            );

            ClientHandler c1 = new ClientHandler("Client 1", client1Msgs);
            ClientHandler c2 = new ClientHandler("Client 2", client2Msgs);

            c1.start();
            c2.start();

            try {
                c1.join();
                c2.join();
            } catch (InterruptedException e) {
            }

            System.out.println("Chat ended");

        } else if (mode.equalsIgnoreCase("client")) {
            System.out.println("Client connected");
            System.out.println("Type message:");

            String msg = sc.nextLine();
            System.out.println("Client: " + msg);
        } else {
            System.out.println("Invalid mode");
        }

        sc.close();
    }
}
