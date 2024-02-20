package p0220;
class PrivateTest1{
  private int a; // private : 클래스 내에서만 사용가능

  int b;         // default : 같은 패키지 안에서만 사용 가능
  public int c;  // public : 어디서나 접근 가능
  private String name;

  void test(){
    a = 1;
  }

  // getter : private 멤버 값을 리턴하는 메서드. 클래스 밖에서 private 멤버 값을 읽을 수있게 제공하는 메서드
  public int getA() {
    return a;
  }

  // setter : private 맴버에 값을 쓰는 메서드. 접근 제어자는 public
  public void setA(int a) {
    this.a = a;
  }

  public String getName(){
    return name;
  }

  public void setName(String s){
    this.name = s;
  }

}
public class PrivateTest {
  public static void main(String[] args) {
    PrivateTest1 pt = new PrivateTest1();

    pt.setA(1); // private 는 클래스 안에서만 호출 가능
    pt.b = 2;
    pt.c = 3;
    System.out.println("" + pt.getA() + pt.b + pt.c);


  }
}
