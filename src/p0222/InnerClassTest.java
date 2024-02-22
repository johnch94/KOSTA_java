package p0222;
class InnerClass {
  private class Data { // 내부 클래스
    int x, y;
    void test() {
      System.out.println("inner class method");
    }
  }
  public class Data2 {
    int x, y;
    void test() {
      System.out.println("inner class method");
    }
  }

  public void innerTest1(){
    Data d1 = new Data();
    d1.x = 10;
    d1.y = 20;
    System.out.println("x: " + d1.x + "/ y: " + d1.y);
    d1.test();
  }
  public Data2 innerTest2(){
    return new Data2();
  }
}
public class InnerClassTest {
  public static void main(String[] args) {
    InnerClass ic = new InnerClass();
    ic.innerTest1();
    InnerClass.Data2 d1 = ic.innerTest2();
    d1.x = 123;
    d1.y = 345;
    System.out.println("x : " + d1.x + " / y : " + d1.y);
    d1.test();
  }
}
