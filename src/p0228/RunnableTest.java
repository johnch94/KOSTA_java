package p0228;
class MyThread3 implements Runnable{
  @Override
  public void run() {
    for(int i=0; i<30; i++){
      System.out.println(i + " 번 째 이미지");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
public class RunnableTest {
  public static void main(String[] args) {
    /**
     * Runnable 구현체는 진짜 thread가 아니므로 Thread() 생성자에 넣어 Thread 객체 생성해야함
     * 그렇다면 왜 Runnable을 사용할까?
     *  => Runnable은 인터페이스여서 이미 상속을 받는 다른 클래스도 사용 가능하기 때문이다.
     */
    Thread th = new Thread(new MyThread3());
    th.start();

    // main 쓰레드 작업
    for(char i='a'; i<'z'; i++){
      System.out.println(i);
      try {
        Thread.sleep(100); // 현재 쓰레드를 sleep 상태로 만듬.
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
