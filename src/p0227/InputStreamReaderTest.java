package p0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ch;
    try {
      if ((ch = br.read()) != '\n'){
        System.out.print((char) ch);
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

