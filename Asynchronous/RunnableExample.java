public class RunnableExample implements Runnable{
    int i;

    public RunnableExample(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " : " + i);
        // 1초 대기
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class RunnableTest{
    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i++){
            Thread thread = new Thread(new RunnableExample(i));
            thread.start();
        }
    }
}