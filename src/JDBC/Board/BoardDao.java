package JDBC.Board;

import JDBC.DBConnect;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
  private DBConnect db;
  public BoardDao(){
    db = DBConnect.getInstance();
  }
  // insert
  public int insert(Board b){
    Connection conn = db.conn();
    String sql = "insert into baord values(num,LoginId,sysdate,?,?)";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, b.getContent());
      pstmt.setString(2, b.getTitle());

      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 개 추가됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cnt;
  }

  // update
  public int update(Board b){
    Connection conn = db.conn();
    String sql = "update board set content=?, title=? where num=?";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, b.getContent());
      pstmt.setString(2, b.getTitle());
      pstmt.setInt(3, b.getNum());

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

  // delete
  public int delete(int num){
    Connection conn = db.conn();
    String sql = "delete board where num=?";
    int cnt = 0;
    try {
      PreparedStatement prtmt = conn.prepareStatement(sql);
      prtmt.setInt(1, num);

      cnt = prtmt.executeUpdate();
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

  // select
  public Board select(int num){
    Connection conn = db.conn();
    String sql = "select * from board where num=?";
    Board b = null;
    try {
      PreparedStatement prtmt = conn.prepareStatement(sql);
      prtmt.setInt(1, num);

      ResultSet rs = prtmt.executeQuery();
      if(rs.next()) {
        return new Board(rs.getInt(1), rs.getNString(2), rs.getDate(3),
            rs.getString(4), rs.getString(5));
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
    return b;
  }

  // selectAll
  public ArrayList<Board> selectAll(){
    Connection conn = db.conn();
    String sql = "select * from board order by num";
    ArrayList<Board> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareCall(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Board(rs.getInt(1), rs.getNString(2), rs.getDate(3),
            rs.getString(4), rs.getString(5)));
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

  // selectByTitle
  public ArrayList<Board> selectByTitle(String title){
    Connection conn = db.conn();
    String sql = "select * from board where like ?";
    ArrayList<Board> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareCall(sql);
      pstmt.setString(1, "%" + title +"%");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Board(rs.getInt(1), rs.getNString(2), rs.getDate(3),
            rs.getString(4), rs.getString(5)));
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

  // selectByWriter
  public ArrayList<Board> selectByWriter(String writer){
    Connection conn = db.conn();
    String sql = "select * from board where like ?";
    ArrayList<Board> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareCall(sql);
      pstmt.setString(1, "%" + writer +"%");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Board(rs.getInt(1), rs.getNString(2), rs.getDate(3),
            rs.getString(4), rs.getString(5)));
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
