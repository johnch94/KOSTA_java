package p0220.address;

// VO
public class Member {
  private String name;
  private String tel;
  private String address;

  public Member(){}
  public Member(String name, String tel, String address) {
    this.name = name;
    this.tel = tel;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() { // toString : 객체 설명 메서드
    return "Member{" + "name='" + name + '\'' + ", tel='" + tel + '\'' + ", address='" + address + '\'' + '}';
  }
}
