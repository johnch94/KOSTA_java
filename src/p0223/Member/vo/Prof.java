package p0223.Member.vo;

import java.util.ArrayList;
import java.util.Arrays;

public class Prof extends Person{
  private ArrayList<String> MyStuds = new ArrayList<>(); // 담당 학생 이름

  public Prof(){}

  // 회원가입용
  public Prof(String name, String pwd, String personDepart, String[] myStudent) {
    this.idNum = "p" + cnt++;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = 2;
  }

  // 수정, 검색용 생성자
  public Prof(String idNum, String pwd, String idName, String personDepart, int personType) {
    this.idNum = idNum;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = personType;
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

  public ArrayList<String> getMyStudent() {
    return MyStuds;
  }

  public void setMyStudent(ArrayList<String> MyStuds) {
    this.MyStuds = MyStuds;
  }

  public void addMyStuds(String name){
    MyStuds.add(name);
  }
  public ArrayList<String> getMyStuds(){
    return MyStuds;
  }
}
