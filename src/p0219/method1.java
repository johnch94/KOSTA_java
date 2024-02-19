package p0219;

import java.util.Scanner;

public class method1 {
  private String add(String s, int x){
    return s + x;
  }
  private int[] makeArr(Scanner sc){
    System.out.println("배열 크기 : ");
    int size = sc.nextInt();
    int[] arrs = new int[size];
    System.out.println("입력 : ");
    for(int i=0; i<arrs.length; i++){
      arrs[i] = sc.nextInt();
    }
    return arrs;
  }
  private int sumArr(int[] arrs){
    int sum=0;
    for(int arr:arrs){
      sum += arr;
    }
    return sum;
  }
  private void sortArr(int[] arrs){
    int tmp; // 버블 sort
    for(int i=0; i<arrs.length-1; i++){ //배열 요소 개수 -1
      for(int j=0; j<arrs.length-1-i; j++){ //배열 요소 개수 -i -1
        if(arrs[j]>arrs[j+1]){ // 오름차순
          tmp = arrs[j];
          arrs[j] = arrs[j+1];
          arrs[j+1] = tmp;
        }
      }
    }
  }
  private void printArr(int[] arrs){
    for(int arr : arrs){
      System.out.print(arr + "\t");
    }
  }

  public static void main(String[] args) {
    //객체 생성
    method1 mth = new method1();
    Scanner sc = new Scanner(System.in);

    mth.add("hello",123);

    //배열 생성하여 저장
    int[] arr = mth.makeArr(sc);
    //배열 출력
    mth.printArr(arr);
    //배열 합 출력
    System.out.println("sum : " + mth.sumArr(arr));
    //배열 정렬
    mth.sortArr(arr);
    mth.printArr(arr);
  }
}
