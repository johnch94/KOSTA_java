package p0221.Warehouse;

public class DAO_product {
  private product[] item = new product[100];
  private int idx;

  public void add(product p){
    item[idx] = p;
    idx++;
  }
  public int search(int idx){
    return item[idx].getNum();
  }
  public void delete(int cnt){
    for(int i =cnt; i<idx; i++){
      item[i] = item[i +1];
    }
    idx--;
  }

  public int getIdx() {
    return idx;
  }

  public void setIdx(int idx) {
    this.idx = idx;
  }
}
