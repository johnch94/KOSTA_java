package p0220.test;
class Test3 extends Test1{
  public void printData(){
    // System.out.println("a : " + a);
    System.out.println("b : " + b);
    System.out.println("c : " + c);
    System.out.println("d : " + d);
    System.out.println();
  }
}
class Test4{
  public void print (){
    Test1 t1 = new Test1();
    // System.out.println("a : " + t1.a);
    System.out.println("b : " + t1.b);
    // protected는 같은 패키지에서는 상속관계 아니어도 사용 가능
    System.out.println("c : " + t1.c);
    System.out.println("d : " + t1.d);
    System.out.println();
  }
}
public class TestMain {
  public static void main(String[] args) {
    Test1 t1 = new Test1();
    // t1.a = 1;
    t1.b = 2;
    t1.c = 3;
    t1.d = 4;
    t1.print();
    t1.defaultMethod();

    Test1 t2 = new Test1(3);
    // t2.a = 1;
    t2.b = 2;
    t2.c = 3;
    t2.d = 4;
    t2.print();
    t2.defaultMethod();

    Test2 t3 = new Test2();
    // t1.a = 1;
    t1.b = 2;
    t1.c = 3;
    t1.d = 4;
    t1.print();


  }
}
