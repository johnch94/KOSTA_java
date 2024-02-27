package p0227;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamTest {
  public static void main(String[] args) {
    try {
      FileInputStream fi = new FileInputStream("src/p0227/files/fileTXT");
      int ch;
//      while ((ch = fi.read()) != -1){ // -1 : 파일의 끝을 나타내는 상수
//        System.out.print((char) ch);
//      }
      StringBuilder sb = new StringBuilder();
      byte[] buf = new byte[5];
      while ((ch = fi.read(buf)) == buf.length){
        sb.append(new String(buf)); // new String(buf) : byte배열을 String으로 변환
        Arrays.fill(buf, (byte)' '); // Arrays.fill 배열을 지정한 값으로 채움
      }
      sb.append(new String(buf));
      System.out.println(sb);
      fi.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
