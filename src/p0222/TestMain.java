package p0222;

public class TestMain {
  public static void main(String[] args) {
    TestService service = new TestService(new TestMySQLDao());
    service.add();
    service.get();
    service.edit();
    service.del();
  }
}
