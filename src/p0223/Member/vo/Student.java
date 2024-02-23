package p0223.Member.vo;

public class Student extends Person{
  private String myProf;

  // 회원가입용
  public Student(String name, String pwd, String personDepart, String myProf) {
    this.idNum = "st" + cnt++;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = 3;
    this.myProf = myProf;
  }

  // 수정, 검색용 생성자
  public Student(String idNum, String pwd, String idName, String personDepart, int personType, String myProf) {
    this.idNum = idNum;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = personType;
    this.myProf = myProf;
  }

  @Override
  public String toString() {
    return "Student{" +
        "myProf='" + myProf + '\'' +
        ", Num='" + idNum + '\'' +
        ", Name='" + idName + '\'' +
        ", Depart='" + personDepart + '\'' +
        ", Type=" + personType +
        ", PW ='" + pwd + '\'' +
        '}';
  }

  public String getMyProf() {
    return myProf;
  }

  public void setMyProf(String myProf) {
    this.myProf = myProf;
  }
}
