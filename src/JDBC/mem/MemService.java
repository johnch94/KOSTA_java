package JDBC.mem;

import java.util.ArrayList;
import java.util.Scanner;

public class MemService {
  private MemDao dao;
  public static String LoginId;

  public MemService(){
    dao = new MemDao();
  }

  // 회원 가입
  public void addMem(Scanner sc){
    System.out.println("=== 회원가입 ===");
    String id ="";
    do {
      System.out.print("id : ");
      id = sc.next();
    } while (dao.select(id)!=null);
    System.out.print("pwd : ");
    String pwd = sc.next();
    System.out.print("name : ");
    String name = sc.next();
    System.out.print("email : ");
    String email = sc.next();
    dao.insert(new mem(id, pwd, name, email));
  }

  // 로그인
  public boolean login(Scanner sc){
    System.out.println("=== 로그인 ===");
    System.out.print("id : ");
    String id = sc.next();
    System.out.print("pwd : ");
    String pwd = sc.next();
    mem m = dao.select(id);
    boolean flag = false;
    if(m==null){
      System.out.println("없는 id");
    } else {
      if(pwd.equals(m.getPwd())){
        System.out.println("로그인 성공");
        LoginId = id;
        flag = true;
      } else {
        System.out.println("패스워드 실패");
      }
    }
    return flag;
  }

  // 로그아웃
  public void logout(){
    System.out.println("=== 로그아웃 ===");
    LoginId = null;
  }

  // pwd 수정
  public void editMem(Scanner sc){
    System.out.println("=== PW 변경 ===");
//    mem m = dao.select(id);
//    if (m==null){
//      System.out.println("없는 id");
//    } else {
//      System.out.print("변경할 pw : ");
//      m.setPwd(sc.next()); // 이미 m에 id로 호출했기때문에 나머지 정보는 들어있다.
//      dao.update(m);
//    }
    System.out.print("변경할 pw : ");
    String pwd = sc.next();
    int cnt = dao.update(new mem(LoginId, pwd, "", ""));
    if(cnt > 0){
      System.out.println("수정 완료");
    }else{
      System.out.println("수정 안됨");
    }
  }

  // 탈퇴
  public void delMem(){
    System.out.println("=== 회원 탈퇴 ===");
//    mem m = dao.select(id);
//    if(m == null){
//      System.out.println("없는 id");
//    } else {
//      System.out.println(id + " 삭제");
//      dao.delete(id);
//    }
    int cnt = dao.delete(LoginId);
    if(cnt > 0){
      System.out.println("삭제 완료");
      logout();
    }else{
      System.out.println("!!! 삭제 안됨");
    }
  }

  // 내정보확인
  public void printMem(){
    System.out.println("=== 내 정보 확인 ===");
    System.out.println(dao.select(LoginId));
  }

  // 회원 목록
  public void printAll(){
    System.out.println("=== 회원 목록 ===");
    ArrayList<mem> list = dao.selectAll();
    for(mem m : list){
      System.out.println(m);
    }
  }
}
