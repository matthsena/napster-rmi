package samples.thread_demo;

public class ThreadDemo extends Thread {
    private String threadName;

    public ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        try {
            for (int i = 1; i < 4; i++) {
                System.out.println("T: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        }
    }
}
