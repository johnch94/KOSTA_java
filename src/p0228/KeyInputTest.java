package p0228;

import java.util.ArrayList;
import java.util.Scanner;

class Input{
  ArrayList<String> arr = new ArrayList<>();
  public void mth(Scanner sc) {

    boolean flag = true;
    while (flag){
      String text = sc.next();
      if(text.equals("/stop")){
        break;
      }
      arr.add(text);
    }
  }
}
class Key implements Runnable{
  Input in = new Input();
  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public void mt(Scanner sc){
    in.mth(sc);
    for(String s : in.arr){
      run();
      System.out.println(s);
    }
  }

}
public class KeyInputTest {
  public static void main(String[] args) {
    Key k = new Key();
    Scanner sc= new Scanner(System.in);
    k.mt(sc);
  }
}
