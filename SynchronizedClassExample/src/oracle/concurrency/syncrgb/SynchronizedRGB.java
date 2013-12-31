package oracle.concurrency.syncrgb;

/**
 * <p>
 *  <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/syncrgb.html">SynchronizedRGB</a> defines objects that represent colors. Each object represents the color as three integers that stand for primary color values and a string that gives the name of the color.
 * </p>
 * @author Chris Wong
 *
 */
public class SynchronizedRGB {
	// Values must be between 0 and 255.
	private int red;
	private int green;
	private int blue;
	private String name;
	
	/**
	 * Check if the input values are available
	 * @param red
	 * @param green
	 * @param blue
	 */
	private void check(int red, int green, int blue){
		if(red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Constructor
	 * @param red
	 * @param green
	 * @param blue
	 * @param name
	 */
	public SynchronizedRGB(int red, int green, int blue, String name){
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	/**
	 * Set RGB color
	 * @param red
	 * @param green
	 * @param blue
	 * @param name
	 */
	public void set(int red, int green, int blue, String name){
		check(red, green, blue);
		synchronized (this) {
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;		
		}
	}
	
	/**
	 * Get RGB color
	 * @return
	 */
	public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    /**
     * Get color name
     * @return
     */
    public synchronized String getName() {
        return name;
    }

    /**
     * Invert color
     */
    public synchronized void invert() {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
        name = "Inverse of " + name;
    }
}
