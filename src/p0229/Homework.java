package p0229;

import java.io.*;
import java.util.Scanner;

class MyThread6 extends Thread{
  @Override
  public void run(){
    try {
      BufferedReader br = new BufferedReader(new FileReader("src/p0229/Homework.java"));
      String str= "";
      while ((str = br.readLine())!=null){
        System.out.println(str);
        sleep(1000);
      }
      br.close();
    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
  }
}
public class Homework {
  public static void main(String[] args) {
    MyThread6 th = new MyThread6();
    th.start();

    Scanner sc = new Scanner(System.in);

    while(true){
      System.out.print("msg : ");
      String str = sc.next();

      if(str.equals("/stop")){
        break;
      }
      System.out.print("입력한 내용 : " + str);
    }
  }
}
