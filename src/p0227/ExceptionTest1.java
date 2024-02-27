package p0227;

public class ExceptionTest1 {
  public static void main(String[] args) {
    System.out.println("프로그램 시작");
    int arr[] = {1,2,3};
    try {
//      int i = 3/0;
      for (int i=0; i<arr.length+1; i++){
        System.out.println(arr[i]);
      }
      System.out.println("예외 발생 하면 catch로 바로 넘어간다.");
    } catch (ArithmeticException e) {
      System.out.println("산술오류");
      e.printStackTrace();
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println("null 포인터 익셉션");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("모든 예외");
      e.printStackTrace();
    } finally {
      System.out.println("반드시 실행");
    }
    System.out.println("프로그램 종료");
  }
}
