package p0227;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 파일 복사
 * 원본 파일명과 복사본 파일명 입력 받아서 파일 복사
 */

public class FileOutputStreamTest {
  public static void main(String[] args) {
    try {
      // 파일에 바이트 단위로 출력 스트림. 쓰기로 오픈하는 파일이 있으면 덮어쓰기한다.
      // 쓰려는 파일이 없으면 자동생성
      FileInputStream fi = new FileInputStream("src/p0227/files/CopyFileTest");
      FileOutputStream fo = new FileOutputStream("src/p0227/files/b.txt"); // b.txt 자동생성
      FileOutputStream fo2 = new FileOutputStream("src/p0227/files/CopyFIleTest2");
      byte[] buf = "hello".getBytes();
      fo.write(buf);
      fo.close();

      // 파일 복사

      StringBuilder sb = new StringBuilder();
      byte[] buf2 = new byte[1];
      int ch;
      while ((ch = fi.read(buf2)) == buf.length){
        sb.append(new String(buf2));
        Arrays.fill(buf2, (byte)' ');
        fo2.write(buf2);
        fi.close();
        fo.close();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
