package p0223.Member.vo;

import java.util.Arrays;

public class Prof extends Person{
  private String[] myStudent = new String[5];

  public Prof(){}

  // 회원가입용
  public Prof(String name, String pwd, String personDepart, String[] myStudent) {
    this.idNum = "p" + cnt++;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = 2;
    this.myStudent = myStudent;
  }

  // 수정, 검색용 생성자
  public Prof(String idNum, String pwd, String idName, String personDepart, int personType, String[] myStudent) {
    this.idNum = idNum;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = personType;
    this.myStudent = myStudent;
  }

  @Override
  public String toString() {
    return "Prof{" +
        "myStudent=" + Arrays.toString(myStudent) +
        ", Num='" + idNum + '\'' +
        ", Name='" + idName + '\'' +
        ", Depart='" + personDepart + '\'' +
        ", Type=" + personType +
        ", PW='" + pwd + '\'' +
        '}';
  }

  public String[] getMyStudent() {
    return myStudent;
  }

  public void setMyStudent(String[] myStudent) {
    this.myStudent = myStudent;
  }
}
