package sample.Application.Threads;

import sample.Application.FileReaders.DiscReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingFileThread {

    public void threadRun() {
        Runnable runFileRead = () -> {
            System.out.println("Second thread is running..."
                    + "\n- file read complete.");
            try {
                DiscReader readC = new DiscReader();
                readC.readDFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Can't read file !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread t2 = new Thread(runFileRead);
        t2.start();
    }
}
