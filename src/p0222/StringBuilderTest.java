package p0222;

import java.util.Scanner;

public class StringBuilderTest {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("aaa"); // append() : 문자열 끝에 연결
    sb.append("bbb");
    System.out.println(sb);
    sb.insert(1,"ccc"); // insert() : 문자열 삽입
    System.out.println(sb);
    sb.delete(2,5); // delete(2,5) 2이상 5미만 삭제
    System.out.println(sb);

    // 문자열을 한줄씩 입력받아서 StringBuilder 에 추가. /stop 입력하면 루프 종료 입력한 전체내용 출력

    String a;
    StringBuilder text = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.print("str(멈추려면 /stop) : ");
      a = sc.nextLine();
      if(a.equals("/stop")){
        System.out.println(text);
        break;
      }else {
        text.append(a);
      }
    }
  }
}
