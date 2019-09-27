package com.it.utils.fanxing;

public class FanxingClass<T> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void main(String[] args) {
        FanxingClass<String> test = new FanxingClass<>();
        test.setKey("222");
    }
}
