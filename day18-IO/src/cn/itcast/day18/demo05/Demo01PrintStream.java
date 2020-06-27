package cn.itcast.day18.demo05;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
* java.io.PrintStream：打印流
*       PrintStream：为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式
* PrintStream特点：
*       1、只负责数据地输出，不负责数据地读取
*       2、与其他输出流不同，PrintStream永远不会抛出IOException
*       3、有特有地方法，print，println
*           void print(任意类型的值)
*           void println(任意类型的值并换行)
* 构造方法：
*       PrintStream(File file)：输出的目的地是一个文件
*       PrintStream(OutputStream out)：输出的目的地的是一个字节输出流
*       PrintStream(String fileName)：输出的目的地是一个文件路径
* PrintStream 继承了(extends) OutputStream
* 继承自父类的成员方法：
*   - public void close()：关闭此输出流并释放与此流相关联的任何系统资源
*   - public void flush()：刷新此输出流并强制任何缓冲的输出字节被写出
*   - public void write(byte[] b)：将b.length字节从指定的字节数组写入此输出流
*   - public void write(byte[] b, int off, int len) ：从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
*   - public abstract void write(int b)：将指定的字节输出流。
*
* 注意：
*       如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表。如：97->a
*       如果使用自己特有的方法print/println方法写数据写书的数据原样输出。如：97->97
* */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建打印流PrintStream对象，构造方法中绑定要输出的目的地
        PrintStream ps = new PrintStream("day18-IO\\print.txt");    //会抛出FileNotFoundException

        //如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表。如：97->a
        ps.write(97);   //a
        //如果使用自己特有的方法print/println方法写数据写书的数据原样输出。可以输出任意类型的数据值的值
        ps.println(97);    //97
        ps.println(1.1);
        ps.println('b');
        ps.println("Hello");
        ps.println(true);
        ps.println(36L);

        //释放资源
        ps.close();
    }
}
