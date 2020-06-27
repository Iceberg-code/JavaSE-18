package cn.itcast.day18.demo04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
* java.io.ObjectOutputStream 继承了(extends) OutputStream
* ObjectOutputStream：对象的序列化流
* 作用：把对象以流的方式写入到文件中保存
*
* 构造方法：
*       ObjectOutputStream(OutputStream out)：创建写入指定OutputStream的ObjectOutputStream
*       构造方法的参数：
*           OutputStream out：字节输出流
* 特有的成员方法：
*       void writeObject(Object obj)：将指定的对象写入ObjectOutputStream
*
* 使用步骤：
*       1、创建ObjectOutputStream对象，构造方法中传递字节输出流
*       2、使用ObjectOutputStream对象中的方法writeObject，把对象写入到文件中
*       3、释放资源
* */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        //1、创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day18-IO\\person.txt"));

        //2、使用ObjectOutputStream对象中的方法writeObject，把对象写入到文件中
        oos.writeObject(new Person("奥丽莎", 10));

        //3、释放资源
        oos.close();
    }
}
