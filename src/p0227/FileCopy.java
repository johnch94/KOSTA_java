package p0227;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileCopy {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("파일 복사");
    System.out.print("원본 파일명 : ");
    String src = sc.next();
    System.out.print("대상 파일명 : ");
    String dest = sc.next();
    String path = "src/p0227/files/";

    try {
      FileInputStream fi = new FileInputStream(path + src); // 기본 스트림
      BufferedInputStream bis = new BufferedInputStream(fi); // fi에 buffer 장착, buffer를 쓰면 속도 개선
      
      FileOutputStream fo2 = new FileOutputStream(path + dest);
      BufferedOutputStream bos = new BufferedOutputStream(fo2); // fo에 buffer 장착
      int ch;

//      StringBuilder sb = new StringBuilder();
//      byte[] buf2 = new byte[1];
//      while ((ch = fi.read(buf2)) == buf2.length){
//        sb.append(new String(buf2));
//        Arrays.fill(buf2, (byte)' ');
//        fo2.write(buf2);
//        fi.close();
//        fo2.close();

      while ((ch = bis.read()) != -1){
        bos.write(ch);
      }
      bos.close();
      bis.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
