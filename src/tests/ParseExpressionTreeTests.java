package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ParseExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Subtraction(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x-y");
		assertEquals(new Subtraction(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Subtraction(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x - y - [ -.51, 0, 1]");
		assertEquals(new Subtraction(new Subtraction(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void multiplicationExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x * y");
		assertEquals(new Multiplication(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x*y");
		assertEquals(new Multiplication(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] * y");
		assertEquals(new Multiplication(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x * y * [ -.51, 0, 1]");
		assertEquals(new Multiplication(new Multiplication(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void divisionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x / y");
		assertEquals(new Division(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x/y");
		assertEquals(new Division(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] / y");
		assertEquals(new Division(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x / y / [ -.51, 0, 1]");
		assertEquals(new Division(new Division(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void moduloExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x % y");
		assertEquals(new Modulo(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x%y");
		assertEquals(new Modulo(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] % y");
		assertEquals(new Modulo(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x % y % [ -.51, 0, 1]");
		assertEquals(new Modulo(new Modulo(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}
	
	@Test
	public void exponentiationExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x ^ y");
		assertEquals(new Exponentiation(new X(), new Y()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x^y");
		assertEquals(new Exponentiation(new X(), new Y()), e1);

		e1 = parser.makeExpression("[1,.3,-1] ^ y");
		assertEquals(new Exponentiation(new RGBColor(1, .3, -1), new Y()), e1);
		
		e1 = parser.makeExpression("x ^ y ^ [ -.51, 0, 1]");
		assertEquals(new Exponentiation(new Exponentiation(new X(), new Y()), new RGBColor(-.51, 0, 1)), e1);
	}

	
	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void cosineFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cosine(new X()), e);

		e = parser.makeExpression("cos( x + y )");
		assertEquals(new Cosine(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void sineFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("sin( x )");
		assertEquals(new Sine(new X()), e);

		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sine(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void absoluteFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new Absolute(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new Absolute(new Addition(new X(), new Y())), e);
	}

	@Test
	public void tangentFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan( x )");
		assertEquals(new Tangent(new X()), e);

		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tangent(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void clampFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("clamp( x )");
		assertEquals(new Clamp(new X()), e);

		e = parser.makeExpression("clamp( x + y )");
		assertEquals(new Clamp(new Addition(new X(), new Y())), e);
	}
	
}
