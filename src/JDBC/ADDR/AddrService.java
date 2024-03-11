package JDBC.ADDR;

import java.util.ArrayList;
import java.util.Scanner;

public class AddrService {
  private AddrDao dao;
  public AddrService(){
    dao = new AddrDao();
  }

  // 1명의 이름, 전화, 주소 입력받아서 db에 등록
  public void addAddr(Scanner sc){
    System.out.println("=== 등록 ===");
    System.out.print("name : ");
    String name = sc.next();
    System.out.print("tel : ");
    String tel = sc.next();
    System.out.print("addr : ");
    sc.nextLine(); // 버퍼에 남은 엔터 삭제목적
    String addr = sc.nextLine(); // nextLine은 개행문자도 포함해서 저장한다.

    dao.insert(new Addr(0,name, tel, addr));
    System.out.println("등록 완료");
    System.out.println(dao.selectByName(name));
  }

  // 수정할 사람 번호와 새 전화, 주소를 입력받아 db에서 수정
  public void editAddr(Scanner sc){
    System.out.println("=== 수정 ===");
    System.out.print("수정할 대상 번호: ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      System.out.print("new tel : ");
      String tel = sc.next();
      System.out.print("new addr : ");
      sc.nextLine();
      String addr = sc.nextLine();

      dao.update(new Addr(num,"",tel,addr));
      System.out.println("수정 완료");
      System.out.println(dao.select(num));
    } else {
      System.out.println("없는 번호");
    }
  }

  // 삭제할 사람 번호를 입력받아 db에서 삭제
  public void delAddr(Scanner sc){
    System.out.println("=== 삭제 ===");
    dao.selectAll();
    System.out.print("삭제할 대상 번호 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      dao.delete(num);
      System.out.println("삭제 완료");
    } else {
      System.out.println("없는 번호");
    }
  }

  // 검색할 사람 번호를 입력받아 db에서 검색하고 null이 아니면 출력
  public void printAddr(Scanner sc){
    System.out.println("=== 번호로 검색 ===");
    System.out.print("검색할 대상 번호 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      System.out.println(dao.select(num));
    } else {
      System.out.println("없는 번호");
    }
  }

  // 전체 주소 목록 출력
  public void printAll(){
    System.out.println("=== 전체 목록 ===");
    ArrayList<Addr> list = dao.selectAll();
    for(Addr a : list){
      System.out.println(a);
    }
  }

  // 이름으로 검색. 검색할 사람 이름 입력 받아서 db에서 이름으로 검색하고 결과를 출력
  public void printByName(Scanner sc){
    System.out.println("=== 이름으로 검색 ===");
    System.out.print("이름 : ");
    String name = sc.next();
    if(dao.selectByName(name)==null){
      System.out.println("없는 이름");
    }else {
      ArrayList<Addr> list = dao.selectByName(name);
      for(Addr a : list){
        System.out.println(a);
      }
    }
  }

  // 전화번호로 검색. 검색할 사람 번호 입력 받아서 db에서 번호 검색하고 결과를 출력
  public void printByTel(Scanner sc){
    System.out.println("=== 전화번호로 검색 ===");
    System.out.print("번호 : ");
    String tel = sc.next();
    if(dao.selectByTel(tel)==null){
      System.out.println("없는 이름");
    }else {
      ArrayList<Addr> list = dao.selectByTel(tel);
      for(Addr a : list){
        System.out.println(a);
      }
    }
  }
}
