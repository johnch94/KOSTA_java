package p0219;

class OverloadingEx{ //여러개 불러오기 오버'로딩', 덮어쓰기 오버'라이딩'
  String add(String a, String b){
    return a+b;
  }
  int add(int a, int b){
    return a+b;
  }
  int add(int a, int b, int c){
    return a+b+c;
  }
}
public class OverloadingTest {
  public static void main(String[] args) {
    OverloadingEx o1 = new OverloadingEx();

    System.out.println(o1.add(1,2));
    System.out.println(o1.add(1,2,3));
    System.out.println(o1.add("aaa", "bbb"));
  }
}
