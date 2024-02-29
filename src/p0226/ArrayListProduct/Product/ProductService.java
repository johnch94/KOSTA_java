package p0226.ArrayListProduct.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
  private ProductDao dao;
  public ProductService(){
    dao = new ProductDao();
  }
  public void addProd(Scanner sc){
    System.out.println("===상품 등록===");
    System.out.print("name : ");
    String name = sc.next();
    System.out.print("price : ");
    int price = sc.nextInt();
    System.out.print("amount : ");
    int amount = sc.nextInt();

    dao.insert(new Product(name, price, amount));
  }

  public void printProd(Scanner sc){
    System.out.println("=== 상품 번호로 검색===");
    System.out.print("num : ");
    int num = sc.nextInt();
    Product p = dao.select(num);
    if(p==null){
      System.out.println("not found");
    }else{
      System.out.println(p);
    }
  }

  public void printAll(){
    System.out.println("=== 상품 목록 ===");
    ArrayList<Product> arr = dao.getList();
    for(Product p : arr){
      System.out.println(p);
    }
  }

  public void getByName(Scanner sc){
    System.out.println("=== 상품명으로 검색===");
    System.out.print("name : ");
    String name = sc.next();
    ArrayList<Product> arr = dao.selectName(name);
    for(Product p : arr){
      System.out.println(p);
    }
  }

  public void getByPrice(Scanner sc){
    System.out.println("=== 가격으로 검색 ===");
    System.out.print("하한가 : ");
    int p1 = sc.nextInt();
    System.out.print("상한가 : ");
    int p2 = sc.nextInt();
    ArrayList<Product> arr = dao.selectPrice(p1, p2);
    for(Product p : arr){
      System.out.println(p);
    }
  }

  public void editProduct(Scanner sc){
    System.out.println("=== 상품명 & 가격 수정 ===");
    System.out.print("수정할 제품 num : ");
    int num = sc.nextInt();

    Product p = dao.select(num);
    if(p==null){
      System.out.println("not found");
    }else{
      System.out.print("new name : ");
      p.setName(sc.next());
      System.out.print("new price : ");
      p.setPrice(sc.nextInt());
    }
  }

  public void delProduct(Scanner sc){
    System.out.println("=== 상품삭제 ===");
    System.out.print("삭제할 제품 num : ");
    int num = sc.nextInt();

    boolean flag = dao.delete(num);
//    if(flag){
//      System.out.println("삭제 완료");
//    }else {
//      System.out.println("삭제 취소");
//    }
    System.out.println( flag ? "삭제 안료":"삭제 취소");
  }

  // 번호로 검색해서 삭제
  public void delProdNum(int num){
    dao.delete(num);
  }
}
