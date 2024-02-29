package p0229;

import java.util.Random;

// 공유자원
class Msg{
  private String str = "default message";
  public void print() {
    System.out.println(str);
  }

  public void setStr(String str) {
    this.str = str;
  }
}
class MyThread7 extends Thread{
  private Msg m;
  public MyThread7(Msg m){
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
public class Synch1 {
  public static void main(String[] args) {
    Msg m = new Msg();
    MyThread7[] th = new MyThread7[5];
    for(int i=0; i<th.length; i++){
      th[i] = new MyThread7(m); // m 객체를 쓰레드마다 할당
      th[i].start();
    }
  }
}
