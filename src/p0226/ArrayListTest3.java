package p0226;

import p0223.Member.vo.Person;

import java.util.ArrayList;

class Point{
  private int x;
  private int y;
  public Point(){}
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Point){
      Point p = (Point) obj;
      if(p.x==x && p.y==y){
        return true;
      }
    }return false;
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
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
public class ArrayListTest3 {
  public static void main(String[] args) {
    // 좌표 3개 저장
    ArrayList<Point> list = new ArrayList<>();

    list.add(new Point(3,4));
    list.add(new Point(6,9));
    list.add(new Point(1,7));

    // 전체 출력
    for(Point p : list){
      System.out.println(p);
    }

    // 좌표 검색.
    int i;
    for (i=0; i<list.size(); i++){
      Point p = list.get(i); // get(idx) : idx 요소 꺼내옴
      if(p.getX()==6 && p.getY()==9){
        System.out.println("6,9 의 좌표 : " + i);
        break;
      }
    }

    // 좌표 삭제.
    if(i==list.size()){
      System.out.println("not found");
    }else {
      System.out.println("(6,9) 삭제");
      list.remove(i);
    }

    // 모든 요소 출력
    for(Point p : list){
      System.out.println(p);
    }

    System.out.println(list.indexOf(new Point(3,4))); // equal 재정의 안하면 못찾음
    boolean flag = list.remove(new Point(3,4));
    if(flag){
      System.out.println("삭제완료");
    }
  }
}
