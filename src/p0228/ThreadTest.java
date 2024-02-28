package p0228;

/**
 * 다중상속 예제
 */
interface A{
  void method_a();
}
interface B{
  void method_b();
}
interface C{
  void method_c();
}
class Point{
  int x;
  int y;
}
class Test extends Point implements A, B, C{

  @Override
  public void method_a() {
    System.out.println("method_a");
  }

  @Override
  public void method_b() {
    System.out.println("method_b");
  }

  @Override
  public void method_c() {
    System.out.println("method_c");
  }
}
public class ThreadTest {
  public static void main(String[] args) {
    Test t = new Test();

    t.method_a();
    t.method_b();
    t.method_c();
  }
}