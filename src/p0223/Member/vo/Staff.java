package p0223.Member.vo;

public class Staff extends Person{
  private String job;

  // 회원가입 시 사용할 생성자
  public Staff(String name, String pwd, String personDepart, String job) {
    this.idNum = "s" + cnt++;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = 1;
    this.job = job;
  }

  // 수정, 검색용 생성자
  public Staff(String idNum, String pwd, String idName, String personDepart, int personType, String job) {
    this.idNum = idNum;
    this.pwd = pwd;
    this.idName = idName;
    this.personDepart = personDepart;
    this.personType = personType;
    this.job = job;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return "Staff{" +
        "job='" + job + '\'' +
        ", Num='" + idNum + '\'' +
        ", Name='" + idName + '\'' +
        ", Depart='" + personDepart + '\'' +
        ", Type=" + personType +
        ", PW='" + pwd + '\'' +
        '}';
  }
}
