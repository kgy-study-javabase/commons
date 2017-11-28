package com.study.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("tom");
		person.setAge(21);
		try {
			Person cloneBean = (Person) BeanUtils.cloneBean(person);
			System.out.println(cloneBean);

			// 2、 将一个Map对象转化为一个Bean
			// 这个Map对象的key必须与Bean的属性相对应。
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("name", "tom");
			map.put("email", "tom@");
			map.put("age", "21");
			// 将map转化为一个Person对象
			Person person2 = new Person();
			BeanUtils.populate(person2, map);
			System.out.println(person2);
			// 通过上面的一行代码，此时person的属性就已经具有了上面所赋的值了。
			// 将一个Bean转化为一个Map对象了，如下：
			@SuppressWarnings("rawtypes")
			Map map1 = BeanUtils.describe(person2);
			System.out.println(map1);
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
}
