package p0228;
class MyThread5 extends Thread{
  /**
   * getName() : 쓰레드 이름 반환
   */
  @Override
  public void run() {
    System.out.println(this.getName() + " 우선순위 : " + this.getPriority());
    for(int i=0; i<100; i++){
      System.out.println(this.getName() + " : " + i + " 번째 실행");
    }
    System.out.println(this.getName() + " 종료");
  }
}
public class PriorityTest {
  public static void main(String[] args) {
    Thread[] th = new Thread[10];
    for(int i=0; i < th.length; i++){
      th[i] = new MyThread5();
      th[i].setPriority(i+1);
      th[i].start();
    }
    System.out.println("main 쓰레드");
    System.out.println(Thread.MIN_PRIORITY);
    System.out.println(Thread.NORM_PRIORITY);
    System.out.println(Thread.MAX_PRIORITY);

  }
}
