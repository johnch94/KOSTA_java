package p0219;
class Point{ // VO : Value Object
  int x, y;

  Point(int a, int b){ // 생성자, 컴파일러가 기본 생성자를 자동으로 만들어준다
    System.out.println("기본 생성자");
    x = a;
    y = b;
  }
  void setData(int a, int b){ // 멤버변수 초기화, setter
    x = a;
    y = b;
  }
  void printData(){
    System.out.println("x: " + x);
    System.out.println("y: " + y);
  }
}

class MethodTest{
  Point p;  // p는 null
  void setP1(){ //p 생성 메서드
    p = new Point(1,2);  // 객체 생성
    p.setData(12, 34); // 초기값 입력
  }
  void setP2(Point pp){ //param 으로 Point 객체 받아옴
   p = pp;
  }
  void printP(){ //멤버 p값 출력
    p.printData();
  }
}
public class method3 {
  public static void main(String[] args) {
    MethodTest mt = new MethodTest();
    mt.setP1();
    mt.printP();

    Point p = new Point(5,6);
    //p.setData(5,6);
    mt.setP2(p);
    mt.printP();
  }
}
