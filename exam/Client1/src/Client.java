import java.io.*;import java.net.Socket;public class Client{    private Socket socket;    private BufferedReader reader;    private BufferedReader console;    private BufferedWriter writer;    private String ipAddr;    private int PORT;    public Client(String ipAddr, int PORT) throws IOException {        this.ipAddr = ipAddr;        this.PORT = PORT;        this.socket = new Socket(this.ipAddr, this.PORT);        console = new BufferedReader(new InputStreamReader(System.in));        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));        new WriteMessage().start();        new ReadMessage().start();    }    private void downService() {        try {            if (!socket.isClosed()) {                socket.close();                reader.close();                writer.close();            }        } catch (IOException ignored) {}    }    public class ReadMessage extends Thread{        @Override        public void run() {            String message;            try{                while(true){                    message = reader.readLine();                    if(message.equals("stop")){                        Client.this.downService();                        break;                    }                    System.out.println(message);                }            } catch (IOException e) {                Client.this.downService();            }        }    }    public class WriteMessage extends Thread{        @Override        public void run() {            String word;            while(true){                try {                    word = console.readLine();                    if(word.equals("stop")){                        writer.write("stop \n");                        Client.this.downService();                    }else{                        writer.write(word+"\n");                        writer.flush();                    }                } catch (IOException e) {                    Client.this.downService();                }            }        }    }}