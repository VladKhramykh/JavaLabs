import java.io.*;import java.net.ServerSocket;import java.net.Socket;import java.net.UnknownHostException;import java.util.LinkedList;public class Main {    public static final int PORT = 8081;    public static LinkedList<ServerSomthing> serverList = new LinkedList<>(); // список всех нитей - экземпляров    // сервера, слушающих каждый своего клиента    public static Story story; // история переписки    public static void main(String[] args) throws IOException {        React rx = new React();        rx.RxTask();        NetClass netClass = new NetClass();        try{            System.out.println(netClass.getCurrentIP());            System.out.println(netClass.getAddressByName("www.belstu.com"));            System.out.println(netClass.getHtml("https://vk.com"));        }catch (UnknownHostException e){            System.out.println(e.getMessage());        }        ServerSocket server = new ServerSocket(PORT);        story = new Story();        System.out.println("Server Started");        try {            while (true) {                // Блокируется до возникновения нового соединения:                Socket socket = server.accept();                try {                    serverList.add(new ServerSomthing(socket)); // добавить новое соединенние в список                } catch (IOException e) {                    // Если завершится неудачей, закрывается сокет,                    // в противном случае, нить закроет его:                    socket.close();                }            }        } finally {            server.close();        }    }}