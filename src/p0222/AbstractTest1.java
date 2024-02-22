package p0222;
abstract class Parent{ // 추상 클래스
  protected int x;

  public abstract void test1(); // 추상 메서드
  public abstract void test2(); // 추상 메서드

  public void test3(){
    System.out.println("test3");
  }
}
class Child extends Parent{
  @Override
  public void test1(){
    System.out.println("test1");
  }
  @Override
  public void test2(){
    System.out.println("test2");
  }
  public void test4(){
    System.out.println("test4");
  }
}
public class AbstractTest1{
  public static void main(String[] args) {
    Child c = new Child();

    c.test1();
    c.test2();
    c.test3();

  }
}
