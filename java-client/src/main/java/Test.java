import io.socket.client.Socket;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by haolun on 2016/11/4.
 */
public class Test {
    public static void main(String[] args) {
        try {
            final Socket socket = IO.socket("http://172.16.101.123:7009");
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {

                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            socket.emit("update data", (int)(Math.random()*10));
                        }
                    }, 0, 1000);

//                    socket.disconnect();
                }

            }).on("event", new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                }

            });
            socket.connect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
