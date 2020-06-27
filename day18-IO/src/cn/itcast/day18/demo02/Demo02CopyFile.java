package cn.itcast.day18.demo02;

import java.io.*;

/*
* 使用缓冲流来复制文件
*
* 文件复制练习：
* 明确：
*       数据源：F:\W.jpg
*       数据的目的地：F:\abc\pp.jpg
* 文件复制的步骤：
*       1、创建字节缓冲输入流对象，构造方法中传递字节输入流
*       2、创建字节缓冲输出流对象，构造方法中传递字节输出流
*       3、使用字节缓冲输入流对象中的方法read，读取文件
*       4、使用字节缓冲输出流对象中的方法write，把读取的数据写入到内部缓冲区中
*       5、释放资源(会先把缓冲区中的数据，刷新到文件中)
*
* 复制文件耗时：
*       一次读取一个字节，写入一个字节的方式：20毫秒
*       使用数组缓冲读取多个字节，写入多个字节：2毫秒
* */
public class Demo02CopyFile {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        //1、创建字节缓冲输入流对象，构造方法中传递字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\W.jpg"));

        //2、创建字节缓冲输出流对象，构造方法中传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\abc\\pp.jpg"));

/*
        //方法1：一次读取一个字节，写入一个字节的方式
        //3、使用字节缓冲输入流对象中的方法read，读取文件
        int len = 0;
        while ((len = bis.read()) != -1){
            //4、使用字节缓冲输出流对象中的方法write，把读取的数据写入到内部缓冲区中
            bos.write(len);
        }
*/

        //方法2：使用数组缓冲读取多个字节，写入多个字节
        //3、使用字节缓冲输入流对象中的方法read，读取文件
        byte[] bytes = new byte[1024];
        int len = 0;    //每次读取的有效字节个数
        while ((len = bis.read(bytes)) != -1){
            //4、使用字节缓冲输出流对象中的方法write，把读取的数据写入到内部缓冲区中
            bos.write(bytes, 0, len);
        }

        //5、释放资源(会先把缓冲区中的数据，刷新到文件中)
        bos.close();
        bis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("复制文件共耗时：" + (endTime - startTime) + "毫秒");
    }
}
