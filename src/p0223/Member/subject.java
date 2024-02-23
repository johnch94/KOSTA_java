package p0223.Member;

public class subject {
  private int code;
  private String name;
  private boolean flag; // 개설유무
  private static int cnt = 1;
  private SubjOpen open;

  public subject(){}

  public subject(String name){
    this.code = cnt++;
    this.name = name;
  }

  public subject(int code, String name) {
    this.code = code;
    this.name = name;
  }
  @Override
  public String toString() {
    return "subject{" +
        "code=" + code +
        ", name='" + name + '\'' +
        ", flag=" + flag +
        '}';
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public SubjOpen getOpen() {
    return open;
  }

  public void setOpen(SubjOpen open) {
    this.open = open;
  }
}
