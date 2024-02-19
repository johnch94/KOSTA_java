package p0216;

import java.util.Scanner;

class Student{
  String name;
  int kor, eng, math, total;
  float avg;
}
public class School {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Student[] Stu = new Student[3];
    //성적 입력
    for(int i=0; i<Stu.length; i++){
      Stu[i] = new Student();
      System.out.println(i+1 + " 번 이름을 입력하시오 : ");
      Stu[i].name = sc.next();
      System.out.println("국어 점수 : ");
      Stu[i].kor = sc.nextInt();
      System.out.println("영어 점수 : ");
      Stu[i].eng = sc.nextInt();
      System.out.println("수학 점수 : ");
      Stu[i].math = sc.nextInt();
    }

    //점수 출력
    for(int i =0; i<Stu.length; i++){
      System.out.println(i+1 + "번 학생 " + Stu[i].name + "의 점수는 아래와 같습니다,");
      Stu[i].total = Stu[i].kor + Stu[i].eng + Stu[i].math;
      System.out.println("총점 : " + Stu[i].total);
      Stu[i].avg = (float) Math.round((float) Stu[i].total / 3 *100)/100;
      System.out.println("평균 : " + Stu[i].avg);
    }

  }
}
