package spms.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class ClassLoaderTest {

  static class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
      if (!name.equals("spms.test.Car")) {
        return super.loadClass(name);
      }
      try {
        InputStream in = new FileInputStream("build/classes/spms/test/Car.class");
        byte[] a = new byte[10000];
        int len  = in.read(a);
        in.close();
        return defineClass(name, a, 0, len);
      } catch (IOException e) {
        throw new ClassNotFoundException();
      }
    }
  }


  public static void main(String[] args) throws Exception {
    Class<?> c1 = new MyClassLoader().loadClass("spms.test.Car");
    Class<?> c2 = new MyClassLoader().loadClass("spms.test.Car");
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c1 == c2);
    
    Field f1 = c1.getDeclaredField("count");
    Field f2 = c2.getDeclaredField("count");
    f1.setInt(null, 100);
    
    System.out.println(f1.getInt(null));
    System.out.println(f2.getInt(null));
    
  }
}
