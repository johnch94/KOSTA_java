package p0216;

class Student0{
  String name;
  int num, kor, eng, math, total;
  float avg;
}
class Student1{
  String name;
  int[] score = new int[5];
  float avg;
}
class Score{
  int kor, eng, math, total;
  float avg;
}
class Student2{
  String name;
  int num;
  Score score = new Score();
}

public class Object2 {
  public static void main(String[] args) {
    Student0 s0 = new Student0();

    s0.num = 1;
    s0.name = "wak";
    s0.kor = 67;
    s0.eng = 78;
    s0.math = 43;
    s0.total = s0.kor + s0.eng + s0.math;
    s0.avg = (float) s0.total/3;

    System.out.println("Student0의 객체");
    System.out.println("이름 : " + s0.name);
    System.out.println("국어 : " + s0.kor);
    System.out.println("영어 : " + s0.eng);
    System.out.println("수학 : " + s0.math);
    System.out.println("합계 : " + s0.total);
    System.out.println("평균 : " + s0.avg);

    Student1 s1 = new Student1();

    s1.name = "chun";
    s1.score[0] = 2;
    s1.score[1] = 54;
    s1.score[2] = 98;
    s1.score[3] = 78;
    for(int i=1; i<4; i++){
      s1.score[4] +=s1.score[i];
    }
    s1.avg = (float)s1.score[4]/3;

    System.out.println("Student1의 객체");
    System.out.println("이름 : " + s1.name);
    System.out.println("평균 : " + s1.avg);

    Student2 s2 = new Student2();

    s2.name = "startree";
    s2.num = 3;
    s2.score.kor = 55;
    s2.score.eng = 66;
    s2.score.math = 77;
    s2.score.total = s2.score.kor + s2.score.eng + s2.score.math;
    s2.score.avg = (float)s2.score.total/3;

    System.out.println("Student2의 객체");
    System.out.println("이름 : " + s2.name);
    System.out.println("평균 : " + s2.score.avg);

  }
}
