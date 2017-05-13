import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ekaterina on 3/29/17.
 */
public class InputDumper extends Thread {
    private DataInputStream in;

    protected InputDumper(InputStream in){
        this.in = new DataInputStream(in);
    }

    public void run(){
        try{
            String msg;
            while ((msg = in.readLine()) != null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
