package com.qa.base;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ra1 {

	public static void main(String[] args) {
//
//		List<String> a = Arrays.asList("a", "b", "c", "d");
//		System.out.println(a);
//
//		System.out.println(a.stream().filter(z -> "a".equals("x")).findAny().orElse(null));

//		Function<String, Integer> l = x -> x.length();
//		Integer i = l.apply("This is JAVA 8");
//		System.out.println(i);
//
//		Function<Integer, Integer> l1 = x -> x * 2;
//		Integer m = l.andThen(l1).apply("Java");
//		System.out.println(m);

//	

		Predicate<Integer> p = x -> x > 5;
		
		List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,9);

	}

}

// functional interface introduced in JAVA 1.8
//function interface has only 1 abstract method
//static and other methods are allowed
//@FunctionalInterface
