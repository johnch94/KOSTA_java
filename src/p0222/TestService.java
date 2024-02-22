package p0222;

public class TestService {
//  private TestMySQLDao dao = new TestMySQLDao();
//  private TestOracleDao dao = new TestOracleDao();
  /**
   * 인터페이스 타입으로 멤버변수를 선언하면
   * 위와 같이 서비스가 어떤 타입이던지 dao 인터페이스를 활용해
   * 코드의 의존성을 내릴 수 있다.
   */
  private InterDao dao;
  public TestService(InterDao dao){ // 의존성 주입(DI).
    this.dao = dao;
  }
  public void add(){
    dao.insert();
  }
  public void get(){
    dao.select();
  }
  public void edit(){
    dao.update();
  }
  public void del(){
    dao.delete();
  }
}
