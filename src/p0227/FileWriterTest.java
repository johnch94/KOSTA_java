package p0227;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
  public static void main(String[] args) {
    try {
      // 파일에 문자 단위로 출력
      FileWriter fw = new FileWriter("src/p0227/files/c.txt");
      char[] ch = "겨울\n배가\n달다\n".toCharArray();
      fw.write(ch);
      String str = "배열의 크기만큼 읽어서 배열에 담아줌";
      fw.write(str);
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
