package chapter_11b.p11_16;

/**
 * Chapter 11 - Problems 16 - 21: Catching Exceptions
 * @author Douglas Skrypa
 * @version 2015.02.16
 */
public class ExceptionA extends Exception {
	private static final long serialVersionUID = -7854942267280238014L;
	private static final String DEFAULT_MSG = "Encountered Exception";
	
	public ExceptionA() {
		super(DEFAULT_MSG);
	}
	
	public ExceptionA(final String msg) {
		super(DEFAULT_MSG + " " + msg);
	}
}