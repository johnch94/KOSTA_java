package p0219;

public class 클래스 {
  private int x; //클래스 전역변수
  private int y;

  private void add1(){
    int res = x + y; //멤버변수 x, y
    System.out.println(x + " + " + y + " = " + (x+y));
  }

  private int add2(){
    return x+y;
  }

  private int add3(int x, int y){
    return x+y;
  }
  public static void main(String[] args) {
    클래스 cc = new 클래스();
    cc.x = 10;
    cc.y = 20;

    cc.add1();
    System.out.println(cc.add2());
    System.out.println(cc.add3(1,2));
  }
}