package p0222;

public class TestMySQLDao implements InterDao{
  @Override
  public void insert() {
    System.out.println("Mysql insert");
  }

  @Override
  public void select() {
    System.out.println("Mysql select");
  }

  @Override
  public void update() {
    System.out.println("Mysql update");
  }

  @Override
  public void delete() {
    System.out.println("Mysql delete");
  }
}
