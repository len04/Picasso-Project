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
public class ParsedExpressionTreeTests {

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
	public void inversionExpressionTests() {
		
		ExpressionTreeNode e = parser.makeExpression("! x");
		assertEquals(new Inversion(new X()), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("!x");
		assertEquals(new Inversion(new X()), e1);
		
		e1 = parser.makeExpression("!(floor(x)*y)");
		assertEquals(new Inversion(new Multiplication(new Floor(new X()), new Y())), e1);
	}

	
	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}
	
	@Test
	public void orderOfoperationsExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y * [ -.51, 0, 1]");
		assertEquals(new Addition(new X(), (new Multiplication(new Y(), new RGBColor(-.51, 0, 1)))), e);
		
		// no spaces!
		ExpressionTreeNode e1 = parser.makeExpression("x+y*[ -.51, 0, 1]");
		assertEquals(new Addition(new X(), (new Multiplication(new Y(), new RGBColor(-.51, 0, 1)))), e1);
		
		e1 = parser.makeExpression("x * (y + [1, .3, -1])");
		assertEquals(new Multiplication(new X(), (new Addition(new Y(), new RGBColor(1, .3, -1)))), e1);
		
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
		assertEquals(new AbsoluteValue(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new AbsoluteValue(new Addition(new X(), new Y())), e);
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

	@Test
	public void wrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("wrap( x )");
		assertEquals(new Wrap(new X()), e);

		e = parser.makeExpression("wrap( x + y )");
		assertEquals(new Wrap(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void ceilFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("ceil( x )");
		assertEquals(new Ceiling(new X()), e);

		e = parser.makeExpression("ceil( x + y )");
		assertEquals(new Ceiling(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void atanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("atan( x )");
		assertEquals(new ArcTangent(new X()), e);

		e = parser.makeExpression("atan( x + y )");
		assertEquals(new ArcTangent(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("exp( x )");
		assertEquals(new Exponential(new X()), e);

		e = parser.makeExpression("exp( x + y )");
		assertEquals(new Exponential(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void logFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("log( x )");
		assertEquals(new Log(new X()), e);

		e = parser.makeExpression("log( x + y )");
		assertEquals(new Log(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void randomFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("random()");
		assertEquals(new Random(), e);
	}
	
	@Test
	public void imageClipFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageClip(\"vortex.jpg\", x, y)");
		assertEquals(new ImageClip(new Image("vortex.jpg"), new X(), new Y()), e);
		
		ExpressionTreeNode e2 = parser.makeExpression("imageClip(\"vortex.jpg\", x+x, y )");
		assertEquals(new ImageClip(new Image("vortex.jpg"),new Addition(new X(), new X()), new Y()), e2);
	}
	
	@Test
	public void imageWrapFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("imageWrap(\"vortex.jpg\", x, y)");
		assertEquals(new ImageWrap(new Image("vortex.jpg"), new X(), new Y()), e);
		
		ExpressionTreeNode e2 = parser.makeExpression("imageWrap(\"vortex.jpg\", x+x, y )");
		assertEquals(new ImageWrap(new Image("vortex.jpg"),new Addition(new X(), new X()), new Y()), e2);
	}
	
	@Test
	public void assignmentTests() {
		ExpressionTreeNode e = parser.makeExpression("f = floor(x)");
		String f = "f";
		Assignment result = new Assignment(f, new Floor(new X()));
		assertEquals(result, e);		
	}	
	
	@Test
	public void RGBToYCrCbFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb( x )");
		assertEquals(new RgbToYCrCb(new X()), e);
		
		e = parser.makeExpression("rgbToYCrCb( y )");
		assertEquals(new RgbToYCrCb(new Y()), e);
		
		e = parser.makeExpression("rgbToYCrCb( x * y )");
		assertEquals(new RgbToYCrCb(new Multiplication(new X(), new Y())), e);
	}
	
	@Test
	public void yCrCbToRGBFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("yCrCbToRGB( x )");
		assertEquals(new YCrCbToRGB(new X()), e);
		
		e = parser.makeExpression("yCrCbToRGB( y )");
		assertEquals(new YCrCbToRGB(new Y()), e);
		
		e = parser.makeExpression("yCrCbToRGB( x + y )");
		assertEquals(new YCrCbToRGB(new Addition(new X(), new Y())), e);
	}
	
	@Test
	public void perlinColorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor( x , y )");
		assertEquals(new PerlinColor(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinColor( y , x )");
		assertEquals(new PerlinColor(new Y(), new X()), e);
		
		e = parser.makeExpression("perlinColor( x + y, y % x )");
		assertEquals(new PerlinColor(new Addition(new X(), new Y()), new Modulo(new Y(), new X())), e);
	}
	
	@Test
	public void perlinBWFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("perlinBW( x , y )");
		assertEquals(new PerlinBW(new X(), new Y()), e);
		
		e = parser.makeExpression("perlinBW( y , x )");
		assertEquals(new PerlinBW(new Y(), new X()), e);
		
		e = parser.makeExpression("perlinBW( x + y, y ^ x )");
		assertEquals(new PerlinBW(new Addition(new X(), new Y()),new Exponentiation(new Y(), new X())), e);
	}
}
