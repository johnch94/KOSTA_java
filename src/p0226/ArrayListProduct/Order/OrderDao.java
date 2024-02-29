package p0226.ArrayListProduct.Order;

import java.util.ArrayList;

/**
 * 숙제 :
 * 주문, 내 주문목록, 주문최소(결제안한것만), 주문번호로 검색,
 * 결제(pay가 false 인 것 true로 변경)
 *
 * dao, service, menu(run_c)
 */
public class OrderDao {
  private ArrayList<Order> order;

  OrderDao() {
    order = new ArrayList<>();
  }

  // 주문
  public void prodOrder(Order o) {
    order.add(o);
  }

  // 내 주문목록 getter
  public ArrayList<Order> getOrder() {
    return order;
  }

  // 주문 취소
  public void orderdelete(int idx){
    order.remove(idx);
  }

  // 주문취소 (결제안한것만)
  public void orderCancle() {
    for (Order o : order) {
      if (!o.isPay()) {
        order.remove(o);
      }
    }
  }

  // 주문번호로 검색
//  public ArrayList<Order> orderSelect(int num) {
//    ArrayList<Order> arr = new ArrayList<>();
//    for (Order o : order) {
//      if (o.getNum() == num) {
//        arr.add(o);
//      }
//    }
//    return arr;
//  }
  public int select(int num){
    for(int i=0; i<order.size(); i++){
      Order o = order.get(i);
      if(o.getNum()==num){
        return i;
      }
    }
    return -1;
  }

  public Order selectByNum(int num){
    int idx = select(num);
    if(idx < 0){
      return null;
    }
    return order.get(idx);
  }

  // 결제 유무 검색
  public ArrayList<Order> selectByPay(boolean flag){
    ArrayList<Order> list2 = new ArrayList<>();
    for(Order o : list2){
      if(o.isPay() == flag){
        list2.add(o);
      }
    }
    return list2;
  }

  // 결제, 결제 취소
  public boolean updatePay(int num, boolean flag){
    Order o = selectByNum(num);
    if(o == null){
      return false;
    }
    o.setPay(flag);
    return true;
  }
}