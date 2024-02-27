package p0227.address;

import p0227.ObjectInputOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
  private Dao dao;
  public Service(){
    dao = new Dao();
  }
  public void addMember(Scanner sc){
    System.out.println("=== 추가 ===");
    String name;
    do{ // 중복탐색
      System.out.println("name : ");
      name = sc.next();
    }while (dao.search(name) != null);
    System.out.println("tel : ");
    String tel = sc.next();
    System.out.println("address : ");
    String address = sc.next();

    Member m = new Member(name, tel, address);
    dao.add(m);
  }
  public void searchMember(Scanner sc){
    System.out.println("=== 검색 ===");
    System.out.print("search name : ");
    String name = sc.next();
    Member m = dao.search(name);
    if (m == null){
      System.out.println("not found");
    }else{
      System.out.println(m);
    }
  }

  public void editMember(Scanner sc){ // 수정
    //수정할 사람 이름 입력받아서 검색
    //검색 결과가 음수 => 수정취소
    //양수 => 새 전화, 새 주소 입력받아서 수정
    System.out.print("수정할 사람 이름 입력 : ");
    String name = sc.next();
    Member m = dao.search(name);
    if(name == null){
      System.out.println("없는 대상입니다.");
    }else{
      System.out.println("new tel : ");
      m.setTel(sc.next());
      System.out.println("new address : ");
      m.setAddress(sc.next());
    }
  }

  public void delMember(Scanner sc){
    //삭제할 사람 이름 입력 받아서 검색
    //검색 결과가 음수 => 삭제 취소
    //양수 => dao.delete() 호출
    System.out.println("삭제할 사람 이름 입력: ");
    String name = sc.next();

    boolean flag = dao.delete(name);
    if(flag){
      System.out.println("삭제 완료");
    }else {
      System.out.println("삭제 취소");
    }
  }
  public void printAll(){ // 전체 출력
    ArrayList<Member> mems = dao.getMems();
    System.out.println("=== 전체 출력 ===");
    for(Member m : mems){
      System.out.println(m);
    }
  }
  private String path = "src/p0227/address/files/MemberData.dat";
  public void stop(){ // 종료 기능
    // ArrayList에 있는 모든 데이터를 파일에 씀
    ArrayList<Member> mems = dao.getMems();
    System.out.println("멤버 자료 저장중...");
    try {
      ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(path));
      for(Member m : mems){
        oo.writeObject(m);
      }
      oo.close();
      System.out.println("저장 완료");

    } catch (IOException e) {
      System.out.println("저장 실패");
      e.printStackTrace();
    }
  }

  public void start(){ // 시작 기능
    // 파일의 모든 값을 객체로 읽어서 ArrayList에 추가
    System.out.println("멤버 자료 불러오는 중...");
    try {
      FileInputStream fi = new FileInputStream(path);
      ObjectInputStream oi = new ObjectInputStream(fi);
      while (true){
        if(fi.available()==0){ // 기본스트림의 잔량을 체크해서 읽을 데이터가 없을 때 루프 탈출
          break;
        }
        Member m = (Member) oi.readObject();
        dao.add(m);
      }
      System.out.println("불러오기 완료");
      oi.close();
    } catch (EOFException e) {
      System.out.println("저장된 데이터 없음");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("저장된 데이터 없음");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("불러오기 실패 1");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("불러오기 실패 2");
      e.printStackTrace();
    }


  }
}
