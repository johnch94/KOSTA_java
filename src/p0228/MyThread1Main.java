package p0228;
class MyThread extends Thread{
  @Override
  public void run() {
    for(int i=0; i<30; i++){
      System.out.println(i + " 번째 메시지");
      try {
        sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
class MyThread2 extends Thread{
  @Override
  public void run() {
    for(char i='a'; i<'z'; i++){
      System.out.println(i);
      try {
        sleep(100); // 현재 쓰레드를 sleep 상태로 만듬.
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
public class MyThread1Main {
  public static void main(String[] args) {
    MyThread th1 = new MyThread();
    MyThread2 th2 = new MyThread2();

    th1.start();
    th2.start();
  }
}
