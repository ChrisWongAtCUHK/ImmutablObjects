package oracle.concurrency.imstrat;

/**
 * <p>
 * 	<a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html">
 * </p>
 * @author Chris Wong
 *
 */
final public class ImmutableRGB {
	
	// Values must be between 0 and 255.
	final private int red;
	final private int green;
	final private int blue;
	final private String name;
	
	/**
	 * Check if rgb value is correct
	 * @param red
	 * @param green
	 * @param blue
	 */
	private void check(int red, int green, int blue){
		if(red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || green > 255){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Constructor
	 * @param red	r value
	 * @param green	g value
	 * @param blue	b value
	 * @param name	color name
	 */
	public ImmutableRGB(int red, int green, int blue, String name){
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	/**
	 * @return color RGB
	 */
	public int getRGB(){
		return ((red << 16) | (green << 8) | blue);
	}
	
	/**
	 * @return color name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return the inversion of color
	 */
	public ImmutableRGB invert(){
		return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
	}

}
