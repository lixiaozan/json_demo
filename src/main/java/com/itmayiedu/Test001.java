package com.itmayiedu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itmayiedu.model.User;

public class Test001 {

    //private static String json = "{\"id\":\"20\",\"name\":\"李永强\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"电商\"},{\"itemId\":\"21\",\"itemName\":\"互联网\"}]}";

    public static void main(String[] args) {
        JSONObject object = new JSONObject().parseObject(json);
        String id = object.getString("id");
        String name = object.getString("name");
        System.out.println("id:"+id+"   name:"+name);
        JSONArray items = object.getJSONArray("items");
        for (int i = 0; i < items.size(); i++) {
            JSONObject jsonObject = items.getJSONObject(i);
            String itemId = jsonObject.getString("itemId");
            String itemName = jsonObject.getString("itemName");
            System.out.println("itemId:"+itemId+"   itemName:"+itemName);
        }
        //json转换对象
        User user = JSONObject.parseObject(json, User.class);
        System.out.println(user);
    }
}
