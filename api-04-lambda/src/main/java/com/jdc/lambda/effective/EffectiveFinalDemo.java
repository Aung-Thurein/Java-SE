package com.jdc.lambda.effective;

import java.util.ArrayList;
import java.util.List;

public class EffectiveFinalDemo {
	
		List<Integer> list = new ArrayList<Integer>();
	
	Runnable runnable = () -> {
		list.forEach(data -> System.out.println(data));
		list.add(null);
	};
	

	}

		

