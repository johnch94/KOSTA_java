package p0220;
class Test2{
  int a;
  static int b;

  { //일반 멤버 초기화 블록
    System.out.println("일반 초기화 블록에서 a 변경 전 : " + a);
   a = 10;
    System.out.println("일반 초기화 블록에서 a : " + a);
    System.out.println("일반 초기화 블록에서 b : " + b);
  }

  static { // static 초기화 블록
    System.out.println("static 블록에서 b 변경 전 : " + b);
    b = 20;
    //System.out.println("static 블록에서 a : " + a); // static 블록에서 일반 멤버변수 사용 불가
    System.out.println("static 블록에서 b : " + b);
  }

  Test2(){ // 생성자
    a = 100;
    b = 200;

    System.out.println("생성자에서 a : " + a);
    System.out.println("생성자에서 b : " + b);
  }
}
public class VarInit {
  public static void main(String[] args) {
    System.out.println("Test2.b : " + Test2.b);
    Test2 t = new Test2();


  }
}
