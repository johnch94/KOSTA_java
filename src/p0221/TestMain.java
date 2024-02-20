package p0221;

import p0220.test.Test1;
// import p0220.test.Test2;

class Test3 extends Test1 {
  public void printData(){
    // System.out.println("a : " + a);

    // default 멤버는 다른 패키지에서 접근 불가
    // System.out.println("b : " + b);

    // protected는 상속관계에서 사용 가능
    System.out.println("c : " + c);
    System.out.println("d : " + d);
    System.out.println();
  }
}
class Test4{
  public void print (){
    Test1 t1 = new Test1();
    // System.out.println("a : " + t1.a);

    // default 는 다른 패키지에서 접근 불가
    // System.out.println("b : " + t1.b);

    // protected는 같은 패키지이거나 상속관계일때 접근 가능
    // System.out.println("c : " + t1.c);

    System.out.println("d : " + t1.d);
    System.out.println();
  }
}
public class TestMain {
  public static void main(String[] args) {
    Test1 t1 = new Test1();
    // t1.a = 1;
    // default
    // t1.b = 2;
    // protected
    // t1.c = 3;

    t1.d = 4;
    t1.print();

    // t1.defaultMethod();

    // default 생성자
    // Test1 t2 = new Test1(3);
    // t2.a = 1;
    // default
    // t2.b = 2;
    // protected
    // t2.c = 3;

//    t2.d = 4;
//    t2.print();
//    t2.defaultMethod();

//    Test2 t3 = new Test2();
//    // t3.a = 1;
//    t3.b = 2;
//    t3.c = 3;
//    t3.d = 4;
//    t3.print();


  }
}
