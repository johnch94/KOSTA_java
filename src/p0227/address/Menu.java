package p0227.address;

import java.util.Scanner;

public class Menu {
  private Service service = new Service();

  public void run(Scanner sc){
    boolean flag = true;
    int menu;
    service.start();
    while (flag){
      System.out.println("1.추가 2.검색 3.수정 4.삭제 5.전체출력 6.종료");
      menu = sc.nextInt();

      switch (menu){
        case 1: // 멤버 추가
          service.addMember(sc);
          break;
        case 2: // 검색
          service.searchMember(sc);
          break;
        case 3: // 수정
          service.editMember(sc);
          break;
        case 4: // 삭제
          service.delMember(sc);
          break;
        case 5: // 전체출력
          service.printAll();
          break;
        case 6:
          service.stop();
          System.out.println("=== 종료 ===");
          flag = false;
          break;
        default:
          break;

      }
    }
  }

}
