package sample.Application.Threads;

public class RunThreads {

    public void runThreads(){
        ReadingFileThread t2 = new ReadingFileThread();
        t2.threadRun();

        ReadBoxFileThread t3 = new ReadBoxFileThread();
        t3.threadRun();

        ReadClientThread t4 = new ReadClientThread();
        t4.threadRun();
    }
}
