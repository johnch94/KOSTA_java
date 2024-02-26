package p0226.ArrayListProduct.Product;
// vo
public class Product {
  private int num;
  private String name;
  private int price;
  private int amount;
  private static int cnt;

  // 상품 등록
  public Product(String name, int price, int amount) {
    this.num = ++cnt;
    this.name = name;
    this.price = price;
    this.amount = amount;
  }

  //
  public Product(int num, String name, int price, int amount) {
    this.num = num;
    this.name = name;
    this.price = price;
    this.amount = amount;
  }
  public Product(){}

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Product){
      Product p = (Product) obj;
      if(p.num == num){
        return true;
      }
    }
    return false;
  }
  @Override
  public String toString() {
    return "Product{" +
        "num=" + num +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", amount=" + amount +
        '}';
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public static int getCnt() {
    return cnt;
  }

  public static void setCnt(int cnt) {
    Product.cnt = cnt;
  }
}
