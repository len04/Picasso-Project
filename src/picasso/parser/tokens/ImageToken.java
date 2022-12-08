package picasso.parser.tokens;

/**
 * Represents an image (using string of it's name). Using equals, a ImageToken object
 * compares as true only to another ImageToken object with the same name
 * <P>
 * a ImageToken is immutable, once created it doesn't change.
 *
 * @author Petra Ilic
 *
 */
public class ImageToken extends Token {
	
	private final String imageName;

	/**
	 * Constructs a token representing imageName
	 * 
	 * @param imageName the name of this image token
	 */
	public ImageToken(String imageName) {
		super("Image Token");
		this.imageName = imageName;
	}

	public String getName() {
		return this.imageName;
	}
	
	public String toString() {
		return super.toString() + ": " + imageName;
	}
	
	@Override
	public boolean isConstant() {
		return true;
	}

	@Override
	public boolean isFunction() {
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ImageToken)) {
			return false;
		}
		ImageToken other = (ImageToken) o;
		return imageName.equals(other.getName());
	}

}
