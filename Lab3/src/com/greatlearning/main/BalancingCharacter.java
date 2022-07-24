package com.greatlearning.main;

import java.util.Stack;

public class BalancingCharacter {

	public static boolean checkBracketsBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();

		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);

			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
				continue;

			}
			if (stack.isEmpty())
				return false;
			char c;
			switch (character) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case ')':
				c = stack.pop();
				if (c == '[' || c == '{')
					return false;
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			}

		}
		return (stack.isEmpty());

	}

	public static void main(String[] args) {
		if (checkBracketsBalanced("([{}])".trim())) {
			System.out.println("The entered String has Balanced Brackets");// here in the if condition we are checking
																			// whether the brackets are balanced or not

		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
