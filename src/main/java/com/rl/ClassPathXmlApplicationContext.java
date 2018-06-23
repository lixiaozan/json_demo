package com.rl;

import com.itmayiedu.model.User;
import com.rl.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

public class ClassPathXmlApplicationContext {
	private String pathXml = null;

	private static String ID;

	private static String CLASS;

	private static String NAME;

	private static String VALUE;

	public void init(){
		ID = "id";
		CLASS = "class";
		NAME = "name";
		VALUE = "value";
	}

	public ClassPathXmlApplicationContext(String pathXml) {
	    init();
		this.pathXml = pathXml;
	}

	public Object getBean(String beanId) throws Exception {
		if (StringUtils.isEmpty(beanId)) {
			throw new Exception("beanId is null");
		}
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(this.getClass().getClassLoader().getResource(pathXml));
		// 获取到根节点
		Element rootElement = read.getRootElement();
		// 根节点下所有的子节点
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			// 获取到节点上的属性
			String id = element.attributeValue(ID);
			if (StringUtils.isEmpty(id)) {
				continue;
			}
			if (!id.equals(beanId)) {
				continue;
			}


			//从配置文件中获取bean
			String beanClass = element.attributeValue(CLASS);
			// 使用java反射机制初始化对象
			Class<?> class1 = Class.forName(beanClass);
			Object newInstance = class1.newInstance();
			//获取属性
			List<Element> propertyElementList = element.elements();
			for (Element el : propertyElementList) {
				//获取配置文件属性名称
				String name = el.attributeValue(NAME);
				String value = el.attributeValue(VALUE);
				Field declaredField = class1.getDeclaredField(name);
				declaredField.setAccessible(true);
				declaredField.set(newInstance, value);
			}
			return newInstance;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("beans.xml");
		UserEntity user = (UserEntity) classPath.getBean("user2");
		System.out.println(user.toString());
	}
}

