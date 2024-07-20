package com.jdc.online.problem;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class BalanceChecker1 {
	
	public boolean isBalance(String value) 
	{
		
		if(value ==null || value.isBlank())
		{
			throw new IllegalArgumentException();
		}
		
		char[] chars = value.toCharArray();
		Queue<Character> stack = Collections.asLifoQueue(new ArrayDeque<Character>());
		
		for(char current :chars)
		{
			switch(current)
			{
			case '(','{','[' -> stack.offer(current);
			case ')','}',']' -> {
				var last = stack.poll();
				if(null == last || !isMatch(last, current))
				{
					return false;
				}
			}
			default -> throw new IllegalArgumentException();
			}
		}

		return stack.isEmpty();
	}
	
	public boolean isMatch(Character last, char current)
	{
		return (last == '(' && current == ')')
			|| (last == '{' && current == '}')
			|| (last == '[' && current == ']');
	}
}
