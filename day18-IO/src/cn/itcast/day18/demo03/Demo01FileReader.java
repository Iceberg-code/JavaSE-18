package cn.itcast.day18.demo03;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

/*
* FileReader可以读取IDE默认编码格式(UTF-8)的文件
* FileReader读取系统默认编码(中文GBK)会产生乱码
* */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day18-IO\\我是GBK格式的文件.txt");
        int len = 0;
        while ((len = fr.read()) != -1){
            //System.out.print(len);  //655336553365533， 为转换为char类型
            System.out.print((char) len);   //���， 产生了乱码
        }
        fr.close();
    }
}
