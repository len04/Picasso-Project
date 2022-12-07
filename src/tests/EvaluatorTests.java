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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
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
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i + i, i + i, i + i), myTree .evaluate(i, i));
			assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 0));
			
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
}
