package p0222;
class Test implements Cloneable{
  int x;
  int y;

  public Test(){}
  @Override
  public String toString() {
    return "Test{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  public Test(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException{
    return super.clone();
  }
}
public class CloneTest {
  public static void main(String[] args) {
    // 직접 복사
    Member m1 = new Member("aaa","111");
    Member m2 = new Member(m1.getId(), m1.getPwd());

    Test t1 = new Test(12, 23);
    System.out.println("참조값 : " + t1.hashCode() + " / t1 : " + t1);
    Test t2 = null;
    try { // 예외처리
      t2 = (Test) t1.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("참조값 : " + t2.hashCode() + " / t2 : " + t2);

  }
}
