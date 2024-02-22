package p0221;
class A{
  public int a;
  public A(){
    System.out.println("A 생성자");
  }
  public void test1(){
    System.out.println("test1");
  }
}
class B extends A{
  public int b;
  public B(){
    System.out.println("B 생성자");
  }
  public void test2(){
    System.out.println("test2");
  }
}class C extends B{
  public int c;
  public C(){
    System.out.println("C 생성자");
  }
  public void test3(){
    System.out.println("test3");
  }
}
public class Inheritance1{
  public static void main(String[] args) {
    C ins = new C();
    ins.test3();
  }
}
