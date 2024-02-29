package p0226.ArrayListProduct.Product;

import java.util.ArrayList;

public class ProductDao {
  private ArrayList<Product> list;

  public ProductDao(){
    list = new ArrayList<>();
  }

  public void insert(Product p){
    list.add(p);
  }

  //번호로 검색, 검색된 객체 반환
  public Product select(int num){
    // indexOf(객체) : 동일한 객체를 찾아서 방번호 리턴
    // 객체를 비교 하는 방법 : == (참조값 비교) or .equals (값 비교)
    int idx = list.indexOf(new Product(num, "",0,0));
    return idx<0 ? null : list.get(idx);
  }

  //이름으로 검색, 중복가능 여러 개 검색될 수 있음. 결과를 ArrayList에 담아서 반환
  public ArrayList<Product> selectName(String name){
    ArrayList<Product> li = new ArrayList<>(); // 검색된 객체를 저장할 리스트
    for(Product p : list){
      // 제품명에 name 매개변수가 포함되면 true
      if(p.getName().contains(name)){ // String.contains("") : string에 param문자열이 포함되면 true/false
        li.add(p);
      }
    }
    return li;
  }

  //가격으로 검색. 결과를 ArrayList에 담아서 반환
  public ArrayList<Product> selectPrice(int p1, int p2){ // 검색할 가격대 p1,p2 사이의 결과를 Arraylist에 담아 반환
    ArrayList<Product> li = new ArrayList<>();
    for(Product p : list){
      if(p.getPrice()>=p1 && p.getPrice()<=p2){
        li.add(p);
      }
    }
    return li;
  }

  //번호로 검색해서 삭제
  public boolean delete(int idx){
    return list.remove(new Product(idx,"",0,0));
  }

  //list getter()
  public ArrayList<Product> getList() {
    return list;
  }
}
