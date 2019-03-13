package sample.Application.Threads;

import sample.Application.FileOpe.Readers.ClientReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadClientThread {

    public void threadRun() {
        Runnable runClientRead = () -> {
            System.out.println("Fourth thread is running..."
                    + "\n- file read complete.");
            try {
                ClientReader readC = new ClientReader();
                readC.readDFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Can't read file !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread t4 = new Thread(runClientRead);
        t4.start();
    }
}
