import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by ekaterina on 3/29/17.
 */
public class Channel {
    private String name;
    private PrintStream out;

    protected Channel(String name, Socket socket) throws IOException {
        this.name = name;

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));

        writer.write("JOIN " + name + "\r\n");
        writer.flush();

        out = new PrintStream(socket.getOutputStream());
    }
//
//    public void println(String msg){
//        out.println("PRIVMSG" + " " + "#" + name + " " + ":" + msg);
//    }

    public Bot getBot(String name){
        return new Bot(name, out);
    }

}
