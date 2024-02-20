package p0220;
class Test3{
  int a;             //일반 멤버 변수
  static int b;      //static 변수

  void method1(){ // 일반 메서드는 일반 멤버 변수, static 변수 모두 가능
    a++;
    b++;
  }
  static void method2(){
    // static 메서드는 일반 멤버 변수 사용 불가, static 변수 사용 가능
    // 객체 생성 전에 호출시 일반 멤버 변수가 없기 때문
    // a++;
    b++;
  }void method3(){ // 일반 메서드는 일반, static 메서드 호출 가능
    method1();
    method2();
  }
  static void method4(){
    // static 메서드는 일반 메서드 호출 불가
    // 마찬가지로 객체 생성 전에는 일반 메서드가 없기 때문
    // method1();
    method2();
  }
}
public class StaticMethod {
  public static void main(String[] args) {
    // static 메서드는 객체 생성 없이 호출 가능
    Test3.method2();
    Test3.method4();
  }
}
