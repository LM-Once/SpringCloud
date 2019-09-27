package com.it.utils.fanxing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.it.utils.lambda.Account;
import com.it.utils.lambda.FuncInterTest.BiFuncInter;
import org.apache.commons.lang.StringUtils;
import java.util.List;

public class FanxingTest {

    /**
     * json字符串转换为java对象
     * @param json
     * @param tClass
     * @param <T>
     */
    public static <T> T parseJsonToObj(String json,Class<T> tClass){
        BiFuncInter<String,Boolean> funcInter = str -> StringUtils.isBlank(str);
        if (funcInter.apply(json)){
            throw new RuntimeException("param is can not null,error");
        }
        JSONObject jsonObject = JSONObject.parseObject(json);
        return JSON.toJavaObject(jsonObject,tClass);
    }

    /**
     * json字符串转为java集合对象
     * @param strArray
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> parseJsonToArray(String strArray,Class<T> t){
        BiFuncInter<String, Boolean> funcInter = str ->StringUtils.isBlank(str);
        if (funcInter.apply(strArray)){
            throw new RuntimeException("param is can not NULL,error");
        }
        return JSON.parseArray(strArray,t);
    }

    public static <T> T[] fun(T...arg){
        return arg;
    }


    public static void main(String[] args) {
        List<Account> accounts = Lists.newArrayList();
        Account account = Account.build().setId(1L)
                .setUserName("BT场景")
                .setPermission("手动分析");
        accounts.add(account);
        System.out.println(accounts.toString());
        String jsonAccountArray = JSON.toJSONString(accounts);
        List<Account> accounts1 = parseJsonToArray(jsonAccountArray, Account.class);
        System.out.println(accounts1);
    }
}
