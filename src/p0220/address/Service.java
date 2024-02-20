package p0220.address;

import java.util.Scanner;

public class Service {
  private Dao dao = new Dao();
  public Service(){
    dao = new Dao();
  }
  public void addMember(Scanner sc){
    System.out.println("=== 추가 ===");
    String name;
    do{ // 중복탐색
      System.out.println("name : ");
      name = sc.next();
    }while (dao.search(name)>=0);
    System.out.println("tel : ");
    String tel = sc.next();
    System.out.println("address : ");
    String address = sc.next();

    Member m = new Member(name, tel, address);
    dao.add(m);
  }
  public void searchMember(Scanner sc){
    System.out.println("=== 검색 ===");
    String name = sc.next();
    int idx = dao.search(name);
    if (idx<0){
      System.out.println("not found");
    }else{
      Member[] mems = dao.getMems();
      System.out.println(mems[idx]);
    }
  }

  public void editMember(Scanner sc){ // 수정
    //수정할 사람 이름 입력받아서 검색
    //검색 결과가 음수 => 수정취소
    //양수 => 새 전화, 새 주소 입력받아서 수정
    System.out.println("수정할 사람 이름 입력 : ");
    String name = sc.next();
    if(dao.search(name)<0){
      System.out.println("없는 대상입니다.");
    }else{
      int tmp = dao.getCnt();
      dao.setCnt(dao.search(name));
      addMember(sc);
      dao.setCnt(tmp);
    }
  }

  public void delMember(Scanner sc){
    //삭제할 사람 이름 입력 받아서 검색
    //검색 결과가 음수 => 삭제 취소
    //양수 => dao.delete() 호출
    System.out.println("삭제할 사람 이름 입력: ");
    String delname = sc.next();
    if(dao.search((delname))<0){
      System.out.println("없는 대상입니다.");
    } else {
      dao.delete(dao.search(delname));
    }

  }

  public void printAll(){ // 전체 출력
    for(int i=0; i<dao.getCnt(); i++){
      Member[] mems = dao.getMems();
      System.out.println(mems[i]);
    }
  }
}
