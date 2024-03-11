package JDBC.Board;

import JDBC.mem.MemService;

import java.util.Scanner;

public class BoardMenu {
  private MemService mservice;
  private BoardService bservice;
  public BoardMenu(){
    mservice = new MemService();
    bservice = new BoardService();
  }

  // 전체 메뉴
  public void run(Scanner sc){
    while (true){
      System.out.println("종료는 0");
      int m = sc.nextInt();
      if(m == 0) {
        break;
      }
      if(mservice.LoginId == null){
        runMemLogout(sc);
      } else{
        runMemLogin(sc);
      }
    }
  }

  // 로그인 헀을 때 메뉴
  public void runMemLogin(Scanner sc){
    boolean flag = true;
    while (flag){
      System.out.println("1.내정보확인  2.내정보수정  3.로그아웃  4.탈퇴  5.게시판  6.종료");
      int m =sc.nextInt();
      switch (m){
        case 1:
          mservice.printMem();
          break;
        case 2:
          mservice.editMem(sc);
          break;
        case 3:
          mservice.logout();
          return;
        case 4:
          mservice.delMem();
          return;
        case 5:
          runBaord(sc);
          break;
        case 6:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }

  // 로그인 안했을 때 메뉴
  public void runMemLogout(Scanner sc){
    boolean flag = true;
    while (flag) {
      System.out.println("1.로그인  2.회원가입  3.종료");
      int m =sc.nextInt();
      switch (m){
        case 1:
          flag = !mservice.login(sc);
          break;
        case 2:
          mservice.addMem(sc);
          break;
        case 3:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }

  /**
   * 게시판 메뉴
   * 1. 글작성 (제목, 내용만 입력받음)
   * 2. 글번호로 검색
   * 3. 제목으로 검색(like)
   * 4. 작성자로 검색
   * 5. 전체목록
   * 6. 수정(글번호로 찾아서 제목/내용 수정)
   * 7. 글번호로 삭제
   * 8. 종료
   */
  public void runBaord(Scanner sc){
    boolean flag = true;
    while (flag){
      System.out.println("1.글작성  2.번호로검색  3.제목으로검색  4.작성자로검색");
      System.out.println("5.전체목록  6.수정  7.번호로삭제  8.종료");
      int m = sc.nextInt();
      switch (m){
        case 1:
          bservice.addBoard(sc);
          break;
        case 2:
          bservice.printByNum(sc);
          break;
        case 3:
          bservice.printByTitle(sc);
          break;
        case 4:
          bservice.printByWriter(sc);
          break;
        case 5:
          bservice.printAll();
          break;
        case 6:
          bservice.editBoard(sc);
          break;
        case 7:
          bservice.delBoard(sc);
          break;
        case 8:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }
}
