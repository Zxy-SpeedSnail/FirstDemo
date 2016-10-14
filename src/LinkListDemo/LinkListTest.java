package LinkListDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuan on 16-9-8.
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        for (String str: linkedList) {
            System.out.println(str);
        }

        System.out.println("链表第一个元素："+linkedList.getFirst());
        System.out.println("链表第2个元素："+linkedList.get(1));
        System.out.println("链表第一个元素："+linkedList.getLast());


        //从链表生成子表
        List subl = linkedList.subList(1, 4);
        System.out.println(subl);
//        lst.remove(2);
//        System.out.println(lst);
//        System.out.println(lList);

        /**
         * 添加元素：添加单个元素
         如果不指定索引的话，元素将被添加到链表的最后.
         public boolean add(Object element)
         public boolean add(int index, Object element)
         也可以把链表当初栈或者队列来处理:
         public boolean addFirst(Object element)
         public boolean addLast(Object element)
         addLast()方法和不带索引的add()方法实现的效果一样.
         */
        linkedList.add("D");
        linkedList.addFirst("X");
        linkedList.addLast("Z");
        System.out.println(linkedList);

        /**
         * 删除元素
         */
//        linkedList.remove(6);
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        System.out.println(linkedList);

        //删除制定范围内的元素
//        linkedList.subList(2, 5).clear();


        //删除指定元素
//        System.out.println(linkedList.remove("2"));//删除元素值=2的元素
//        Object obj = linkedList.remove(2);  //删除第二个元素
//        System.out.println(obj + " 已经从链表删除");

        //元素在删除的时候，仍然可以获取到元素
        Object object = linkedList.removeFirst();
        System.out.println(object + " has been removed");
        System.out.println(linkedList);
        object = linkedList.removeLast();
        System.out.println(object + " has been removed");
        System.out.println(linkedList);

        /**
         * linklist转换成Arryalist
         */
        ArrayList<String> arrayList = new ArrayList<String>(linkedList);
        for (String s : arrayList) {
            System.out.println("s = " + s);
        }

        /**
         * 将LinkedList转换为数组，数组长度为0
         */
        String[] my = linkedList.toArray(new String[0]);
        for (int i = 0; i < my.length; i++) {
            System.out.println(my[i]);
        }

        /**
         * 将LinkedList转换为数组，数组长度为链表长度
         */
        String[] my1 = linkedList.toArray(new String[linkedList.size()]);
        for (int i = 0; i < my1.length; i++) {
            System.out.println(my1[i]);
        }

        /**
         * 查找元素位置
         */
        System.out.println(linkedList.indexOf("3"));
        System.out.println(linkedList.lastIndexOf("3"));


        /**
         * 替换元素
         */
        linkedList.set(3, "Replaced");//使用set方法替换元素，方法的第一个参数是元素索引，后一个是替换值
        System.out.println(linkedList);


        /**
         * 确认链表是否存在确定元素
         */
        if (linkedList.contains("4")) {
            System.out.println("LinkedList contains 4");
        } else {
            System.out.println("LinkedList does not contain 4");
        }


        /**
         * 根据链表 元素生成对象数组
         */
        Object[] objArray = linkedList.toArray();
        for (Object obj: objArray) {
            System.out.println(obj);
        }


        /**
         * 清空linkList
         */
//        linkedList.clear();


    }
}
