package p0220;
class StaticTest{
  int a;
  static int b, c;
  StaticTest(){
    StaticTest.c++;
    System.out.println(c + "번째 객체 생성됨.");
  }

  void print() {
    System.out.println("a : " + a);
    System.out.println("b : " + b);
  }
}
public class StaticVar1 {

  public static void main(String[] args) {
    StaticTest st = new StaticTest();
    st.a++;
    st.b++;
    st.print();

    StaticTest st2 = new StaticTest();
    st2.a++;
    st2.b++;
    st2.print();

    StaticTest st3 = new StaticTest();
    st3.a++;
    st3.b++;
    st3.print();

  }
}
