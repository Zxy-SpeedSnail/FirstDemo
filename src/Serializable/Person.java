package Serializable;

import java.io.Serializable;

/**
 * Created by yuan on 16-8-18.
 * <p>Description:测试对象序列化和反序列化<p>
 */
public class Person implements Serializable {

    /**
     * 序列化ID
     * 作用：s​e​r​i​a​l​V​e​r​s​i​o​n​U​I​D​:​ ​字​面​意​思​上​是​序​列​化​的​版​本​号​，凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量
     *
     * 如果没有s​e​r​i​a​l​V​e​r​s​i​o​n​U​I​D​
     *文件流中的class和classpath中的class，也就是修改过后的class，不兼容了，处于安全机制考虑，程序抛出了错误，并且拒绝载入。
     * 那么如果我们真的有需求要在序列化后添加一个字段或者方法呢？应该怎么办？那就是自己去指定serialVersionUID。
     * 在TestSerialversionUID例子中，没有指定Customer类的serialVersionUID的，那么java编译器会自动给这个class进行一个摘要算法，
     * 类似于指纹算法，只要这个文件 多一个空格，
     * 得到的UID就会截然不同的，可以保证在这么多类中，这个编号是唯一的。所以，添加了一个字段后，由于没有显指定 serialVersionUID，
     * 编译器又为我们生成了一个UID，当然和前面保存在文件中的那个不会一样了，
     * 于是就出现了2个序列化版本号不一致的错误。因此，只要我们自己指定了serialVersionUID，
     * 就可以在序列化后，去添加一个字段，或者方法，而不会影响到后期的还原，还原后的对象照样可以使用，而且还多了方法或者属性可以用
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}