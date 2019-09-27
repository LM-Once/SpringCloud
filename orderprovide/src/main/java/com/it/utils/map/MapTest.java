package com.it.utils.map;

import com.google.common.collect.Maps;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapTest {

    public static void main(String[] args) {
        MapTest.build().mapTest001();
    }

    public void mapTest001(){
        TreeMap<String, String> modelMaps= Maps.newTreeMap();
        modelMaps.put("bt","BT模块");
        modelMaps.put("wifi","WIFI模块");
        modelMaps.put("bt","BT模块");
        modelMaps.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key);
                System.out.println(value);
            }
        });
        modelMaps.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });

        /*Set<Map.Entry<String, String>> entries = modelMaps.entrySet();
        for (Map.Entry<String,String> entry: entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Iterator<Map.Entry<String, String>> it = modelMaps.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }*/
    }

    public static MapTest build(){
        return new MapTest();
    }
}
