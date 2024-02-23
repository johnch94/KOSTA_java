package p0223.Member;

import p0223.Member.vo.Person;

import java.util.Arrays;

public class univDAO {

  private Person[] members;
  private int cnt;
  public univDAO(){
    members = new Person[30];
  }

  public Person[] getMembers() {
    return members;
  }

  public void setMembers(Person[] members) {
    this.members = members;
  }
  public int getCnt() {
    return cnt;
  }


  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  // 추가: insert()
  public void insert(Person p){
    if (cnt>=members.length){
      System.out.println("정원 초과. 가입 불가");
    }else {
      members[cnt] = p;
      cnt++;
    }
  }

  // 검색 : id, pw 와 같은 객체 찾아서 번호 반환
  public int search(Person p){
    for(int i=0; i<cnt; i++){
      if(members[i].equals(p)){
        return i;
      }
    }
    return -1;
  }

  // param으로 방번호를 받아 그 방의 객체를 리턴
public Person selectByIdx(int idx){
    return members[idx];
}

  // param으로 방번호를 받아 그 방의 객체 삭제
  public void delete(int idx){
    for(int i=idx; i<cnt-1; i++){
      members[i] = members[i+1];
    }
    cnt --;
  }

  @Override
  public String toString() {
    return "univDAO{" +
        "members=" + Arrays.toString(members) +
        '}';
  }
}
