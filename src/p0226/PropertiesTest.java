package p0226;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
  public static void main(String[] args) {
    // map 중 하나. 프로그램 속성값을 다루는데 사용 (R/W)
    Properties props = new Properties(); // Properties 객체 생성
    props.put("ip", "210.192.168.3");
    props.put("port", "8001");
    props.put("id", "scott");
    props.put("pwd", "tiger");

    for (Object key : props.keySet()){
      System.out.println(key + " : " + props.getProperty((String) key));
    }

    // Properites에 저장된 키, 값을 파일로 저장
    Writer writer = null; // 파일에 문자단위로 쓰기 작업할 스트림을 생성

//      writer = new FileWriter("src/p0226/props.properties");
//      props.store(writer, "서버 관련 정보");
    try {
      props.storeToXML(new FileOutputStream("src/p0226/props.xml"),"서버 관련 정보");  // xml 파일로 생성하기
    } catch (IOException e) {
      throw new RuntimeException(e); // RuntimeException 으로 에러발생
      // 이클립스 ide 에서는
      // e.printStackTrace(); (에러 출력)로 완성해주는데 어떤 차이인지 알아보기
    }


    // Properties 파일 정보 읽기
    Properties props2 = new Properties();
    try {
//      props2.load(new FileReader("src/p0226/props.properties")); // FileReader: 파일에서 문자 단위로 읽는 스트림
      System.out.println("파일에서 읽은 내용");
      props2.loadFromXML(new FileInputStream("src/p0226/props.xml"));
      for(Object key : props2.keySet()){
        System.out.println(key + " : " + props2.getProperty((String)key));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
