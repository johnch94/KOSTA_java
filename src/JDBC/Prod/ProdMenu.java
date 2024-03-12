package JDBC.Prod;

import JDBC.mem.MemService;

import java.util.Scanner;

public class ProdMenu {
  private MemService mservice;
  private ProdService pservice;

  public ProdMenu(){
    mservice = new MemService();
    pservice = new ProdService();
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
      System.out.println("1.내정보확인  2.내정보수정  3.로그아웃  4.탈퇴  5.상품관리  6.종료");
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
          runProd(sc);
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


  public void runProd(Scanner sc){
    boolean flag = true;
    while (flag){
      System.out.println("1.상품 등록  2.번호로 검색  3.상품명으로 검색  4.가격대로 검색");
      System.out.println("5.전체 목록  6.입출고  7.종료");
      int m = sc.nextInt();
      switch (m){
        case 1:
          pservice.addProd(sc);
          break;
        case 2:
          pservice.printByNum(sc);
          break;
        case 3:
          pservice.printByName(sc);
          break;
        case 4:
          pservice.printByPrice(sc);
          break;
        case 5:
          pservice.printAll();
          break;
        case 6:
          pservice.amountIO(sc);
          break;
        case 7:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }
}
