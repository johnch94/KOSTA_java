package p0223.Member.vo;

/**
 * 학사정보 시스템 VO
 */
public class Person {
  protected String idNum;
  protected String idName;
  protected String personDepart;
  protected int personType; // 1.교직원, 2.교수, 3.학생
  protected String pwd;
  protected static int cnt = 1; // 번호에 할당할 카운트

  // num 과 pwd 같으면 같은 객체
  // equals 를 재정의


  @Override
  public boolean equals(Object obj) {
    Person p = (Person) obj;
    return this.idNum.equals(p.idNum) && this.pwd.equals(p.pwd);
  }

  public String getIdNum() {
    return idNum;
  }

  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }

  public String getIdName() {
    return idName;
  }

  public void setIdName(String idName) {
    this.idName = idName;
  }

  public String getPersonDepart() {
    return personDepart;
  }

  public void setPersonDepart(String personDepart) {
    this.personDepart = personDepart;
  }

  public int getPersonType() {
    return personType;
  }

  public void setPersonType(int personType) {
    this.personType = personType;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public static int getCnt() {
    return cnt;
  }

  public static void setCnt(int cnt) {
    Person.cnt = cnt;
  }
}
