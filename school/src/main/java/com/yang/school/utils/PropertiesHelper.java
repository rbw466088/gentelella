package com.yang.school.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
	public static void main(String[] args) {
		Properties ps =  new Properties();
		try(InputStream in = PropertiesHelper.class.getClassLoader().getResourceAsStream("jdbc.properties")){
			ps.load(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ps.get("jdbc.driver"));
		System.out.println(ps.get("jdbc.url"));
		System.out.println(ps.get("jdbc.username"));
		System.out.println(ps.get("jdbc.password"));
	}
}
