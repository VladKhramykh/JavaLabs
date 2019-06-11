package restaurant;

import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;

public class Restaurant extends Thread  {
    int res = 0;
    Semaphore sem;
    int id;
    public Restaurant( Semaphore sem, int id){
        this.sem=sem;
        this.id=id;
    }

    public void run(){
        try{
            while(res<3)// пока количество приемов пищи не достигнет 3
            {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println ("Посетитель " + id+" садится за стол");
                // посетитель ест
                sleep(500);
                res++;

                System.out.println ("Посетитель " + id+" выходит из-за стола");
                sem.release();

                // посетитель гуляет
                sleep(500);
            }

        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
        //System.out.println(name + " освобождает столик");
        //sem.release();
    }
}
