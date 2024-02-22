package p0221.Warehouse;

public class product {
  private int num;
  private String name;
  private int value;
  private int stack;

  product(){}

  public product(int num, String name, int value, int stack) {
    this.num = num;
    this.name = name;
    this.value = value;
    this.stack = stack;
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

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getStack() {
    return stack;
  }

  public void setStack(int stack) {
    this.stack = stack;
  }

  @Override
  public String toString() {
    return "product{" +
        "num=" + num +
        ", name='" + name + '\'' +
        ", value=" + value +
        ", stack=" + stack +
        '}';
  }
}
