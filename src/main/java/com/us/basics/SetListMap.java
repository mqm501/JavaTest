package com.us.basics;

import com.us.Person;
import org.apache.commons.collections4.ListUtils;
import org.python.google.common.collect.Lists;

import java.util.*;

/**
 * Created by yangyibo on 17/6/13.
 */
public class SetListMap {
    public static void main(String[] args) {
//        list();
//        setTest();
//        intersect();
//        getMap();
//        listPartition();
//        mapNullTest();
        stringsLength();
    }

    private static void setTest() {
        Set set = new HashSet();
        set.add("sdf");
        set.add("sdf");
        set.add("asdf");
        set.stream().forEach(x -> System.out.println(x));

    }

    private static void printList(List<String> strings) {
        for (String str : strings) {
            System.out.println("---" + str);
        }
    }

    private static void intersect() {
        List<String> lst1 = new ArrayList<>();
        lst1.add("1");
        lst1.add("2");
        lst1.add("3");
        List<String> lst2 = new ArrayList<>();
        lst2.add("1");
        lst2.add("2");
        lst2.add("4");
        unionList(lst1, lst2);
//        //lst1去除掉 lst2 不包含的元素 "3" 取交集
//        lst1.retainAll(lst2);
//        lst1.forEach(x -> System.out.println(x));

//        //lst1去除掉 lst2 中的所有元素 "1"，"2"
//        lst1.removeAll(lst2);
//        lst1.forEach(x -> System.out.println(x));
        System.out.println("－－－－－－－－－－－－－－－－－－－－－");
        lst2.removeAll(lst1);
        lst2.forEach(x -> System.out.println(x));
    }

    /**
     * 去除重复两个集合中重复的数据
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E> List<E> unionList(List<E> list1, List<E> list2) {
        List<E> resultList = new ArrayList<E>();
        List<E> tmpList1;
        List<E> tmpList2;
        if (null != list1) {
            tmpList1 = new ArrayList<E>(list1);
            if (null != list2) {
                tmpList2 = new ArrayList<E>(list2);
                tmpList2.removeAll(tmpList1);
                resultList.addAll(tmpList2);
            }
            resultList.addAll(tmpList1);
        } else if (null != list2) {
            tmpList2 = new ArrayList<E>(list2);
            resultList.addAll(tmpList2);
        }
        return resultList;
    }

    public static void maptest() {
        Map<String, Object> map = new HashMap<>();
        if (map.get("refresh") != null) {
            //检查超时
            System.out.println("true");
        }
        System.out.println("flase");
    }

    /**
     * 遍历map
     *
     * @param map
     */
    public static void getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", null);

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (Object v : map.values()) {
            System.out.println("value= " + v);
        }
    }


    private static void list() {
        List<String> list = new ArrayList<>();
        Person p = new Person();
        for (int i = 0; i < 5; i++) {
            p.setName("abel" + i);
            list.add(p.toString());
        }
        printList(list);
    }

    /**
     * 将list 分成多份，依赖maven collections4
     */
    private static void listPartition() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(ListUtils.partition(intList, 2));
    }

    /**
     * list 长度，
     */
    private static void stringsLength() {
       String[] strings = new String[]{"1","2"};
        System.out.println(strings.length);
    }


    /**
     * map 取空
     */
    private static void mapNullTest() {
        Map<String, Object> map = null;
//        map.put("1", "value1");
//        map.put("2", "value2");
//        map.put("3", "value3");
        System.out.println( map.get("5"));
    }
}

