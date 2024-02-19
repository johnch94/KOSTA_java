package p0214;

import java.util.Scanner;

public class ifElseIf문 {
  public static void main(String[] args) {
    Scanner score = new Scanner(System.in);

    System.out.println("점수를 입력하시오 :");
    int sc = score.nextInt();

    if(sc>=90){
      System.out.println("A");
    } else if (sc>=80) {
      System.out.println("B");
    } else if (sc>=70) {
      System.out.println("C");
    } else {
      System.out.println("불합");
    }



  }
}
