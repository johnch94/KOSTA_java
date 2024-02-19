package p0214;

import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    /*
    System.out.println("문자열 입력 : ");
    String a = scan.next();
    System.out.println("숫자 입력 : ");
    int b = scan.nextInt();
    System.out.println("float 입력 : ");
    float c = scan.nextFloat();

    System.out.println("a : "+a);
    System.out.println("b : "+b);
    System.out.println("c : "+c);
    */
    //점수 입력받아 합/불 출력

    System.out.println("점수를 입력하시오 : ");
    int score = scan.nextInt();

    String a = score>=60?"합격":"불합격";

    System.out.println(a);
  }
}
