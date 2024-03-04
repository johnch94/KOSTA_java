package p0304.Chatting;

import java.util.Vector;

public class ChatServer {
  // Vector : ArrayList = 자동 동기화 : 비동기화
  private Vector<ChatMember> members;

  public ChatServer(){
    members = new Vector<>();
  }

  // 채팅방에 멤버 추가
  public void addMember(ChatMember m){
    members.add(m);
  }

  // 채팅방 멤버 제거
  public void delMember(ChatMember m){
    members.remove(m);
  }

  public void sendAllMsg(String msg){
    for(ChatMember m : members){
      m.sendMsg(msg);

    }
  }

}
