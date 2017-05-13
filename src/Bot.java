import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by ekaterina on 4/13/17.
 */
public class Bot {
    private String name;
    private PrintStream printStream;

    public Bot(String name, PrintStream printStream){
        this.name = name;
        this.printStream = printStream;
    }

    public void sendMessage(){
        System.out.println("----------------------------- TRYING TO ASK BOT!!! --------------------------------");

        printStream.println("PRIVMSG " + "Candy : !ep1");
    }
}
