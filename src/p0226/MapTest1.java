package p0226;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest1 {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();

    map.put("name", "aaa");
    map.put("tel", "111");
    map.put("address", "대한민국");
    map.put("name", "bbb"); // 수정됨. 키는 중복 불가

    System.out.println("name : " + map.get("name")); // get(키) : 키값으로 읽기
    System.out.println("tel : " + map.get("tel"));
    System.out.println("address : " + map.get("address"));

    System.out.println("반복자로 출력");
    Iterator it1 = map.keySet().iterator(); // keySet() : 키 묶음 반환
    while (it1.hasNext()){
      String key = (String) it1.next();
      String val = map.get(key);
      System.out.println(key + " : " + val);
    }

    System.out.println("내부 반복자로 출력");
    for(String key : map.keySet()){
      String val = map.get(key);
      System.out.println(key + " : " + val);
    }
  }
}
