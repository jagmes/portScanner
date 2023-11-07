import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    /*: Реализовать приложение сканер сети, приложение должно на вход получать ip адрес и
     проводить сканирование сети, находить активные устройства и получать список доступных портов.
     Информацию выводить в консоль и запрашивать у пользователя сохранение в файл формата txt или csv. */

    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        Scanner input = new Scanner(System.in);
        System.out.println("Введите начальный порт  от 1 до 65535: " );
        int startdiap = input.nextInt();
        System.out.println("Введите конечный порт  от 1 до 65535: ");
        int enddiap =input.nextInt();
        String outfile = "scan_res.txt";
        ScanNet scanNet = new ScanNet();
        FileHandler fl = new FileHandler();
        StringBuilder results = new StringBuilder();
        for (int port = startdiap; port <enddiap ; port++) {
                    try {
                        InetAddress inetAddress =  InetAddress.getByName(ip);
                        Socket socket= new Socket(inetAddress,port);
                        socket.setSoTimeout(3000);
                        System.out.println("Порт " +port+ "открыт");
                        results.append("Порт " +port+ "открыт\n");
                        socket.close();
                    }catch (IOException e){
                        System.out.println("Эррор " +e.getMessage());
                    }
        }
            System.out.println("Сохранить в файл? 1 - Да 2 - закрыть програму." );
            switch (input.nextInt()){
                case 1 -> fl.fileHandler(outfile, results.toString());
                case 2 -> System.exit(0);
            }
        }




}