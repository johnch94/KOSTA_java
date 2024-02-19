package p0216;

import java.util.Scanner;

/*
  주소록
  한 명 정보 : 이름/ 전화/ 주소
  객체배열(크기 30) : 배열차면 등록 안 됨
  이름 중복 체크

  1.등록 2.검색 3.수정 4.삭제 5.전체출력 6.종료
 */
class guest{
  String name;
  int call;
  String adr;
}

public class Address {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    guest[] man = new guest[30];
    int command;
    int count =0;
    int revNum;
    int delNum;
    String search;
    boolean set = true;

    while(set) {
      //커맨드
      System.out.println("==============================================");
      System.out.println("커맨드를 입력하시오");
      System.out.println("1.등록 2.검색 3.수정 4.삭제 5.전체출력 6.종료");
      System.out.println("==============================================");

      command = sc.nextInt();

      loop:
      switch (command) {
        case 1:
          System.out.println("= 등 록 =");
          if (count >= 30) {
            System.out.println("정원 초과로 입력 불가합니다.");
            continue;
          } else {
            System.out.println(count + 1 + "번 째 등록(!최대 30)");
            man[count] = new guest();
            System.out.print("이름     : ");
            man[count].name = sc.next();
            for (int i = 0; i < count; i++) {
              if (man[count].name.equals(man[i].name)) {
                System.out.println("!!!중복 이름 입력 불가");
                break loop; //loop로 회귀
              }
            }
            System.out.print("전화번호 : ");
            man[count].call = sc.nextInt();
            System.out.print("주소     : ");
            man[count].adr = sc.next();
            count++;
            continue;
          }


        case 2:
          System.out.println("= 검 색 =");
          System.out.print("검색할 이름: ");
          search = sc.next();
          for (int i = 0; i < count; i++) {
            if (man[i].name.equals(search)) {
              System.out.println(i + 1 + "번 >> " + "이름 : " + man[i].name +
                  "   전화번호 : " + man[i].call + "   주소 : " + man[i].adr);
              break loop;
            }
          }
          System.out.println("찾을 수 없습니다.");
          continue;


        case 3:
          System.out.println("= 수 정 =");
          System.out.print("수정할 번호 입력 :");
          revNum = sc.nextInt() - 1;

          if (revNum > count) {
            System.out.println("!!!없는 번호입니다.");
            break loop;
          } else {
            System.out.print("이름     : ");
            search = sc.next();
            for (int i = 0; i < count; i++) {
              if (search.equals(man[i].name)) {
                System.out.println("!!!중복 이름 입력 불가");
                break loop; //loop로 회귀
              }
            }
            man[revNum].name = search;
            System.out.print("전화번호 : ");
            man[revNum].call = sc.nextInt();
            System.out.print("주소     : ");
            man[revNum].adr = sc.next();
          }
          continue;


        case 4:
          System.out.println("= 삭 제 =");
          System.out.print("삭제할 번호 : ");
          for (delNum = sc.nextInt() - 1; delNum < count - 1; delNum++) {
            man[delNum].name = man[delNum + 1].name;
            man[delNum].call = man[delNum + 1].call;
            man[delNum].adr  = man[delNum + 1].adr;
          }
          count--;

          continue;


        case 5:
          System.out.println("= 전 체 출 력 =");
          System.out.println("현재 " + count + "명 등록 되어있습니다.");

          for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + "번 >> " + "이름 : " + man[i].name +
                "   전화번호 : " + man[i].call + "   주소 : " + man[i].adr);
          }
          continue;


        case 6:
          System.out.println("= 종 료 =");
          set = false;
          break;


        default:
          System.out.println("!!! 없는 커맨드입니다 !!!");
          continue;

      }
    }
  }
}
