package JDBC.ADDR;

import JDBC.DBConnect;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddrDao {
  private DBConnect db;
  public AddrDao(){
    db = DBConnect.getInstance();
  }
  // insert
  public int insert(Addr a){
    Connection conn = db.conn();
    String sql = "insert into addr values (seq_addr.nextval, ?, ?, ?)";
    int cnt =0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, a.getName());
      pstmt.setString(2, a.getTel());
      pstmt.setString(3, a.getAddr());

      cnt = pstmt.executeUpdate();
      System.out.println(cnt + " 줄 추가됨");
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
  // update
  public int update(Addr a){
    Connection conn = db.conn();
    String sql = "update addr set tel=?, addr=? where num=?";
    int cnt =0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, a.getTel());
      pstmt.setString(2, a.getAddr());
      pstmt.setInt(3, a.getNumber());

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
    String sql = "delete addr where num=?";
    int cnt=0;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);
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

  // select
  public Addr select(int num){
  Connection conn = db.conn();
  String sql = "select * from addr where num=?";
  Addr a = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, num);

      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
//        a = new Addr();
//        a.setNumber(rs.getInt(1));
//        a.setName(rs.getString(2));
//        a.setTel(rs.getString(3));
//        a.setAddr(rs.getString(4));
        return new Addr(rs.getInt(1), rs.getString(2),
             rs.getString(3), rs.getString(4));
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
    return null;
  }

  // selectAll
  public ArrayList<Addr> selectAll(){
    Connection conn = db.conn();
    String sql = "select * from addr order by num";
    ArrayList<Addr> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()){
        list.add(new Addr(rs.getInt(1), rs.getString(2),
            rs.getString(3), rs.getString(4)));
//        Addr a = new Addr();
//        a.setNumber(rs.getInt(1));
//        a.setName(rs.getString(2));
//        a.setTel(rs.getString(3));
//        a.setAddr(rs.getString(4));
//
//        list.add(a);
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
  public ArrayList<Addr> selectByName(String name){
    Connection conn = db.conn();
    String sql = "select * from addr where name like ?";
    ArrayList<Addr> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "%" + name + "%");
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        Addr a = new Addr();
        a.setNumber(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setTel(rs.getString(3));
        a.setAddr(rs.getString(4));

        list.add(a);
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

  // selectByTel
  public ArrayList<Addr> selectByTel(String tel){
    Connection conn = db.conn();
    String sql = "select * from addr where tel like ?";
    ArrayList<Addr> list = new ArrayList<>();
    try {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "%" + tel + "%");
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        Addr a = new Addr();
        a.setNumber(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setTel(rs.getString(3));
        a.setAddr(rs.getString(4));

        list.add(a);
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
