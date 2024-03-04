package p0304.Chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatMain {
  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(3333);
      System.out.println("채팅 서버 시작");
      ChatServer room = new ChatServer();

      while (true){
        Socket s = ss.accept();
        ChatMember m = new ChatMember(s, room);
        m.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
