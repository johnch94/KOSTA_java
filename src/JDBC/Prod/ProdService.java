package JDBC.Prod;

import JDBC.mem.MemService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdService {
  private ProdDao dao;
  public ProdService(){
    dao = new ProdDao();
  }
  // 상품등록
  public void addProd(Scanner sc){
    System.out.println("=== 상품 등록===");
    System.out.print("상품명 : ");
    String name = sc.next();
    System.out.print("가격 : ");
    int price = sc.nextInt();
    System.out.print("수량 : ");
    int amount = sc.nextInt();
    dao.insert(new Prod(0, name, price, amount, ""));
  }

  // 번호로 검색 - 1개 검색됨
  public void printByNum(Scanner sc){
    System.out.println("=== 번호로 검색 ===");
    System.out.print("번호 : ");
    int num = sc.nextInt();
    if (dao.select(num) != null){
      System.out.println(dao.select(num));
      if(MemService.LoginId.equals(dao.select(num).getSeller())){
        System.out.println("1.수정  2.삭제  3.상세페이지 종료");
        int x = sc.nextInt();
        switch (x){
          case 1:
            editProd(sc, num);
            break;
          case 2:
            delProd(sc, num);
            break;
          case 3:
            break;
        }
      }
    }  else {
      System.out.println("검색 실패");
    }
  }

  // 상품명으로 검색 - 여러개 검색됨
  public void printByName(Scanner sc){
    System.out.println("=== 상품명으로 검색 ===");
    System.out.print("상품명 : ");
    String name = sc.next();
    ArrayList<Prod> list = dao.selectByName(name);
    if(!list.isEmpty()){
      for(Prod p : list){
        System.out.println(p);
      }
    } else {
      System.out.println("검색 실패");
    }
  }

  // 가격대로 검색 - 여러개 검색됨
  public void printByPrice(Scanner sc){
    System.out.println("=== 가격대로 검색 ===");
    System.out.print("min : ");
    int min = sc.nextInt();
    System.out.print("max : ");
    int max = sc.nextInt();
    ArrayList<Prod> list = dao.selectByPrice(min,max);
    if(!list.isEmpty()){
      for(Prod p : list){
        System.out.println(p);
      }
    } else {
      System.out.println("검색 실패");
    }
  }

  // 전체 목록
  public void printAll(){
    System.out.println("=== 전체 목록 ===");
    ArrayList<Prod> list = dao.selectAll();
    for(Prod p : list){
      System.out.println(p);
    }
  }

  // 입출고 (번호로 검색해서 파람으로 수량을 받아 음수 출고 / 양수 입고)
  public void amountIO(Scanner sc){
    System.out.println("=== 상품 입출고 ===");
    System.out.print("num : ");
    int num = sc.nextInt();
    System.out.print("amount : ");
    int amount = sc.nextInt();
    int amount2 = dao.select(num).getAmount();
    if(amount>0){
      System.out.println("--- 입고 ---");
      dao.amoutIO(amount + amount2, num);
    } else {
      System.out.println("--- 출고 ---");
      if(amount + amount2 < 0){
        System.out.println("재고가 부족합니다. 현재 제고 : " + amount2);
      } else {
        dao.amoutIO(amount2+amount, num);
      }
    }
  }

  // 수정 (번호로 검색해서 상품명, 가격 수정)
  public void editProd(Scanner sc, int num){
    System.out.println("=== 상품 수정 ===");
    System.out.print("가격 : ");
    int price = sc.nextInt();
    System.out.print("수량 : ");
    int amount = sc.nextInt();
    dao.update(new Prod(num, "", price, amount, MemService.LoginId));
  }

  // 삭제 (번호로 검색해서 삭제)
  public void delProd(Scanner sc, int num){
    System.out.println("=== 상품 삭제 ===");
    dao.delete(num);
  }
}
