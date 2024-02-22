package p0222;

public class StringTest {
  public static void main(String[] args) {
    String s1 = "asdf"; // "asdf" : 문자열 상수, 상수역역에 저장하고 그 참조값을 s1 에 저장
    String s2 = new String("asdf"); // 문자열 상수를 힙에 복사
    String s3 = new String(s2); // 다른 메모리에 s2를 복사해서 생성
    String s4 = new String(new char[] {'a','b','c'}); // 캐릭터 배열을 String으로 변환

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s4);

    System.out.println("s1==s2 : " + (s1==s2));
    System.out.println("s1.equals(s2) : " + s1.equals(s2));
    System.out.println("s2==s3 : " + (s2==s3));
    System.out.println("s2.equals(s3) : " + s2.equals(s3));

    String s5 = "qwer";
    String s6 = s1 + s5; // s1의 값이 변경도지 않고 새 메모리를 할당받아 s1, s2를 결합한 새 값을 저장
    System.out.println(s6);

    System.out.println("s6.charAt(2)         : " + s6.charAt(2));                 // 2번 자리에 있는 문자
    System.out.println("s6.concat            : " + s6.concat("1234"));      // 문자열 합치기
    System.out.println("s6.contains(\"qw\")    : " + s6.contains("qw"));          // 포함하였는가 boolean
    System.out.println("s6.indexOf('a')      : " + s6.indexOf('a'));              // 해당 문자의 위치
    System.out.println("s6.indexOf(\"qw\")     : " + s6.indexOf("qw"));           // 문자열이 시작되는 지점
    System.out.println("s6.lastIndexOf(\"qw\") : " + s6.lastIndexOf("qw")); // 뒤에서부터 탐색, 확장자 탐색
    System.out.println("s6.length()          : " + s6.length());                  // 문자열 길이
    System.out.println("s6.startsWith(\"as\")  : " + s6.startsWith("as"));        // as 로 시작하는가? boolean
    System.out.println("s6.endsWith(\"er\")    : " + s6.endsWith("er"));          // er 로 끝나는가? boolean

  }
}
