package p0220.address;

public class Dao {
  private Member[] mems = new Member[30];
  private int cnt;

  public void add(Member m){ // 파라메터로 Member 객체 받아서 배열에 추가
    if(mems.length == cnt){
      System.out.println("배열에 남은 자리 없음");
    }else{
      mems[cnt] = m;
      cnt ++;
    }
  }

  int search(String name){ // 검색할 이름 param으로 받아 배열에서 위치 반환
    for(int i=0; i<cnt; i++){
      if(mems[i].getName().equals(name)){
        return i;
      }
    }
    return -1;
  }
  void delete(int idx){ // 삭제할 방번호 param으로 받아서 한칸씩 앞으로 이동
    for(int i = idx; i<cnt; i++){
      mems[i] = mems[i+1];
    }
    cnt--;
  }

  public Member[] getMems() {
    return mems;
  }
  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
}
