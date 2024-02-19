package p0219;
class Person{
  String name;
  int age;

  Person(){
    name = "아무개";
    age = 12;
  }
  Person(String name){ // this: 현재 객체
    this.name = name; // 맴버변수와 파라메터(지역변수)의 이름이 같을 때 멤버변수를 구분하기 위해 사용
    age = 36;
  }
  Person(int age){
    this.age = age;
    name = "오영택";
  }
  Person(String name, int age){
    this.name = name;
    this.age = age;
  }
  void printData(){
    System.out.println("name : " + name);
    System.out.println("age  : " + age);
  }
}
public class method4 {
  public static void main(String[] args) {
    Person who = new Person();

    System.out.println(who.name);
    System.out.println(who.age);
  }
}
