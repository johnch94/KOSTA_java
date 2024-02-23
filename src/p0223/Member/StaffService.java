package p0223.Member;

import java.util.Scanner;

public class StaffService {
  private StaffDao dao;
  public StaffService(){
    dao = new StaffDao();
  }

  //등록
  public void addSubs(Scanner sc){
    System.out.println("=== 과목등록 ===");
    System.out.print("이름 : ");
    String name = sc.next();
    dao.insert(new subject(name));
  }

  //코드로 검색하여 출력
  public void search(Scanner sc){
    System.out.println("=== 과목검색 ===");
    System.out.print("코드 : ");
    int idx = sc.nextInt();
    subject s = dao.select2(idx);
    if(s==null){
      System.out.println("찾을 수 없다.");
    }else{
      System.out.println(s);
    }
  }

  //과목 전체 출력
  public void printAll(){
    System.out.println("=== 과목 전체 출력 ===");
    subject[] arr = dao.getSubs();
    for(int i=0; i<dao.getCnt();i++){
      System.out.println(arr[i]);
    }
  }

  //과목명 수정
  public void editSubs(Scanner sc){
    System.out.println("=== 과목명 수정===");
    System.out.print("코드 : ");
    int idx = sc.nextInt();
    subject s = dao.select2(idx);
    if(s==null){
      System.out.println("찾을 수 없다.");
    }else{
      System.out.println("수정 전 : " + s);
      String name = sc.next();
      s.setName(name);
      System.out.println("수정 후 : " + s);
    }
  }


  //과목 삭제(flag가 false인 것만 가능)
  public void delSubs(Scanner sc){
    System.out.println("=== 과목 삭제 ===");
    System.out.print("코드 : ");
    int idx = sc.nextInt();
    subject s = dao.select2(idx);
    if(s==null){
      System.out.println("찾을 수 없다.");
    }else{
      if(s.isFlag()){ // flag 는 개설여부를 확인한다
        System.out.println("개설된 과목은 삭제불가");
      }else{
        int code = dao.select(idx);
        dao.delete(code);
      }
    }
  }
  //////// 다른 메뉴에서 사용할 기능

  //코드로 검색하여 객체 반환

  //개설 유무로 검색한 리스트 반환

  //교수 num으로 검색하여 리턴

}
