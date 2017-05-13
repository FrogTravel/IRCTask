import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ekaterina on 3/29/17.
 */
public class IRCConnection {
    private String host;
    private int port;
    private Thread t;
    private String nickname;
    private String login;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public IRCConnection(String host) throws IOException {
        this(host, 6667);
    }

    public IRCConnection(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.nickname = "dontlookatme";
        this.login = "dontlookatme";

        connect();
        register();
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    PrintStream out;

    private void connect() throws IOException {
        socket = new Socket(host, port);

        writer = new BufferedWriter(

                new OutputStreamWriter(socket.getOutputStream()));

        reader = new BufferedReader(

                new InputStreamReader(socket.getInputStream()));


        // Log on to the server.


    }

    private void register() throws IOException {
        writer.write("NICK " + nickname + "\r\n");

        writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");

        writer.flush();

        String line = null;

        System.out.println("----------------------------- CLASS LOGGING IN!!! --------------------------------");

        while ((line = reader.readLine()) != null) {

            if (line.indexOf("004") >= 0) {

                // We are now logged in.

                break;

            } else if (line.indexOf("433") >= 0) {

                System.out.println("Nickname is already in use.");

                return;

            }

        }
    }

    public Channel getChannel(String name) throws IOException {
        return new Channel(name, socket);
    }

    public void readChat() throws IOException {
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String line = null;
        while (true) {
            if ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
                if (line.toLowerCase().startsWith("PING ")) {
                    //Must answer to PING messages or will be disconnected
                    printStream.println(" PONG ");
                }

                if(line.contains("PRIVMSG")){
                    if (line.contains("/")) {
                        String newline = line.substring(line.indexOf(":", 2) + 1);
                        System.out.println(newline);
                        String[] numbers = newline.split("[/]");
                        System.out.println(numbers[0] + " " + numbers[1]);
                        numbers[0] = numbers[0].trim();
                        numbers[1] = numbers[1].trim();
                        double answer = Math.sqrt(Integer.parseInt(numbers[0])) * Integer.parseInt(numbers[1]);
                        double rounded = Math.round(answer*100);
                        double shrimt = (double) rounded/100;
                        System.out.println("Answer: " + answer + " Rounded: " + rounded + " Shrimt: " + shrimt);

                        printStream.println("PRIVMSG Candy : !ep1 -rep " + shrimt);
                    }
                }

            }
        }
    }
}
