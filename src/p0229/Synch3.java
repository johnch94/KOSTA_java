package p0229;
// 공유자원

class MyThread9 extends Thread{
  private Msg2 m;
  public MyThread9(Msg2 m){
    this.m = m;
  }
  @Override
  public void run(){
    for(int i=0; i<10; i++){
      synchronized (m) { // 동기화 블록
        m.setStr(getName() + " message[ " + i + " ]");
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
}
public class Synch3 {
  public static void main(String[] args) {
    Msg2 m = new Msg2(); // 공유 객체 생성
    MyThread9[] th = new MyThread9[5];
    for(int i=0; i<th.length; i++){
      th[i] = new MyThread9(m); // m 객체를 쓰레드마다 할당
      th[i].start();
    }
  }
}
