package p0228;

import java.awt.*;

class MyThread4 extends Frame implements Runnable{
  @Override
  public void run() {
    for (int i=1; i<11; i++){
      setTitle(i + " 번째 타이틀");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
public class RunnableTest2 {
  public static void main(String[] args) {
    MyThread4 t4 = new MyThread4();
    t4.setSize(300, 300); // frame 창 크기 설정
    t4.setVisible(true); // frame 보이게

    Thread th = new Thread(t4); // runnable thread로 생성
    th.start(); // start()로 ready 상태 만듬
  }
}
