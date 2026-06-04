package com.qa.base;

import java.util.HashMap;
import java.util.Map;

public class streaming {
	public static void main(String[] args) {

		Map<String, String> s = new HashMap<>();
		s.put("one", "admin");
		s.put("two", "sales");
		s.put("three", "technology");
		s.put("four", "services");
		
		s.forEach((k, v) -> {
			System.out.println("Key is " + v);
		});
	}

}
