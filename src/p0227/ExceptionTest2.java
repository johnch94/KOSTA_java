package p0227;

import java.io.IOException;

/**
 * 예외처리 미루기
 * throws IOException
 */
class Test{
  public void method1() throws IOException { // IOExctption 에 관해 예외처리를 진행해야하지만 이 메서드를 호출하는 쪽에게 미루겠다.
    int ch;
    while ((ch = System.in.read()) != '\n'){
      System.out.print((char) ch);
    }
  }
}
public class ExceptionTest2 {
  public static void main(String[] args) {
  Test t = new Test();
    try {
      t.method1(); // 예외처리를 해야하는 메서드
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
