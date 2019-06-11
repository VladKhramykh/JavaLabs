import restaurant.Restaurant;
import university.Entry;
import university.Exit;
import university.NewThread;
import java.util.Scanner;
import java.util.concurrent.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Entry entry = new Entry();
        Exit exit = new Exit();
        NewThread newThread = new NewThread();

        File dir = new File("file.txt");
        dir.delete();

        Thread entThread = new Thread(entry);
        Thread exThread = new Thread(exit);
        Thread thirdThread = new Thread(newThread);

        System.out.println("Работа с потоками");

        entThread.start();
        exThread.start();
        thirdThread.start();

        Semaphore sem = new Semaphore(2);

        for(int i=1;i<6;i++)
            new Restaurant(sem,i).start();
    }
}
