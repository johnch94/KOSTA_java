package p0228;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf = new RandomAccessFile("src/p0227/files/alphabet","r");
      System.out.println((char)raf.read());
      raf.seek(10); // 커서 위치 이동
      System.out.println("10 위치로 이동 후 읽은 값 : " + (char)raf.read());
      System.out.println("현재 위치 : " + raf.getFilePointer());
      System.out.println("파일 크기 : " + raf.length());
      raf.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
