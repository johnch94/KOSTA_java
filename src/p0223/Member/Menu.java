package p0223.Member;

import java.util.Scanner;

public class Menu {
  private MemService mservice;
  private StaffService sservice;

  public Menu(){
    mservice = new MemService();
  }

  // 상위 메뉴
  public  void run(Scanner sc){
    boolean flag = true;
    int m =0;
    if(MemService.LoginId.equals("")){ // 로그인 안된 상태
      while (flag){
        System.out.println("1.회원가입   2.로그인   3.종료");
        m = sc.nextInt();
        switch (m){
          case 1:
            mservice.addMember(sc);
            break;
          case 2:
            boolean f = mservice.login(sc);
            if(f){
              run(sc); // 재귀 호출
            }
            break;
          case 3:
            flag=false;
            break;
        }
      }
    } else { // 로그인 한 상태
      String[] title = {"교직원", "교수", "학생"};
      while (flag){
        System.out.println("1.멤버메뉴   2." + title[MemService.LoginType-1] + " 메뉴   3.종료");
        m = sc.nextInt();
        switch (m){
          case 1:
            run_m(sc);
            break;
          case 2:
            switch (MemService.LoginType){
              case 1:
                run_s(sc);
                break;
              case 2:
                run_p(sc);
                break;
              case 3:
                run_st(sc);
                break;
            }
            break;
          case 3:
            flag = false;
            break;
        }
      }
    }
  }

  // 하위 메뉴 - 멤버
  public void run_m(Scanner sc){
    System.out.println("=== 멤버 메뉴===");
    boolean flag = true;
    int m =0;
    String[] title = {"직무변경", "지도학생 변경", "지도교수 변경"};
    while (flag) {
      System.out.println("1.내정보확인 2.내정보수정 3.로그아웃 4.탈퇴 5." + title[MemService.LoginType-1] + " 6.종료");
      m = sc.nextInt();
      switch (m) {
        case 1:
          mservice.printMyInfo(sc);
          break;
        case 2:
          mservice.editMember(sc);
          break;
        case 3:
          mservice.logout();
          break;
        case 4:
          mservice.out(sc);
          break;
        case 5:
          if(MemService.LoginType==2){
            mservice.editStudent(sc);
          }else{
            mservice.editJob(sc);
          }
          break;
        case 6:
          System.out.println("종료");
          flag=false;
          break;
      }
    }
  }

  // 하위 메뉴 - 교직원
  public void run_s(Scanner sc){
    System.out.println("===교직원 메뉴===");
    boolean flag = true;

    int m = 0;
    while (flag){
      System.out.println("1.과목등록 2.검색 3.과목명수정 4.삭제 5.전체목록 6.종료");
      m = sc.nextInt();
      switch (m){
        case 1:
          sservice.addSubs(sc);
          break;
        case 2:
          sservice.search(sc);
          break;
        case 3:
          sservice.editSubs(sc);
          break;
        case 4:
          sservice.delSubs(sc);
          break;
        case 5:
          sservice.printAll();
          break;
        case 6:
          flag = false;
          break;
      }
    }

  }

  // 하위 메뉴 - 교수
  public void run_p(Scanner sc){
    System.out.println("===교수 메뉴===");

  }

  // 하위 메뉴 - 학생
  public void run_st(Scanner sc){
    System.out.println("===학생 메뉴===");

  }

}
