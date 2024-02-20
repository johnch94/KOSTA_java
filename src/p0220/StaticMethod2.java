package p0220;
class Test4{
  static final int MAX = 100;

//  static {
//    MAX = 200;
//  }

}
public class StaticMethod2 {
  public static void main(String[] args) {
    System.out.println("pi : " + Math.PI);      // static final (final = 상수)
    System.out.println("Math.abs(-12) : " + Math.abs(-12));
    System.out.println("Math.acos(35) : " + Math.acos(0));

    System.out.println("MAX : " + Test4.MAX);

  }
}
