package p0229;
// 공유자원
class Msg2{
  private String str = "default message";
  public void print() {
    System.out.println(str);
  }

  // 동기화 메서드 synchronized
  public synchronized void setStr(String str) {
    this.str = str;
  }
}
class MyThread8 extends Thread{
  private Msg2 m;
  public MyThread8(Msg2 m){
    this.m = m;
  }
  @Override
  public void run(){
    for(int i=0; i<10; i++){
      m.setStr(getName()+" message[ "+i+" ]");
      int time = (int) (Math.random() * 100);
      try {
        sleep(time);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      m.print();
    }
  }
}
public class Synch2 {
  public static void main(String[] args) {
    Msg2 m = new Msg2(); // 공유 객체 생성
    MyThread8[] th = new MyThread8[5];
    for(int i=0; i<th.length; i++){
      th[i] = new MyThread8(m); // m 객체를 쓰레드마다 할당
      th[i].start();
    }
  }
}
