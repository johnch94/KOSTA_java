package JDBC.mem;

import JDBC.DBConnect;

import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// dao(database access object) : db 작업
public class MemDao {
  private DBConnect db;

  public MemDao(){
    db = DBConnect.getInstance();
  }
  public void insert(mem m){
    Connection conn = db.conn();
    // 실행할 쿼리문 작성
    String sql = "insert into mem values(?,?,?,?)"; // ? 들어갈 변수를 나중에 지정하겠다
    try {
      // 자바에서 sql 쿼리문을 실행할 수 있는 객체 PreparedStatement 생성
      PreparedStatement pstmt = conn.prepareStatement(sql);
      // pstmt.set..(? index , value) 위 sql의 ? 에 들어갈 데이터
      pstmt.setString(1, m.getId());
      pstmt.setString(2, m.getPwd());
      pstmt.setString(3, m.getName());
      pstmt.setString(4, m.getEmail());
      // sql 실행
      int cnt = pstmt.executeUpdate(); // insert, update, delete 문장 실행후 추가된 줄 수 반환
      // pstmt.executeQuery(); // select문 실행, 검색한 결과를 ResultSet 으로 받는다
      System.out.println(cnt + " 줄 추가됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close(); // connection 마침
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public int update(mem m){ // id로 찾아서 pwd 수정
    Connection conn = db.conn();
    String sql = "update mem set pwd = ? where id = ?";
    int cnt =0;

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, m.getPwd());
      pstmt.setString(2, m.getId());

      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 수정됨");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cnt;
  }

  public int delete(String id){
    Connection conn = db.conn();
    String sql = "delete from mem where id=?";
    int cnt = 0;

    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, id);

      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 삭제됨");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cnt;
  }

  // pk 기준 검색 메서드는 반환타입은 vo, 파라메터는 pk 컬럼. mem 은 String id를 파람으로 받는다
  public mem select(String id){
    Connection conn = db.conn();
    String sql = "select * from mem where id=?";
    mem m = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,id);
      // select 는 executeQuerry() 로 실행
      // executeQuery()는 select를 실행학 검색결과를 ResultSet에 담아서 반환
      ResultSet rs = pstmt.executeQuery();
      // rs.next(): 다음 읽을 줄로 이동하는 메서드. boolean
      if(rs.next()){
        m = new mem();
        m.setId(rs.getString(1)); // 1번 컬럼의 문자열 값을 읽음
        m.setPwd(rs.getString(2)); // 2번 컬럼의 문자열 값을 읽음
        m.setName(rs.getString(3)); // 3번 컬럼의 문자열 값을 읽음
        m.setEmail(rs.getString(4)); // 4번 컬럼의 문자열 값을 읽음

        // 생성자에 바로 넣는 방법도 있다.
//        m = new mem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return m;
  }
  public ArrayList<mem> selectAll(){ // 전체 검색
    Connection conn = db.conn();
    String sql = "select * from mem";
    // ArrayList 생성
    ArrayList<mem> list= new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery(); // sql 실행
      // ResultSet 읽을 줄로 이동
      while (rs.next()){
        mem m = new mem();
        m.setId(rs.getString(1)); // 1번 컬럼의 문자열 값을 읽음
        m.setPwd(rs.getString(2)); // 2번 컬럼의 문자열 값을 읽음
        m.setName(rs.getString(3)); // 3번 컬럼의 문자열 값을 읽음
        m.setEmail(rs.getString(4)); // 4번 컬럼의 문자열 값을 읽음

        list.add(m);
        // list.add(new mem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
}
