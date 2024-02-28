package p0228;

import java.io.*;

public class DataInputOutputStream {
  public static void main(String[] args) {
    try {
      FileOutputStream fo = new FileOutputStream("src/p0227/files/e.dat");
      DataOutputStream dos = new DataOutputStream(fo);
      dos.writeInt(10);
      dos.writeBytes("hello"); // writeByte : int / writeBytes : String
      dos.writeBoolean(true);
      dos.writeFloat(3.14f);
      dos.writeUTF("jururu");
      dos.close();

      FileInputStream fi = new FileInputStream("src/p0227/files/e.dat");
      DataInputStream dis = new DataInputStream(fi);
      int a = dis.readInt();
      String b = new String(dis.readNBytes("hello".length()));
      boolean c = dis.readBoolean();
      float d = dis.readFloat();
      String e = dis.readUTF();
      dis.close();

      System.out.println("int : " + a);
      System.out.println("String : " + b);
      System.out.println("Boolean : " + c);
      System.out.println("float : " + d);
      System.out.println("UTF String : " + e);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
