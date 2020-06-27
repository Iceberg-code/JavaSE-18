package cn.itcast.day18.demo01;
/*
* java.io.BufferedReader 继承了(extends) Reader
*
* 继承自父类的共性成员方法：
*       int read()：读取单个字符并返回
*       int read(char[] cbuf)：一次读取多个字符，将字符读入数组
*       void close()：关闭该流并释放与之关联的所有资源
*
* 构造方法：
*       BufferedReader(Reader in)：创建一个使用默认大小输入缓冲区的缓冲字符输入流
*       BufferedReader(Reader in, int sz)：创建一个使用指定大小输入缓冲区的缓冲字符输入流
*       构造方法的参数：
*           Reader in：字符输入流
*               可以传递FileReader，缓冲流会给FileReader增加一个缓冲区，提高FileReader的读取效率
* 特有的成员方法：
*       String readLine()：读取一个文本行。读取一行数据
*           行的终止符号：通过下列字符之一即可认为某行已终止：换行('\n')、回车('\r')或回车后直接跟着换行(\r\n)
*       readLine方法的返回值：
*           包含该行内容的字符串，不包含任何终止符，如果已达到流末尾，则返回null
*
* 使用步骤：
*       1、创建字符缓冲输入流对象，构造方法中传递字符输入流
*       2、使用字符缓冲输入流对象中的方法read/readLine读取文本
*       3、释放资源
* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo04BufferedReader {
    public static void main(String[] args) throws IOException {
        //1、创建字符缓冲输入流对象，构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("day18-IO\\2.txt"));
        //day18-IO\2.txt中：第一行：源氏1；第二行：源氏2；第三行：源氏3

/*
        //2、使用字符缓冲输入流对象中的方法read/readLine读取文本
        String line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);
*/
        /*
        * 发现以上读取是一个重复的过程，所以可以使用循环优化
        * 不知道文件中有多少行数据，多以使用while循环
        * while的结束条件，读取到null结束
        * */
        String line;
        while((line = br.readLine()) != null){  //注意这里是readLine方法null
            System.out.println(line);
        }

        //3、释放资源
        br.close();
    }
}
