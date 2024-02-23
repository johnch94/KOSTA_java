package p0223.Member;

import p0223.Member.vo.Prof;

//과목 개설 정보 vo
public class SubjOpen {
  private String day; //요일
  private String time; //시간
  private String room; //강의실
  private Prof prof; //지도교수
  private int num; //수강인원
  private int cnt; //현재 신청 인원
  private  String info; //과목개요

  public SubjOpen(){}
  public SubjOpen(String day, String time, String room, Prof prof, int num, int cnt, String info) {
    this.day = day;
    this.time = time;
    this.room = room;
    this.prof = prof;
    this.num = num;
    this.cnt = cnt;
    this.info = info;
  }

  @Override
  public String toString() {
    return "SubjOpen{" +
        "day='" + day + '\'' +
        ", time='" + time + '\'' +
        ", room='" + room + '\'' +
        ", prof=" + prof +
        ", num=" + num +
        ", cnt=" + cnt +
        ", info='" + info + '\'' +
        '}';
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public Prof getProf() {
    return prof;
  }

  public void setProf(Prof prof) {
    this.prof = prof;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
