package p0226;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest2 {
  public static void main(String[] args) {
    /**
     * 제네릭 <타입> : 템플릿의 타입을 지정한 것으로 한정
     */
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa"); // 자동으로 끝에 추가된다.
    list.add(0,"bbb"); // 지정한 index 0 에 저장된다.
    list.set(1,"abc"); // 지정한 index의 내용을 수정

    for(int i=0; i<list.size(); i++){ // size() : 데이터 개수
      System.out.println(list.get(i)); //.get() : 값 꺼내옴
    }

    // list에 값이 있는지 boolean 반환
    boolean flag = list.contains("aaa");
    System.out.println("list contains aaa : " + flag);
    flag = list.contains("bbb");
    System.out.println("list contains bbb : " + flag);

    // 요소를 찾아서 인덱스 반환
    int idx = list.indexOf("bbb");
    System.out.println("bbb 방 번호 : " + idx);

    // 방번호로 삭제. 삭제할 요소 인덱스를 입력. 삭제된 요쇼 반환
    String delData = list.remove(0);
    System.out.println("remove(0) : " + delData);

    // 동일한 요솔르 찾아서 삭제. 처리결과 반환 .equals() 재정의 해야 정상동작.
    boolean fl = list.remove("abc");
    System.out.println("remove(\"abc\")" + fl);

    if(list.isEmpty()){ // 비었는지 확인 boolean
      System.out.println("비없음");
      list.add("eee");
      list.add("fff");
    }
    // 내부 이터레이터를 사용하는 for문
    for(String s : list){
      System.out.println(s);
    }

    /**
     * 이터레이터 : 반복자
     */
    Iterator<String> it = list.iterator();
    while (it.hasNext()){ // hasNext() : 읽을 요소가 있다면 true
      System.out.println(it.next()); // next() : 다음 요소 읽음
    }
    
  }
}
