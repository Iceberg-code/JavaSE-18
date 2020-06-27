package cn.itcast.day18.demo04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
* java.io.ObjectInputStream 继承了(extends) InputStream
* ObjectInputStream：对象的反序列化流
* 作用：把文件中保存的对象，以流的方式读取出来使用
*
* 构造方法：
*       ObjectInputStream(InputStream in)：创建从指定InputStream读取的 ObjectInputStream
*       构造方法的参数：
*           InputStream in：字节输入流
* 特有的成员方法：
*       Object readObject()：从ObjectInputStream读取对象
*
* 使用步骤：
*       1、创建ObjectInputStream对象，构造方法中传递字节输入流
*       2、使用ObjectInputStream对象中的方法readObject读取保存对象的文件
*       3、释放资源
*       4、使用读取出来的对象(打印)
*
* readObject方法声明抛出了ClassNotFoundException(class文件找不到异常)
* 当不存在对象的class文件时抛出此异常
* 反序列化的前提：
*       1、类必须实现Serializable
*       2、必须存在类对应的class文件
* */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、创建ObjectInputStream对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day18-IO\\person.txt"));

        //2、使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        Object obj = ois.readObject();  //该方法抛出ClassNotFoundException异常

        //3、释放资源
        ois.close();

        //4、使用读取出来的对象(打印)
        System.out.println(obj);

        //将obj向下转型
        Person p = (Person) obj;
        System.out.println(p);
        System.out.println(p.getName() + p.getAge());
    }
}
