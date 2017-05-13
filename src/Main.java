import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) throws Exception {
        // The server to connect to and our details.

        IRCConnection connection = new IRCConnection("irc.root-me.org");
        Channel channel = connection.getChannel("#root-me_challenge");
        Bot candy = channel.getBot("Candy");

        candy.sendMessage();
        connection.readChat();


//
//        String server = "irc.root-me.org";
//
//        String nick = "somecoolnick";
//
//        String login = "somecoolnick";
//
//
//        // The channel which the bot will join.
//
//        String channel = "#root-me_challenge";
//
//
//        // Connect directly to the IRC server.
//
//        Socket socket = new Socket(server, 6667);
//
//        BufferedWriter writer = new BufferedWriter(
//
//                new OutputStreamWriter(socket.getOutputStream()));
//
//        BufferedReader reader = new BufferedReader(
//
//                new InputStreamReader(socket.getInputStream()));
//
//
//        // Log on to the server.
//
//        writer.write("NICK " + nick + "\r\n");
//
//        writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");
//
//        writer.flush();
//
//
//        // Read lines from the server until it tells us we have connected.
//
//        String line = null;
//
//        System.out.println("----------------------------- LOGGING IN!!! --------------------------------");
//
//        while ((line = reader.readLine()) != null) {
//
//            if (line.indexOf("004") >= 0) {
//
//                // We are now logged in.
//
//                break;
//
//            } else if (line.indexOf("433") >= 0) {
//
//                System.out.println("Nickname is already in use.");
//
//                return;
//
//            }
//
//        }
//
//
//        // Join the channel.
//
//        writer.write("JOIN " + channel + "\r\n");
//
//        System.out.println("----------------------------- JOINING CHANNEL!!! --------------------------------");
//
//        writer.flush();
//
//        PrintStream printStream = new PrintStream(socket.getOutputStream());
//
//
//        // Keep reading lines from the server.
//        System.out.println("----------------------------- TRYING TO ASK BOT!!! --------------------------------");
//
//        printStream.println("PRIVMSG " + "Candy : !ep1");
//        Scanner scan = new Scanner(System.in);
//
//        while (true) {
//            if ((line = reader.readLine()) != null) {
//                if (line.toLowerCase().startsWith("PING ")) {
//
//                    // We must respond to PINGs to avoid being disconnected.
//
//                    // writer.write("PONG " + line.substring(5) + "\r\n");
//
//                    //writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
////                    writer.write("PRIVMSG " + "Candy : !ep1");
////                    writer.flush();
//                    printStream.println("PRIVMSG " + "Candy : !ep1");
//
//                } else {
//
//                    // Print the raw line received by the bot.
//
//                    System.out.println(line);
//
//
//                }
//
//                if (line.contains("PRIVMSG")) {
//                    if (line.contains("/")) {
//                        String newline = line.substring(line.indexOf(":", 2) + 1);
//                        System.out.println(newline);
//                        String[] numbers = newline.split("[/]");
//                        System.out.println(numbers[0] + " " + numbers[1]);
//                        numbers[0] = numbers[0].trim();
//                        numbers[1] = numbers[1].trim();
//                        double answer = Math.sqrt(Integer.parseInt(numbers[0])) * Integer.parseInt(numbers[1]);
//                        double rounded = Math.round(answer*100);
//                        double shrimt = (double) rounded/100;
//                        System.out.println("Answer: " + answer + " Rounded: " + rounded + " Shrimt: " + shrimt);
//
//                        printStream.println("PRIVMSG Candy : !ep1 -rep " + shrimt);
//                    }
//                }
//            } else {
//                System.out.println("----------------------------- NOTHING HAPPENS!!! --------------------------------");
//                System.out.println(line);
//
//
//            }
//
//
//        }
    }

}