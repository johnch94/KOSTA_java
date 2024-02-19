package p0214;

public class 증감연산 {
  public static void main(String[] args) {
    int res = 0, a=10;

    res = a++;
    System.out.println("res : " + res + " / a : " + a);
    res = ++a;
    System.out.println("res : " + res + " / a : " + a);
    res = a--;
    System.out.println("res : " + res + " / a : " + a);
    res = --a;
    System.out.println("res : " + res + " / a : " + a);

  }
}
