package p0222;

public class TestOracleDao implements InterDao{
  @Override
  public void insert() {
    System.out.println("oracle insert");
  }

  @Override
  public void select() {
    System.out.println("oracle select");
  }

  @Override
  public void update() {
    System.out.println("oracle update");
  }

  @Override
  public void delete() {
    System.out.println("oracle delete");
  }
}
