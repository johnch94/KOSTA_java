package JDBC.Board;

import JDBC.ADDR.Addr;

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
    String content = sc.nextLine();
    dao.insert(new Board(0, "", null, content, title));
    System.out.println(dao.selectByTitle(title));
  }

  // 글 번호로 검색
  public void printByNum(Scanner sc){
    System.out.println("=== 글번호로 검색 ===");
    System.out.print("번호 입력 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      System.out.println(dao.select(num));
    } else {
      System.out.println("없는 번호");
    }
  }

  // 제목으로 검색
  public void printByTitle(Scanner sc){
    System.out.println("=== 제목으로 검색 ===");
    System.out.print("제목 입력 : ");
    String title = sc.next();
    if(dao.selectByTitle(title) != null){
      System.out.println(dao.selectByTitle(title));
    } else {
      System.out.println("없는 제목");
    }
  }

  // 작성자로 검색
  public void printByWriter(Scanner sc){
    System.out.println("=== 작성자로 검색 ===");
    System.out.print("작성자 입력 : ");
    String writer = sc.next();
    if(dao.selectByWriter(writer) != null){
      System.out.println(dao.selectByWriter(writer));
    } else {
      System.out.println("없는 작성자");
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

  // 수정(글 번호로 찾아서 제목/내용 수정)
  public void editBoard(Scanner sc){
    System.out.println("=== 수정 ===");
    System.out.print("수정할 글 번호 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      System.out.print("new title : ");
      String title = sc.next();
      System.out.print("new contents : ");
      sc.nextLine();
      String content = sc.nextLine();

      dao.update(new Board(num,"", null, content, title ));
      System.out.println("수정 완료");
      System.out.println(dao.select(num));
    } else {
      System.out.println("없는 번호");
    }
  }

  // 글 번호로 삭제
  public void delBoard(Scanner sc){
    System.out.println("=== 글 삭제 ===");
    System.out.print("삭제할 번호 : ");
    int num = sc.nextInt();
    if(dao.select(num) != null){
      dao.delete(num);
      System.out.println("삭제 완료");
    } else {
      System.out.println("없는 번호");
    }
  }
}
