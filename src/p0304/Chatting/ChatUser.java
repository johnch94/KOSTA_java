package p0304.Chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 서버가 보내주는 msg를 출력
class ChatClient extends Thread {
  private PrintWriter pw;

  public ChatClient(PrintWriter pw) {
    this.pw = pw;
  }

  @Override
  public void run() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("msg(정지 = /stop) : ");
      String msg = sc.next();
      // msg 서버로 전송
      pw.println(msg);
      pw.flush();
      if (msg.startsWith("/stop")) {
        break;
      }
    }
  }
}
public class ChatUser {
  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 3333);
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintWriter pw = new PrintWriter(s.getOutputStream());

      ChatClient cc = new ChatClient(pw);
      cc.start();

      String msg = "";
      while (true) {
        msg = in.readLine();
        System.out.println(msg);
        if (msg.startsWith("/stop")) {
          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
