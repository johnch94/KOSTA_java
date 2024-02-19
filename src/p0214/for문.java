package p0214;

import java.util.Scanner;

public class for문 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for(int i=0;i<3;i++){
      System.out.println(i);
    }
    int sum =0;
    for(int i=1;i<=100;i++){
      sum+=i;
    }
    System.out.println(sum);
    /*
    System.out.println("팩토리얼 구하고 싶은 값: ");
    int fac = sc.nextInt();
    int res = 1;
    for(int i=1; i<=fac;i++){
      res *= i;
    }
    System.out.println("결과 : "+ res);
    */

    //구구단 3단
    int thr = 3;
    for(int i =1; i<10;i++){
      System.out.println(3*i);
    }
    //숫자 입력 받아서 약수 출력
    System.out.println("약수를 구할 값 :");
    int num = sc.nextInt();
    for(int i=1; i<=num; i++){
      if(num%i==0){
        System.out.println(i);
      }
    }


  }
}
