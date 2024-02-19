package p0214;

import java.util.Scanner;

public class while문 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    /*
    int i =100;
    while(i>0){
      if(i%2!=0){
        System.out.println(i);
      }
      i--;
    }
    */
    /*
    String str = "";
    while (!str.equals("stop")){
      System.out.println("msg(멈추려면 stop 입력): ");
      str = sc.next();
      System.out.println("입력한 msg: " + str);
    }

     */
    /*
     1~100 사이의 소수 출력(소수 : 1은 제외)
     */

    for(int i=2; i<=100;i++){
      for(int j=2; j<=i; j++){
        if(i/j>1) {
          break;
        }
        else{
          System.out.println(i);
        }
      }
    }
    /*
    삼각형 크기 입력 받아 그리기
     */

    System.out.println("삼각형의 크기 : ");
    int num2 = sc.nextInt();

    for(int i=1; i<=num2;i++){
      for(int j=1; j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
    }
    System.out.println();

    /*
    반대 삼각형
     */
    int dis = num2;
    for(int i=1; i<=num2; i++){
      for(int j=dis-1; j>0; j--){
        System.out.print(" ");
      }
      for(int j=1; j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
      dis--;
    }
    System.out.println();

    /*
    이등변 삼각형
     */
    dis =num2;
    int cnt =1;
    for(int i=1; i<=num2; i++){
      for(int j=dis-1; j>0; j--){
        System.out.print(" ");
      }
      for(int j=1; j<=cnt;j++){
        System.out.print("*");
      }
      System.out.println();
      cnt+=2;
      dis--;
    }
    System.out.println();
    /*
    마름모 출력
     */

    dis = num2;
    cnt = 1;
    for(int i=1; i<=num2; i++){
      for(int j=dis-1; j>0; j--){
        System.out.print(" ");
      }
      for(int j=1; j<=cnt;j++){
        System.out.print("*");
      }
      System.out.println();
      cnt+=2;
      dis--;
    }
    for(int i=1; i<=num2-1; i++){
      cnt-=2;
      dis++;
      for(int j=1; j<=dis;j++){
        System.out.print(" ");
      }
      for(int j=cnt-2; j>0; j--){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
