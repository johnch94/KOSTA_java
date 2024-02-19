package p0219;

class Calc{
  int res;
  void add(int x, int y){
    res = x + y;
    System.out.println(x + "+" + y +"="+res);
  }
  void sub(int x, int y){
    res = x>y ? x-y: y-x;
    System.out.println(x + "-" + y +"="+res);
  }
  void mul(int x, int y){
    res = x * y;
    System.out.println(x + "x" + y +"="+res);
  }
  void div(int x, int y){
    if(x==0 || y==0){
      System.out.println("0 으로 나눌 수 없습니다");
    }else {
      res = x/y;
      System.out.println(x + "/" + y +"="+res);
    }
  }
}

public class method2 {
  public static void main(String[] args) {
    Calc cal = new Calc();

    cal.add(1,2);

    cal.sub(3,4);

    cal.mul(5,6);

    cal.div(7,0);
  }
}
