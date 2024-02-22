package p0221;
class Point{
  int x, y;
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y +'}';
  }
}
public class AutoBoxingTest {
  public static void main(String[] args) {
    // Object 자바 모든 클래스가 상속받는 클래스, 대모 클래스
    Object[] arr = new Object[5];

    //upcasting
    arr[0] = 1;
    arr[1] = "aaa";
    arr[2] = 3.456;
    arr[3] = true;
    arr[4] = new Point(3,4);
    String str = new String("aaa");

    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
    if(arr[1].equals(str)){
      System.out.println(arr[1] + " 과 " + str + " 문자열이 동일하다");
    }

    System.out.println(((Point)arr[4]).x);
    System.out.println(((Point)arr[4]).y);
  }
}
