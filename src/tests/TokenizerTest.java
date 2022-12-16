package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.DivideToken;
import picasso.parser.tokens.operations.ExponentiateToken;
import picasso.parser.tokens.operations.InvertToken;
import picasso.parser.tokens.operations.MinusToken;
import picasso.parser.tokens.operations.ModToken;
import picasso.parser.tokens.operations.PlusToken;
import picasso.parser.tokens.operations.TimesToken;

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}
	
	/**
	 * Test that parsing an expression with a comment works
	 */
	@Test
	public void testTokenizeComment() {
		String expression = "x // this is a comment";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(1, tokens.size());
		
		expression = "// everything is a comment";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(0, tokens.size());
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));

		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}

	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

	@Test
	public void testTokenizeInvalidColor() {
		String expression = "[2, 3 ,4]";
		assertThrows(ParseException.class, () -> {
			tokenizer.parseTokens(expression);
		});
	}
	
	@Test
	public void testQuotedStringImage() {
		String expression = " \"vortex.png\" ";
		tokens = tokenizer.parseTokens(expression);
		// handled quietly by generating black image and providing error message in error box
		assertEquals(new ImageToken("vortex.png"), tokens.get(0));
	}

	@Test
	public void testTokenizeBasicFunctionExpressions() {
		String expression = "floor(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new FloorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "abs(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new AbsToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));
 		
 		expression = "cos(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new CosToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));
 		
 		expression = "clamp(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ClampToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "wrap(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new WrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		expression = "atan(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new AtanToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));

 		expression = "ceil(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new CeilToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));

 		expression = "exp(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new ExpToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));

 		expression = "log(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new LogToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));

 		expression = "sin(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new SinToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));

 		expression = "tan(x)";
 		tokens = tokenizer.parseTokens(expression);
 		assertEquals(new TanToken(), tokens.get(0));
 		assertEquals(new LeftParenToken(), tokens.get(1));
 		assertEquals(new IdentifierToken("x"), tokens.get(2));
 		assertEquals(new RightParenToken(), tokens.get(3));
 		
 		expression = "rgbToYCrCb(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RgbToYCrCbToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));

		expression = "yCrCbToRGB(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new YCrCbToRGBToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
  	}		  	
	
	@Test
	public void testTokenizeMultiArgumentExpressions() {
		String expression = "perlinColor(x,y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new PerlinColorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		
		expression = "perlinBW(x,y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new PerlinBWToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("y"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
	}
	
	@Test
	public void testNoArgumentExpressions() {
		String expression = "random()";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new RandomToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new RightParenToken(), tokens.get(2));
	}
		
	
	@Test
	public void testTokenizeCombinedFunctionExpressions() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new PerlinColorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new FloorToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new RightParenToken(), tokens.get(5));
		assertEquals(new CommaToken(), tokens.get(6));
		assertEquals(new IdentifierToken("y"), tokens.get(7));
		assertEquals(new RightParenToken(), tokens.get(8));

		expression = "sin(perlinColor(x, y))";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new SinToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new PerlinColorToken(), tokens.get(2));
		assertEquals(new LeftParenToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new CommaToken(), tokens.get(5));
		assertEquals(new IdentifierToken("y"), tokens.get(6));
		assertEquals(new RightParenToken(), tokens.get(7));
		assertEquals(new RightParenToken(), tokens.get(8));
	}
		
	@Test
	public void testImageManipulationFunction() {
		String expression = "imageClip(\"vortex.jpg\", x, y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ImageClipToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new ImageToken("vortex.jpg"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new CommaToken(), tokens.get(5));
		assertEquals(new IdentifierToken("y"), tokens.get(6));
		assertEquals(new RightParenToken(), tokens.get(7));
		
		expression = "imageWrap(\"vortex.jpg\", x, y)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ImageWrapToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new ImageToken("vortex.jpg"), tokens.get(2));
		assertEquals(new CommaToken(), tokens.get(3));
		assertEquals(new IdentifierToken("x"), tokens.get(4));
		assertEquals(new CommaToken(), tokens.get(5));
		assertEquals(new IdentifierToken("y"), tokens.get(6));
		assertEquals(new RightParenToken(), tokens.get(7));
	}
	
	@Test
	public void testTokenizeBasicOperationExpression() {
		String expression = "x+y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new PlusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x-y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new MinusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x*y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new TimesToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x/y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new DivideToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		
		expression = "x%y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new ModToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));

		expression = "x^y";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new ExponentiateToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
	}
	
	@Test
	public void testTokenizeInversionOperationExpression() {
		String expression = "!x";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new InvertToken(), tokens.get(0));
		assertEquals(new IdentifierToken("x"), tokens.get(1));
	}
}
