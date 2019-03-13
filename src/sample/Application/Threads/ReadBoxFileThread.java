package sample.Application.Threads;

import sample.Application.FileOpe.Readers.BoxReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadBoxFileThread {

    public void threadRun() {
        Runnable runBoxRead = () -> {
            System.out.println("Third thread is running..."
                    + "\n- file read complete.");
            try {
                BoxReader readC = new BoxReader();
                readC.readDFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Can't read file !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread t3 = new Thread(runBoxRead);
        t3.start();
    }
}
