package p0221;

class Poin{
  protected int x;
  protected int y;

  public Poin(){}
  public Poin(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Poin{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
class Shape{
  protected String name; // 도형 이름
  protected Poin[] points; // 좌표 : 원 1개, 삼각형 : 3개, 사각형 : 2개
  public void draw(){ // 도형을 그리는 메소드
    System.out.println(name + "을 그린다");
  }
}
class Circle extends Shape{
  // 1개의 중심점(point), 반지름 1개
  private int r = 0;
  {
    name = "원";
  }
  public Circle(){
    points = new Poin[1];
    points[0] = new Poin(0,0);
    r=5;
  }
  public Circle(Poin[] p, int r){
    this.points = p;
    this.r = r;
  }
  @Override
  public void draw(){
    super.draw();
    System.out.println("중심점 : " + points[0].toString() + "반지름 : " + r);
  }
}
class Triangle extends Shape{
  // 3개의 좌표

  {
    name = "삼각형";
  }
  public Triangle(){
    points = new Poin[3];
    points[0] = new Poin(0,0);
    points[1] = new Poin(1,0);
    points[2] = new Poin(0,1);
  }
  public Triangle(Poin[] points){
    this.points = points;
  }
  @Override
  public void draw(){
    super.draw();
    for (Poin p: points){
      System.out.println(p.toString());
    }
  }
}
class Rectangle extends Shape{
  // 2개의 좌표
  {
    name = "사각형";
  }
  public Rectangle(){
    points = new Poin[2];
    points[0] = new Poin(0,0);
    points[1] = new Poin(2,2);
  }
  public Rectangle(Poin[] points){
    this.points = points;
  }
  @Override
  public void draw(){
    super.draw();
    for(Poin p: points){
      System.out.println(p.toString());
    }
  }
}
public class ShapeMain {
  public static void main(String[] args) {
    Shape[] s = {
        new Circle(),
        new Triangle(),
        new Triangle(new Poin[]{new Poin(12, 23),new Poin(0,0),new
    Poin(34,45)}),
        new Rectangle()
    };
    for(Shape ar: s){
      ar.draw();
    }
  }
}
