package multithreadingexample;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreadingexample.MainTwo.birthDate;



public class MainOne {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<1000;i++) {
            int id = i;
            threadPool.submit(() -> {
                System.out.println(birthDate(id));
            });
        }

        Thread.sleep(1000);



    }


}
