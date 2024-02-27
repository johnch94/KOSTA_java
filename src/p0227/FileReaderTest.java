package p0227;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderTest {
  public static void main(String[] args) {
    try {
      FileReader fr = new FileReader("src/p0227/files/fileTXT");
      int ch;
//      while ((ch = fr.read()) != -1){
//        System.out.print((char)ch);
//      }
      StringBuilder sb = new StringBuilder();
      char[] buf = new char[10];
      while ((ch = fr.read(buf)) == buf.length){
        sb.append(new String(buf));
        Arrays.fill(buf, ' ');
      }
      sb.append(new String(buf));
      System.out.println(sb);
      fr.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
