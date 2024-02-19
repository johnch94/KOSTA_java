package p0216;
class Point{
  int x;
  int y;
}
public class Object3 {
  public static void main(String[] args) {
    Point[] arr = new Point[3];

    for(int i=0; i<arr.length; i++){
      arr[i] = new Point();
      arr[i].x = (int)Math.pow(10,(double) i);
      arr[i].y = 2 * arr[i].x;
      System.out.println(arr[i].x + "\t" + arr[i].y);

    }

  }

}
