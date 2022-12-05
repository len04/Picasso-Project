package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes multiple arguments.
 * 
 */
public abstract class MultiArgFunction extends ExpressionTreeNode {

	ExpressionTreeNode param1;
	ExpressionTreeNode param2;
	ExpressionTreeNode param3;

	/**
	 * 
	 * @param param1
	 * @param param2
	 */
	public MultiArgFunction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = null;
	}
	
	/**
	 * 
	 * @param param1
	 * @param param2
	 * @param param3
	 */
	public MultiArgFunction(ExpressionTreeNode param1, ExpressionTreeNode param2,
							ExpressionTreeNode param3) {
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		if (this.param3 == null) {
		return classname.substring(classname.lastIndexOf(".")) + "(" + param1 +
				"," + param2 +  ")";
		}
		else {
		return classname.substring(classname.lastIndexOf(".")) + "(" + param1 +
				"," + param2 + "," + param3 +  ")";	
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof MultiArgFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		MultiArgFunction uf = (MultiArgFunction) o;

		// check if their parameters are equal
		if (!this.param1.equals(uf.param1)) {
			return false;
		}
		if (!this.param2.equals(uf.param2)) {
			return false;
		}
		//param3
		return true;
	}

}
