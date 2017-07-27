package com.fragment.common.utils;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @desc : 用于bean对象和map对象转换
 */
public class BeanMapUtils {

	public static final String CLASS = "class";

	private static Logger logger = LoggerFactory.getLogger(BeanMapUtils.class);

	/**
	 * bean对象转换为map
	 *
	 * @param bean bean 对象
	 * @return 转换后的map
	 */
	public static Map<String, Object> transBean2Map(Object bean) {

		if (null == bean) {
			return null;
		}
		Map<String, Object> map = Maps.newHashMap();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String name = propertyDescriptor.getName();
				//跳过class属性
				if (!CLASS.equals(name)) {
					Method readMethod = propertyDescriptor.getReadMethod();
					Object value = readMethod.invoke(bean);
					map.put(name, value);
				}

			}

		} catch (IntrospectionException e) {
			logger.error("bean对象转换为map异常:", e);
		} catch (IllegalAccessException e) {
			logger.error("bean对象转换为map异常:", e);
		} catch (InvocationTargetException e) {
			logger.error("bean对象转换为map异常:", e);
		}
		return map;
	}


}