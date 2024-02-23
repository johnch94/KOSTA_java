package p0223.Member;

import javax.security.auth.Subject;
import java.util.Scanner;

public class StaffDao {
  private subject[] subs;

  public subject[] getSubs() {
    return subs;
  }

  public void setSubs(subject[] subs) {
    this.subs = subs;
  }

  private int cnt;

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public StaffDao(){
    subs = new subject[30];
  }

  // 등록
  public void insert(subject sub){
    if(cnt>=subs.length){
      System.out.println("최대치 초과로 인한 등록 불가");
    } else {
      subs[cnt] = sub;
      cnt ++;
    }
  }

  // 검색(과목코드로)
  public int select(int code){
    for(int i=0; i<cnt; i++){
      if(subs[i].getCode() == code){
        return i;
      }
    }
    return -1;
  }

  // 방 번호로 객체를
  public subject select2(int code){
    for(int i=0; i<cnt; i++){
      if(code == subs[i].getCode()){
        return subs[i];
      }
    }return null;
  }

  // 이름수정
  public void editName(int idx, String name){
    subs[idx].setName(name);
  }

  // 삭제
  public void delete(int idx){
    for(int i = idx; i<cnt-1; i++){
      subs[i] = subs[i+1];
    }
    cnt--;
  }

  //개설 유무로 검색
  public subject[] selectByFlag(Boolean flag){
    subject[] ss = new subject[cnt];
    int j=0;
    for(int i=0; i<cnt; i++){
      if(subs[i].isFlag()==flag){
        ss[j] = subs[i];
        j++;
      }
    }
    return ss;
  }

  // 전체목록
  public void printAll(){
   for(int i=0; i<cnt; i++){
     subs[i].toString();
   }
  }
}
