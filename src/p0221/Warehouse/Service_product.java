package p0221.Warehouse;

import java.util.Scanner;

public class Service_product {
  private DAO_product dao = new DAO_product();

  public void addItem(Scanner sc){
    System.out.println("추가");
    
  }
  public void searchItem(Scanner sc){
    System.out.println("검색");
  }
  public void editItem(Scanner sc){
    System.out.println("수정");
  }
  public void deleteItem(Scanner sc){
    System.out.println("삭제");
  }
  public void printAllItem(){
    System.out.println("전체 목록");
  }
}
