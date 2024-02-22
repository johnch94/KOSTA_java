package p0221;

import p0221.PokemonGame.Pokemon;

class Point2D{
  protected int x;
  protected int y;
  public Point2D(){}
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public void printPoint(){
    System.out.println("x: " + x);
    System.out.println("y: " + y);
  }
}
class Point3D extends Point2D{
  protected int z;
  public Point3D(){}
  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }
  @Override
  public void printPoint(){
    super.printPoint();
    System.out.println("z: " +z);
  }
  public void printZ(){
    System.out.println("z: " +z);
  }
}
public class OverrideTest1 {
  public static void main(String[] args) {
    Point3D p = new Point3D(1,2,3);
    p.printPoint();

    /**
     * up casting
     * 타입은 부모타입이지만 몸체는 자식이다.
     * 오버라이딩 된 매서드 호출시 자식 메서드 호출
     * 본인 객체 사용 불가
     */
    Point2D p2 = new Point3D(5,6,7);
    p2.printPoint();

    /**
     * down casting
     * 자식 클래스에 추가된 멤버를 사용하기 위해서 사용
     * 업캐스팅 된 객체를 원래 타입으로 내리는 것
     */
    Point3D p3 = (Point3D) p2;
    p3.z = 12;
    p3.printZ();
  }
}
