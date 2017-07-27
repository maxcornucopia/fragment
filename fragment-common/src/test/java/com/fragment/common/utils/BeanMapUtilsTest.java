package com.fragment.common.utils;

import org.junit.Test;

/**
 * @auth : luxt
 * @e-mail : luxt@cloudyigou.com
 * @desc : 文件作用说明
 */
public class BeanMapUtilsTest {


	@Test
	public void transBean2Map() {
		Person person = new Person();
		BeanMapUtils.transBean2Map(person);
	}


}

class Person {

}