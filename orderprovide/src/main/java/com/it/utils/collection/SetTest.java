package com.it.utils.collection;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 无序，不允许有重复的元素,最多允许有一个null元素对象
 */
public class SetTest {

    public static void main(String[] args) {
        SetTest.build().setTest003();
    }

    public void setTest003(){
        TreeSet<String> comparables = Sets.newTreeSet();
        comparables.add("BT模块");
        comparables.add("WIFI模块");
        Iterator<String> iterator = comparables.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Set<String> bt = comparables.stream().filter(s -> s.equals("BT模块")).collect(Collectors.toSet());
        System.out.println(bt.toString());
    }
    
    public void setTest002(){
        Set<Object> objects = Sets.newLinkedHashSet();
    }

    public void setTest001(){
        Set<String> modelSet= Sets.newHashSet();
        modelSet.add("BT模块");
        modelSet.add("WIFI模块");
        Iterator<String> iterator = modelSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static SetTest build(){
        return new SetTest();
    }
}
