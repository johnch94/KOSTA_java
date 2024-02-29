package p0229;

// 숫자를 20 ~ 40 사이 유지
class Data{
  private int num;
  public synchronized void add(){
    num++;
    System.out.println("증가, num : " + num);
    if(num>=40){
      notifyAll(); // 대기 큐에서 대기중인 쓰레드 모두 깨움
      try {
        System.out.println("증가 쓰레드 wait...");
        wait(); // 현재 쓰레드 대기상태로 들어감
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("ADD wake up!!");
    }
  }

  public synchronized void sub(){
    num--;
    System.out.println("감소, num : " + num);
    if(num<=20){
      notifyAll();
      try {
        System.out.println("감소 쓰레드 wait...");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("SUB wake up!!");
    }
  }
}

class MyThread10 extends Thread { // 증가 쓰레드

  private Data data; // 공유 자원
  public MyThread10(Data data){
    this.data = data;
  }

  @Override
  public void run(){
    for(int i=0; i<50; i++){
      data.add();
    }
  }
}
class MyThread11 extends Thread { // 감소 쓰레드

  private Data data; // 공유 자원
  public MyThread11(Data data){
    this.data = data;
  }

  @Override
  public void run(){
    for(int i=0; i<50; i++){
      data.sub();
    }
  }
}

public class Synch4 {
  public static void main(String[] args) {
    Data d = new Data();
    MyThread10 th = new MyThread10(d);
    MyThread11 th2 = new MyThread11(d);

    th.start();
    th2.start();
  }
}
