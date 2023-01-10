import java.util.ArrayList;
import java.util.List;

public class ThreadExample extends Thread{
    int i;

    public ThreadExample(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " : " + this.i);

        // 1초 대기
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadTest{
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            Thread threadExample = new ThreadExample(i);
            threadExample.start();
            threadList.add(threadExample);
        }

        // 쓰레드 일단 모두 생성시켜놓고 join()을 통해 대기
        for(Thread thread : threadList){
            thread.join();
        }

        System.out.println("main thread end");
    }
}