package sample.Application.Threads;

public class RunThreads {

  public void runThreads() {
    ReadFileThread t3 = new ReadFileThread();
    t3.threadRun();
  }
}
