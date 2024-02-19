package p0219;

import java.util.Scanner;

class Dao{ // DB 데이터 처리 클래스, 배열에 추가, 삭제, 읽기 등을 구현
  Member[] mems = new Member[30];
  int cnt=0;

  void add(Member m){ // 파라메터로 Member 객체 받아서 배열에 추가
    if(mems.length == cnt){
      System.out.println("배열에 남은 자리 없음");
    }else{
      mems[cnt] = m;
      cnt ++;
    }
  }

  int search(String name){ // 검색할 이름 param으로 받아 배열에서 위치 반환
     for(int i=0; i<cnt; i++){
       if(mems[i].name.equals(name)){
         return i;
       }
     }
     return -1;
  }

  void delete(int idx){ // 삭제할 방번호 param으로 받아서 한칸씩 앞으로 이동
    for(int i = idx; i<cnt; i++){
      mems[i] = mems[i+1];
    }
    cnt--;
  }
}
class Services{ // 사용자에게 제공할 기능 구현
  Dao dao = new Dao();

  void addMember(Scanner sc){
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
  void searchMember(Scanner sc){
    System.out.println("=== 검색 ===");
    String name = sc.next();
    int idx = dao.search(name);
    if (idx<0){
      System.out.println("not found");
    }else{
      dao.mems[idx].PrintData();
    }
  }
  void editMember(Scanner sc){ // 수정
    //수정할 사람 이름 입력받아서 검색
    //검색 결과가 음수 => 수정취소
    //양수 => 새 전화, 새 주소 입력받아서 수정
    System.out.println("수정할 사람 이름 입력 : ");
    String edname = sc.next();
        if(dao.search(edname)<0){
      System.out.println("없는 대상입니다.");
    }else{
      int tmp = dao.cnt;
      dao.cnt = dao.search(edname);
      addMember(sc);
      dao.cnt = tmp;
    }
  }

  void delMember(Scanner sc){
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

  void printAll(){ // 전체 출력
    for(int i=0; i<dao.cnt; i++){
      dao.mems[i].PrintData();
    }
  }

}
class Menu{ // menu => controller
  Services service = new Services();

  void run(Scanner sc){
    boolean flag = true;
    int menu;
    while (flag){
      System.out.println("1.추가 2.검색 3.수정 4.삭제 5.전체출력 6.종료");
      menu = sc.nextInt();

      switch (menu){
        case 1: // 멤버 추가
          service.addMember(sc);
          break;
        case 2: // 검색
          service.searchMember(sc);
          break;
        case 3: // 수정
          service.editMember(sc);
          break;
        case 4: // 삭제
          service.delMember(sc);
          break;
        case 5: // 전체출력
          service.printAll();
          break;
        case 6:
          System.out.println("=== 종료 ===");
          flag = false;
          break;
        default:
          break;

      }
    }
  }

}

class Member{ //VO (Value Object)
  String name;
  String tel;
  String address;

  Member(String name, String tel, String address){
    this.name = name;
    this.tel = tel;
    this.address = address;
  }
  void PrintData(){
    System.out.println("name    : " + name);
    System.out.println("tel     : " + tel);
    System.out.println("address : " + address);
  }
}
public class Methotd_Address {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Menu m = new Menu();
    m.run(sc);

  }
}
