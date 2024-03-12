package JDBC.Board;

import JDBC.ADDR.Addr;
import JDBC.mem.MemService;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService {
  private BoardDao dao;
  public BoardService(){
    dao = new BoardDao();
  }
  // 글작성
  public void addBoard(Scanner sc){
    System.out.println("=== 글 작성===");
    System.out.print("글 제목 :");
    String title = sc.next();
    System.out.println("글 내용 :");
    sc.nextLine();
    String content = sc.nextLine();
    dao.insert(new Board(0, MemService.LoginId, null, content, title));
    System.out.println(dao.selectByTitle(title));
  }

  // 글 번호로 검색
  public void printByNum(Scanner sc){
    System.out.println("=== 글번호로 검색 ===");
    System.out.print("번호 입력 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      System.out.println(dao.select(num));
      if(MemService.LoginId.equals(dao.select(num).getWriter())){ // 로그인 id 와 글쓴이가 같은가
        System.out.println("1. 수정   2.삭제  3.상세페이지종료");
        int x = sc.nextInt();
        switch (x){
          case 1:
            editBoard(sc, num);
            break;
          case 2:
            delBoard(sc, num);
            break;
          case 3:
            break;
        }
      }
    } else {
      System.out.println("없는 번호");
    }
  }

  // 제목으로 검색
  public void printByTitle(Scanner sc){
    System.out.println("=== 제목으로 검색 ===");
    System.out.print("제목 입력 : ");
    String title = sc.next();
    ArrayList<Board> list = dao.selectByTitle(title);
    if(!list.isEmpty()){
      for(Board b : list){
        System.out.println(b);
      }
    } else {
      System.out.println("결과 없음");
    }
  }

  // 작성자로 검색
  public void printByWriter(Scanner sc){
    System.out.println("=== 작성자로 검색 ===");
    System.out.print("작성자 입력 : ");
    String writer = sc.next();
    ArrayList<Board> list = dao.selectByWriter(writer);
    if(!list.isEmpty()){
      for (Board b : list){
        System.out.println(b);
      }
    } else {
      System.out.println("결과 없음");
    }
  }

  // 전체 목록
  public void printAll(){
    System.out.println("=== 전체 목록 ===");
    ArrayList<Board> list = dao.selectAll();
    for(Board b : list){
      System.out.println(b);
    }
  }

  // 수정(글 번호로 찾아서 제목/내용 수정) : 본인것 제외 삭제 못하게 num 필터 필요
  public void editBoard(Scanner sc, int num){
    System.out.println("=== 수정 ===");
    System.out.print("new title : ");
    sc.nextLine();
    String title = sc.nextLine();
    System.out.print("new contents : ");
    sc.nextLine();
    String content = sc.nextLine();
    dao.update(new Board(num,"", null, content, title ));
  }

  // 글 번호로 삭제
  public void delBoard(Scanner sc, int num){
    System.out.println("=== 글 삭제 ===");
    dao.delete(num);
  }
}
