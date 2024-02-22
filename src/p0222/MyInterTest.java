package p0222;
interface MyInter{
  int MAX = 610; //상수. final static 생략됨. 선언하면서 초기화 해야함
  //  int MIN; // 초기화 안하면 error


  // abstract, public 이 없어도 클래스가 아닌 인터페이스 이기 때문에 자동으로 추상처리
  /* public abstract */void method1();
  void method2();
}
class MyInterImp1 implements MyInter{

  @Override
  public void method1() {
    System.out.println("MAX : " + MAX + " / method1");
  }

  @Override
  public void method2() {
    System.out.println("MAX : " + MAX + " / method2");
  }
}
public class MyInterTest {
  public static void main(String[] args) {
    MyInterImp1 imp = new MyInterImp1();

    imp.method1();
    imp.method2();

  }
}
