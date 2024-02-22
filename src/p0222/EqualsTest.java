package p0222;

import java.util.Scanner;

class Member{
  private String id;
  private String pwd;
  public Member(){}
  public Member(String id, String pwd) {
    this.id = id;
    this.pwd = pwd;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  @Override
  public String toString() {
    return "Member{" +
        "id='" + id + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
  @Override
  public boolean equals(Object obj){ // 객체 비교 this와 param 비교 boolean 반환
    if(obj instanceof Member){
      Member m = (Member) obj;
      return (m.id.equals(this.id)) && (m.pwd.equals(this.pwd));
    }
    return false;
  }
}
public class EqualsTest {
  public static void main(String[] args) {
    Member m1 = new Member("aaa","111");
    Member m2 = new Member("bbb","111");
    Member m3 = new Member("aaa","111");
    Member m4 = m1;

    System.out.println("m1==m2 : " + (m1==m2));
    System.out.println("m1.equals(m2) : " + (m1.equals(m2)));
    System.out.println("m1==m3 : " + (m1==m3));
    System.out.println("m1.equals(m3) : " + (m1.equals(m3)));
    System.out.println("m1==m4 : " + (m1==m4));
    System.out.println("m1.equals(m4) : " + (m1.equals(m4)));

    Member[] arr = {new Member("aaa","111"), new Member("bbb","222"),
    new Member("ccc","333"),new Member("ddd","444"), new Member("eee","555")};

    Scanner sc = new Scanner(System.in);
    System.out.println("검색할 사람 id/pwd");
    String id = sc.next();
    String pwd = sc.next();

    // 입력한 id/pwd와 같은 객체를 arr에서 검색하여 방번호 출력. equals()로 비교
    Member x = new Member(id,pwd);
    for(int i=0; i<arr.length; i++){
      if(x.equals(arr[i])){
        System.out.println(i+"번에 있음 / hashcode : " + arr[i].hashCode());
      }
    }
  }
}

