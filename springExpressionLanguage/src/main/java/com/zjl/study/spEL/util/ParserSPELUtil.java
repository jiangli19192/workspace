package com.zjl.study.spEL.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ParserSPELUtil {
	public static void parseString(String expression) {
		// 创建SpEL表达式的解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式'Hello '+' World!'
		Expression exp = parser.parseExpression(expression);
		// 取出解析结果
		String result = exp.getValue().toString();
		// 输出结果
		System.out.println(result);
	}

	public static Object parseExpressionByContext(String expression,
			EvaluationContext context) {
		// 创建SpEL表达式的解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式'Hello '+' World!'
		Expression exp = parser.parseExpression(expression);
		// 取出解析结果; getValue()方法返回的是一个Object对象，需要进行显示类型转换
		return exp.getValue(context);
	}

	public static <T> T parseExpressionByContext(String expression,
			EvaluationContext context, Class<T> typeClass) {
		// 创建SpEL表达式的解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式'Hello '+' World!'
		Expression exp = parser.parseExpression(expression);
		// 取出解析结果
		return exp.getValue(context, typeClass);
	}
}
