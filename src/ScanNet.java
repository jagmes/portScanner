import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ScanNet {
    public void scanP(String ip, int startPort, int endPort){
        for (int port = startPort; port <= endPort ; port++) {
                try {
                    InetAddress inetAddress =  InetAddress.getByName(ip);
                    Socket socket= new Socket(inetAddress,port);
                    System.out.println("Порт "+port + " открыт");
                    socket.close();
                }catch (IOException e){
                    System.out.println("Error: " +e);
                }
        }
        

    }


}
