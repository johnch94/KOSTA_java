package p0226.ArrayListProduct;

import p0226.ArrayListProduct.Product.ProductService;

import java.util.Scanner;

public class Menu {
  private ProductService pservice;

  public Menu(){
    pservice = new ProductService();
  }
  public void run(Scanner sc){
    boolean flag = true;
    while (flag){
      System.out.println("1. 공장  2. 편의점  3. 종료");
      int m = sc.nextInt();
      switch (m){
        case 1:
          run_p(sc);
          break;
        case 2:
          run_c(sc);
          break;
        case 3:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }
  public void run_p(Scanner sc){
    boolean flag = true;
    int m;
    while (flag){
      System.out.println("1.등록 2.전체목록 3.번호로검색 4.제품명으로검색 5.가격대로검색 6.수정 7.삭제 8.종료");
      m = sc.nextInt();
      switch (m){
        case 1:
          pservice.addProd(sc);
          break;
        case 2:
          pservice.printAll();
          break;
        case 3:
          pservice.printProd(sc);
          break;
        case 4:
          pservice.getByName(sc);
          break;
        case 5:
          pservice.getByPrice(sc);
          break;
        case 6:
          pservice.editProduct(sc);
          break;
        case 7:
          pservice.delProduct(sc);
          break;
        case 8:
          flag = false;
          break;
      }
    }
  }
  public void run_c(Scanner sc){
    boolean flag = true;
    while (flag){
      System.out.println("1.편의점 메뉴 준비중  2. 편의점  3. 종료");
      int m = sc.nextInt();
      switch (m){
        case 1:

          break;
        case 2:

          break;
        case 3:
          System.out.println("종료...");
          flag = false;
          break;
      }
    }
  }
}
