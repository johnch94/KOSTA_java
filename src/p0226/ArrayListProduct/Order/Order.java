package p0226.ArrayListProduct.Order;
// 주문번호, 주문제품번호, 주문수량, 제품단가, 결제금액, 결제유무, 출고유무
public class Order {
  private int num; // 주문번호
  private int prodNum; // 제품번호
  private int amount; // 주문 수량
  private int price; // 제품 가격
  private int payment; // 결제 금액
  private boolean pay; // 결제 유무
  private boolean out; // 출고 유무
  private int cnt;

  public Order(){}

  // 제품 생성용
  public Order(int prodNum, int amount, int price, int payment, boolean pay) { // pay : 즉시결제 true, 장바구니 false
    this.num = ++cnt;
    this.prodNum = prodNum;
    this.amount = amount;
    this.price = price;
    this.payment = price * amount;
    this.pay = pay;
  }

  public Order(int num, int prodNum, int amount, int price, int payment, boolean pay, boolean out) {
    this.num = num;
    this.prodNum = prodNum;
    this.amount = amount;
    this.price = price;
    this.payment = payment;
    this.pay = pay;
    this.out = out;
  }

  @Override
  public String toString() {
    return "Order{" +
        "num=" + num +
        ", prodNum=" + prodNum +
        ", amount=" + amount +
        ", price=" + price +
        ", payment=" + payment +
        ", pay=" + pay +
        ", out=" + out +
        '}';
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getProdNum() {
    return prodNum;
  }

  public void setProdNum(int prodNum) {
    this.prodNum = prodNum;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPayment() {
    return payment;
  }

  public void setPayment(int payment) {
    this.payment = payment;
  }

  public boolean isPay() {
    return pay;
  }

  public void setPay(boolean pay) {
    this.pay = pay;
  }

  public boolean isOut() {
    return out;
  }

  public void setOut(boolean out) {
    this.out = out;
  }
}
