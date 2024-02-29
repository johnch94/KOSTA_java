package p0223.Member;

import p0223.Member.vo.Person;
import p0223.Member.vo.Prof;
import p0223.Member.vo.Staff;
import p0223.Member.vo.Student;

import java.util.Scanner;

// member 기능,
public class MemService {
  // 세션에 저장할 값. 세션 : 연결유지
  public static String LoginId = ""; // 이 값이 비어있으면 logout 상태
  public static int LoginType;
  private univDAO dao;
  Scanner sc = new Scanner(System.in);

  public MemService(){
    dao = new univDAO();
  }

  // 회원가입
  public void addMember(Scanner sc){
    boolean flag = true;
    System.out.println("회원가입 ======");
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("비밀번호 : ");
    String pw = sc.next();
    System.out.print("학과/부서 : ");
    String dept = sc.next();
    System.out.println("===============");
    System.out.println("가입 유형");
    System.out.println("1. 교직원");
    System.out.println("2. 교수");
    System.out.println("3. 학생");
    System.out.println("===============");

    Person p = null;
    int n =sc.nextInt();
    switch (n) {
      case 1:
        System.out.println("직무 : ");
        String job = sc.next();
        p = new Staff(name, pw, dept, job);
        break;

      case 2:
        System.out.println("담당 학생 입력 :");
        String[] s = new String[5];
        for(int i=0; i<s.length; i++){
          s[i] = sc.next();
        }
        p = new Prof(name,pw,dept,s);
        break;

      case 3:
        System.out.println("지도 교수 입력 : ");
        String sp = sc.next();
        p = new Student(name, pw, dept, sp);
        break;

      default:
        System.out.println("잘못된 타입입니다.");
        break;
    }
    dao.insert(p);
  }

  public void printAll(){
    Person[] arr = dao.getMembers();
    for (int i=0; i<dao.getCnt(); i++){
      System.out.println(arr[i]);
    }
  }

  // 로그인
  public boolean login(Scanner sc){
    System.out.println("로그인 ======");
    System.out.print("Id : ");
    String num = sc.next();
    System.out.print("pw : ");
    String pw = sc.next();

    Person p = new Person();
    p.setIdNum(num);
    p.setPwd(pw);
    int idx = dao.search(p);
    dao.selectByIdx(idx);

    if(idx<0){
      System.out.println("로그인 실패");
    }else {
      System.out.println("로그인 성공");
      Person p2 = dao.selectByIdx(idx);
      LoginType = p2.getPersonType();
      LoginId = num;
      return true;
    }
    return false;
  }
  // 내정보확인
public void printMyInfo(Scanner sc){
  System.out.println("내정보 ======");
  System.out.print("Id : ");
  String num = sc.next();
  System.out.print("pw : ");
  String pw = sc.next();

  Person p = new Person();
  p.setIdNum(num);
  p.setPwd(pw);
  int idx = dao.search(p);
  dao.selectByIdx(idx);

  if(idx<0){
    System.out.println("없는 정보");
  }else {
    Person p2 = dao.selectByIdx(idx);
    System.out.println(p2);
  }
}
  // 내정보수정(pwd)
  public void editMember(Scanner sc){
    System.out.println("내정보 수정(pw) ======");
    System.out.print("pw : ");
    String pw = sc.next();
    Person p = new Person();
    p.setIdName(LoginId);
    p.setPwd(pw);
    int idx = dao.search(p);

    if(idx<0){
      System.out.println("없는 정보");
    }else {
      Person p2 = dao.selectByIdx(idx);
      System.out.print("new PW : ");
      p2.setPwd(sc.next());
      System.out.print("수정 결과 : ");
      System.out.println(p2);
    }
  }

  // 로그아웃
public void logout(){
    LoginId = "";
}
  // 탈퇴
public void out(Scanner sc){
  System.out.println("탈퇴 ======");
  System.out.print("pw : ");
  String pw = sc.next();
  Person p = new Person();
  p.setIdName(LoginId);
  p.setPwd(pw);
  int idx = dao.search(p);

  if(idx<0){
    System.out.println("없는 정보");
  }else {
    dao.delete(idx);
  }
}
  // 교직원(직무변경), 학생(지도교수 변경)
public void editJob(Scanner sc){
    String title = LoginType==1? "직무변경" : "지도교수 변경";
    System.out.println("=== " + title + " ===");
    System.out.print("pwd : ");
    String pwd = sc.next();
    Person p = new Person();
    p.setIdName(LoginId);
    p.setPwd(pwd);
    int idx = dao.search(p);
    if(idx < 0){
      System.out.println("없는 정보");
    } else {
      Person p2 = dao.selectByIdx(idx);
      if(LoginType==1){ // 교직원
        ((Staff)p2).setJob(sc.next());
      } else { // 지도교수 변경
        ((Student)p2).setMyProf(sc.next());
      }
    }
  }

  // 교수 (지도학생 변경)
  public void editStudent(Scanner sc){
    System.out.println("=== 지도학생 변경 ===");
    System.out.print("pwd : ");
    String pwd = sc.next();
    Person p = new Person();
    p.setIdName(LoginId);
    p.setPwd(pwd);
    int idx = dao.search(p);
    if(idx < 0){
      System.out.println("없는 정보");
    } else {
      Person p2 = dao.selectByIdx(idx);
      System.out.println("지도학생 5명 입력:");
      String[] name = new String[5];
      for(int i=0; i<name.length; i++){
        name[i] += sc.next();
      }
      ((Prof)p2).setMyStudent(name);
    }

  }

}
