package cn.itcast.day18.demo04;

import java.io.Serializable;

/*
* 序列化和反序列化的时候，会抛出NotSerializableException没有序列化异常
* 类通过实现java.io.Serializable接口以启用其序列化功能。未实现此接口的类将无法使用其任何状态序列化或反序列化
* Serializable接口也叫标记行型接口
*       要进行序列化和反序列化的类必须实现Serializable接口，就会给类添加一个标记
*       当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
*           有：就可以序列化和反序列化
*           没有：就会抛出NotSerializableException异常
* 就像：去市场买肉-->肉上有个蓝色的章(检测合格)-->放心购买-->买回来怎么吃随意
*
* static关键字：静态关键字
*       静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
*       被static修饰的成员变量不能被序列化，序列化的都是对象
*           private static int age;
*           oos.writeObject(new Person("奥丽莎", 10));
*           Object obj = ois.readObject();
*           Person{name='奥丽莎', age=0}
*
* transient关键字：瞬态关键字    (以后不想成员变量被序列化，用transient关键字来修饰就行了)
*       被transient修饰的成员变量，不能被序列化
*           private transient int age;
*           oos.writeObject(new Person("奥丽莎", 10));
*           Object obj = ois.readObject();
*           Person{name='奥丽莎', age=0}
* */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;    //自己定义的序列号
    private String name;
    //private static int age;
    //private transient int age;
//    private int age;
    public int age;  //对类的定义进行修改，改为private修饰

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
