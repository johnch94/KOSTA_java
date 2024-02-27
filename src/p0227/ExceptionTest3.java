package p0227;

class MyException extends Exception{
  public MyException(int num){
    super(num + " 은 0 이상이거나 5 이하여야 함." );
  }
}
class Test2{
  public void test(int num) throws Exception { // 예외 처리 미룸
    if(num<0 || num>5){
//      throw new Exception("num 은 0~5 사이의 정수이어야 한다."); // 예외 발생
      throw new MyException(num);
    }
    System.out.println("num : " + num);
  }
}
public class ExceptionTest3 {
  public static void main(String[] args) {
    System.out.println("프로그램 시작");
    Test2 t = new Test2();
    try {
      t.test(3);
      t.test(6);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("프로그램 종료");
  }
}
