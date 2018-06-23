package com.itmayiedu;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Test003 {
    public static void main(String[] args) throws DocumentException {
        //1.获取到读取对象
        SAXReader saxReader = new SAXReader();
        InputStream in = Test003.class.getClassLoader().getResourceAsStream("student.xml");
        Document document = saxReader.read(in);
        Element rootElement = document.getRootElement();
        getNodes(rootElement);
    }

    public static void getNodes(Element rootElement){
        String name = rootElement.getName();
        System.out.println("节点名称："+name);
        List<Attribute> attributes = rootElement.attributes();
        for(Attribute attribute : attributes){
            System.out.println("属性名称:"+attribute.getName()+",属性值:"+attribute.getValue());
        }
        String textTrim = rootElement.getTextTrim();
        if(!"".equals(textTrim)){
            System.out.println("节点值:"+textTrim);
        }
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()){
            Element next = elementIterator.next();
            getNodes(next);
        }
    }
}
