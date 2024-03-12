package JDBC.Prod;

import JDBC.Board.Board;
import JDBC.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdDao {
  DBConnect db;
  public ProdDao(){
    db = DBConnect.getInstance();
  }

  // insert
  public void insert(Prod p){
    Connection conn = db.conn();
    String sql = "insert into prod values (seq_prod.nextval, ?, ?, ?, null)";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, p.getName());
      pstmt.setInt(2, p.getPrice());
      pstmt.setInt(3, p.getAmount());
      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 추가됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // update
  public void update(Prod p){
    Connection conn = db.conn();
    String sql = "update prod set name=?, price=? where num=?";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, p.getName());
      pstmt.setInt(2, p.getPrice());
      pstmt.setInt(3, p.getNum());
      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 수정됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  // delete
  public void delete(int num){
    Connection conn = db.conn();
    String sql = "delete prod where num = ?";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);
      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 삭제됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // select
  public Prod select(int num){
    Connection conn = db.conn();
    String sql = "select * from prod where num=?";
    Prod p = null;
    try {
      PreparedStatement prtmt = conn.prepareStatement(sql);
      prtmt.setInt(1, num);
      ResultSet rs = prtmt.executeQuery();
      if(rs.next()) {
        return new Prod(rs.getInt(1), rs.getString(2), rs.getInt(3),
            rs.getInt(4), rs.getString(5));
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
    return p;
  }

  // selectAll
  public ArrayList<Prod> selectAll(){
    Connection conn = db.conn();
    String sql = "select * from prod";
    ArrayList<Prod> list = new ArrayList<>();
    try {
      PreparedStatement prtmt = conn.prepareStatement(sql);
      ResultSet rs = prtmt.executeQuery();
      while (rs.next()) {
        list.add(new Prod(rs.getInt(1), rs.getString(2), rs.getInt(3),
            rs.getInt(4), rs.getString(5)));
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

  // selectByName
  public ArrayList<Prod> selectByName(String name){
    Connection conn = db.conn();
    String sql = "select * from prod where name like ? order by num";
    ArrayList<Prod> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareCall(sql);
      pstmt.setString(1, "%" + name +"%");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Prod(rs.getInt(1), rs.getString(2), rs.getInt(3),
            rs.getInt(4), rs.getString(5)));
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

  // selectByPrice
  public ArrayList<Prod> selectByPrice(int min, int max){
    Connection conn = db.conn();
    String sql = "select * from prod where price between ? and ?";
    ArrayList<Prod> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareCall(sql);
      pstmt.setInt(1, min);
      pstmt.setInt(2, max);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Prod(rs.getInt(1), rs.getString(2), rs.getInt(3),
            rs.getInt(4), rs.getString(5)));
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

  // amountIO
  public void amoutIO(int amount, int num){
    Connection conn = db.conn();
    String sql = "update prod set amount=? where num=?";
    int cnt = 0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, amount);
      pstmt.setInt(2, num);
      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 수정됨.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
