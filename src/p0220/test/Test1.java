package p0220.test;
//public 클래스 : 현재 패키지, 다른 패키지 모든 곳에서 사용가능
public class Test1 {
  private int a;
  int b;
  protected int c;
  public int d;

  //public 생성자
  public Test1(){
    System.out.println("Test1의 public 생성자");
  }
  //default 생성자. 같은 패키지에서는 호출 가능하지만 다른 패키지에서는 호출불가
  Test1(int x){
    System.out.println("Test1의 default 생성자");
    a = x;
  }
  void defaultMethod(){
    System.out.println("defaultMethod");
  }
  public void print(){
    System.out.println("a : " + a);
    System.out.println("b : " + b);
    System.out.println("c : " + c);
    System.out.println("d : " + d);
  }

}

//default 클래스 : 현재 패키지만 사용 가능
class Test2{

}
