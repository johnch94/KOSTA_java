package p0227.address;

import java.util.ArrayList;

public class Dao {
  private ArrayList<Member> mems;
  public Dao(){
    mems = new ArrayList<>();
  }
  public void add(Member m){ // 파라메터로 Member 객체 받아서 배열에 추가
    mems.add(m);
  }
  public Member search(String name){ // 검색할 이름 param으로 받아 배열에서 위치 반환
    int idx = mems.indexOf(new Member(name,"",""));
    if (idx<0){
      return null;
    }
    return mems.get(idx);
  }
  public boolean delete(String name){ // 삭제할 방번호 param으로 받아서 한칸씩 앞으로 이동
    return mems.remove(new Member(name,"",""));
  }
  public ArrayList<Member> getMems(){
    return mems;
  }
}
