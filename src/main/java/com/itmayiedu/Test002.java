package com.itmayiedu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itmayiedu.model.Item;
import com.itmayiedu.model.User;

import java.util.ArrayList;
import java.util.List;

public class Test002 {

    public static void main(String[] args) {
        //组装json
        JSONObject root = new JSONObject();
        root.put("id", "20");
        root.put("name", "李永强");
        JSONArray jsonArray = new JSONArray();
        JSONObject object1 = new JSONObject();
        object1.put("itemId", "20");
        object1.put("itemName", "电商");
        JSONObject object2 = new JSONObject();
        object2.put("itemId", "21");
        object2.put("itemName", "互联网");
        jsonArray.add(object1);
        jsonArray.add(object2);
        root.put("items", jsonArray);
        System.out.println(root.toString());

        //使用实体类封装成json字符串
      /*  User user = new User();
        user.setId("20");
        user.setName("李永强");
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setItemId("20");
        item.setItemName("电商");
        Item item2 = new Item();
        item2.setItemId("21");
        item2.setItemName("互联网");
        items.add(item);
        items.add(item2);
        user.setItems(items);*/
        //将实体对象转换成json格式的字符串
        //System.out.println(new JSONObject().toJSONString(user));
    }
}
