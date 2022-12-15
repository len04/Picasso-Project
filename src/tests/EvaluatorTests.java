/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {
	
	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testAbsEvaluation() {
		AbsoluteValue myTree = new AbsoluteValue(new X());

		// some straightforward tests
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), myTree.evaluate(i, i));
		}
		
		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double absOfTestVal = Math.abs(testVal);
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testCosineEvaluation() {
		Cosine myTree = new Cosine(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.cos(.4), Math.cos(.4), Math.cos(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.cos(.999), Math.cos(.999), Math.cos(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.cos(-.7), Math.cos(-.7), Math.cos(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double cosineOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(cosineOfTestVal, cosineOfTestVal, cosineOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(cosineOfTestVal, cosineOfTestVal, cosineOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
		
		@Test
		public void testSineEvaluation() {
			Sine myTree = new Sine(new X());
			
			// some straightforward tests
			assertEquals(new RGBColor(Math.sin(.4), Math.sin(.4), Math.sin(.4)), myTree.evaluate(.4, -1));
			assertEquals(new RGBColor(Math.sin(.999), Math.sin(.999), Math.sin(.999)), myTree.evaluate(.999, -1));
			assertEquals(new RGBColor(Math.sin(-.7), Math.sin(-.7), Math.sin(-.7)), myTree.evaluate(-.7, -1));

			// test the ints; remember that y's value doesn't matter
			for (int i = -1; i <= 1; i++) {
				assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
				assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, i));
			}

			double[] tests = { -.7, -.00001, .000001, .5 };

			for (double testVal : tests) {
				double sineOfTestVal = Math.sin(testVal);
				assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal), myTree.evaluate(testVal, -1));
				assertEquals(new RGBColor(sineOfTestVal, sineOfTestVal, sineOfTestVal),
						myTree.evaluate(testVal, testVal));
			}		
	}
	
	@Test
	public void testTangentEvaluation() {
		Tangent myTree = new Tangent(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.tan(.4), Math.tan(.4), Math.tan(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.tan(.999), Math.tan(.999), Math.tan(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.tan(-.7), Math.tan(-.7), Math.tan(-.7)), myTree.evaluate(-.7, -1));
	
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, i));
		}
	
		double[] tests = { -.7, -.00001, .000001, .5 };
	
		for (double testVal : tests) {
			double tangentOfTestVal = Math.tan(testVal);
			assertEquals(new RGBColor(tangentOfTestVal, tangentOfTestVal, tangentOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(tangentOfTestVal, tangentOfTestVal, tangentOfTestVal),
					myTree.evaluate(testVal, testVal));
			}
		}
	
	@Test
	public void testCeilingEvaluation() {
		Ceiling myTree = new Ceiling(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.ceil(.4), Math.ceil(.4), Math.ceil(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.ceil(.999), Math.ceil(.999), Math.ceil(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.ceil(-.7), Math.ceil(-.7), Math.ceil(-.7)), myTree.evaluate(-.7, -1));
	
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), myTree.evaluate(i, i));
		}
	
		double[] tests = { -.7, -.00001, .000001, .5 };
	
		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal),
					myTree.evaluate(testVal, testVal));
			}
		}
	
	@Test
	public void testArcTanEvaluation() {
		ArcTangent myTree = new ArcTangent(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.atan(.4), Math.atan(.4), Math.atan(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.atan(.999), Math.atan(.999), Math.atan(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.atan(-.7), Math.atan(-.7), Math.atan(-.7)), myTree.evaluate(-.7, -1));
	
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.atan(i), Math.atan(i), Math.atan(i)), myTree.evaluate(i, i));
		}
	
		double[] tests = { -.7, -.00001, .000001, .5 };
	
		for (double testVal : tests) {
			double atanOfTestVal = Math.atan(testVal);
			assertEquals(new RGBColor(atanOfTestVal, atanOfTestVal, atanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(atanOfTestVal, atanOfTestVal, atanOfTestVal),
					myTree.evaluate(testVal, testVal));
			}
		}
	
	@Test
	public void testExpEvaluation() {
		Exponential myTree = new Exponential(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.exp(.4), Math.exp(.4), Math.exp(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.exp(.999), Math.exp(.999), Math.exp(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.exp(-.7), Math.exp(-.7), Math.exp(-.7)), myTree.evaluate(-.7, -1));
	
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, i));
		}
	
		double[] tests = { -.7, -.00001, .000001, .5 };
	
		for (double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal),
					myTree.evaluate(testVal, testVal));
			}
		}
	
	@Test
	public void testLogEvaluation() {
		Log myTree = new Log(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.log(.4), Math.log(.4), Math.log(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.log(.999), Math.log(.999), Math.log(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.log(.7), Math.log(.7), Math.log(.7)), myTree.evaluate(-.7, -1));
	
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.log(Math.abs(i)), Math.log(Math.abs(i)), Math.log(Math.abs(i))), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.log(Math.abs(i)), Math.log(Math.abs(i)), Math.log(Math.abs(i))), myTree.evaluate(i, i));
		}
	
		double[] tests = { -.7, -.00001, .000001, .5 };
	
		for (double testVal : tests) {
			double logOfTestVal = Math.log(Math.abs(testVal));
			assertEquals(new RGBColor(logOfTestVal, logOfTestVal, logOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(logOfTestVal, logOfTestVal, logOfTestVal),
					myTree.evaluate(testVal, testVal));
			}
		}
	
	@Test
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 0));
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i+i, i+i, i+i), myTree.evaluate(i, i));
		}
	}
	
	@Test
	public void testClampEvaluation() {
		Clamp myTree = new Clamp(new X());

		// some straightforward tests
		assertEquals(new RGBColor(-.5, -.5, -.5), myTree.evaluate(-0.5, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1.2, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-2, -1));
	}
	
	@Test
	public void testWrapEvaluation() {
		Wrap myTree = new Wrap(new X());

		// some straightforward tests
		assertEquals(new RGBColor(-.5, -.5, -.5), myTree.evaluate(1.5, -1));
		assertEquals(new RGBColor(.1, .1, .1), myTree.evaluate(.1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(4, -1));
		// allow precision threshold for modulo
		assertEquals(new RGBColor(-0.3, -0.3, -0.3).getRed(), myTree.evaluate(1.7, -1).getRed(), 0.0001);
		assertEquals(new RGBColor(.8, .8, .8).getRed(), myTree.evaluate(-3.2, -1).getRed(), 0.0001);

	}
	
	@Test
	public void testSubtractionEvaluation() {
		Subtraction myTree = new Subtraction(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i-i, i-i, i-i), myTree.evaluate(i, i));
		}
	}
	
	@Test
	public void testMultiplicationEvaluation() {
		Multiplication myTree = new Multiplication(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i*i, i*i, i*i), myTree.evaluate(i, i));
		}
	}
	
	@Test
	public void testDivisionEvaluation() {
		Division myTree = new Division(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			if (i != 0) {
				assertEquals(new RGBColor(i/i, i/i, i/i), myTree.evaluate(i, i));
			}
		}
	}
	
	@Test
	public void testModuloEvaluation() {
		Modulo myTree = new Modulo(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			if (i != 0) {
				assertEquals(new RGBColor(i%i, i%i, i%i), myTree.evaluate(i, i));
			}
		}
	}
	
	@Test
	public void testExponentiationEvaluation() {
		Exponentiation myTree = new Exponentiation(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			if (i != 0) {
			assertEquals(new RGBColor(Math.pow(i, i),Math.pow(i, i),Math.pow(i, i)), myTree.evaluate(i, i));
			}
		}
	}
	
	@Test
	public void testAssignmentEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("a = x + y");
		assertEquals(new RGBColor(1, 1, 1), e.evaluate(1, 0));
		
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), e.evaluate(i, 0));	
		}
	}
	
	@Test
	public void testRgbToYCrCbEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb(x)");
		assertEquals(new RGBColor (0, 0, 0), e.evaluate(0, 0));
		assertEquals(new RGBColor (1.0, 9.999999999998899E-5, 9.999999999998899E-5), e.evaluate(1,1));
	}
	
	@Test
	public void testyCrCbToRGBEvaluatiton (){
		ExpressionTreeNode e = parser.makeExpression("yCrCbToRGB(x)");
		assertEquals(new RGBColor (0, 0, 0), e.evaluate(0, 0));
		assertEquals(new RGBColor (2.4021999999999997, -0.06010000000000004, 2.771), e.evaluate(1, 1));
	}
	
	@Test
	public void testInversionEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new RGBColor (-1,-1,-1), e.evaluate(1, 1));
		assertEquals(new RGBColor (0, 0, 0), e.evaluate(0, 0));
		
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), e.evaluate(-i, -i));	
		}
	}
	
	@Test
	public void testPerlinColorEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("perlinColor(x,y)");
		assertEquals(new RGBColor (0.02276399999999995, -0.24566505471999994, 0.083736), e.evaluate(0, 0));	
		assertEquals(new RGBColor (0.45749417280000004,0.09574400000000001 , 0.19672254720000015), e.evaluate(1, 1));
	}
	
	@Test
	public void testPerlinBWEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("perlinBW(x,y)");
		assertEquals(new RGBColor (0.02276399999999995, 0.02276399999999995, 0.02276399999999995), e.evaluate(0, 0));
		assertEquals(new RGBColor  (0.45749417280000004, 0.45749417280000004 , 0.45749417280000004), e.evaluate(1, 1));
	}
}
