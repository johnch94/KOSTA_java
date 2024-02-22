package p0222;

import java.util.Calendar;
import java.util.Date;

/**
 * SingleTone pattern 싱글톤 패턴
 * 객체의 인스턴스가 오직 1개만 생성 가능하게 만드는 패턴
 * 메모리 측면에서 이점이 있다.
 * 클래스 간 데이터 공유 쉽다.
 */
class SingleTone {
  private static SingleTone st = new SingleTone(); //생성자를 private로 감싼다
  private SingleTone(){
    System.out.println("SingleTone 생성자");
  }
  public void singletoneMethod(){
    System.out.println("singletoneMethod");
  }
  public static SingleTone getInstance(){ // 새로운 getInstance를 작성하여 st 를 호출
    return st;
  }
}
public class SingleToneTest {
  public static void main(String[] args) {
    SingleTone st = SingleTone.getInstance();
    st.singletoneMethod();

    Calendar c = Calendar.getInstance(); // 날짜 정보를 가져오는 api, 싱글톤패턴
    Date date = c.getTime();
    System.out.println(date.getTime());
  }
}
