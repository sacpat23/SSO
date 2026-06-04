package com.qa.base;

import java.util.ArrayList;

public class LambdaExpressionTest1 {

	public static void main(String[] args) {

		ArrayList<String> a = new ArrayList<String>();
		a.add("Apple");
		a.add("Boll");
		a.add("Aat");
		a.add("Dog");
		a.add("Elephant");

		Long name = a.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(name);

		for (int i = 0; i < a.size(); i++) {
			String p = a.get(i);
			System.out.println(p);

		}
		System.out.println("====================");
		
		a.stream().filter(s-> s.length()>4).forEach(s->System.out.println(s));
		System.out.println("======");
	
		
		

	}

}
