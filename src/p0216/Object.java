package p0216;
//코든 코드는 클래스 안에 있어야 한다
//한 파일에 클래스 여러개 정의 가능
//public이 붙는 클래스는 한 파일에 1개만 가능하고
//public이 붙은 클래스 이름과 소스파일명이 같아야한다
class Card{
  int cardNum;
  String expData;
  String pwd;
}
class Account {
  String accountNum;
  String bankName;
  String accountHolder;
}

public class Object {

  public static void main(String[] args) {
     Card c1 = new Card();
     Card c2 = new Card();

     c1.cardNum = 1;
     c1.expData = "03/25";
     c1.pwd = "111";

     c2.cardNum = 2;
     c2.expData = "03/26";
     c2.pwd = "222";

    System.out.println("- c1 객체 정보 -" );
    System.out.println("c1 card number     : " + c1.cardNum);
    System.out.println("c1 expiration date : " + c1.expData);
    System.out.println("c1 password        : " + c1.pwd);

    System.out.println("- c2 객체 정보 -" );
    System.out.println("c2 card number     : " + c2.cardNum);
    System.out.println("c2 expiration date : " + c2.expData);
    System.out.println("c2 password        : " + c2.pwd);

    Account c1account = new Account();
    Account c2account = new Account();

    c1account.accountNum = "123-456";
    c1account.bankName = "sinhan";
    c1account.accountHolder = "jururu";

    c2account.accountNum = "234-567";
    c2account.bankName = "KB";
    c2account.accountHolder = "gosegu";

    System.out.println("- c1 계좌 정보 -");
    System.out.println("c1 account number : " + c1account.accountNum);
    System.out.println("c1 bank name      : " + c1account.bankName);
    System.out.println("c1 account hloder : " + c1account.accountHolder);

    System.out.println("- c2 계좌 정보 -");
    System.out.println("c2 account number : " + c2account.accountNum);
    System.out.println("c2 bank name      : " + c2account.bankName);
    System.out.println("c2 account hloder : " + c2account.accountHolder);


  }
}
