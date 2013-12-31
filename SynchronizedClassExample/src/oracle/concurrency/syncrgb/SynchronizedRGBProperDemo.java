package oracle.concurrency.syncrgb;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class SynchronizedRGBProperDemo {

	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
		final SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
		
		// If another thread invokes color.set after Statement 1 but before Statement 2, the value of myColorInt won't match the value of myColorName.
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5);
				} catch (InterruptedException exception) {

				}
				synchronized (color) {
				    int myColorInt = color.getRGB();
				    String myColorName = color.getName();
				    out.format("Thread1: myColorInt= %d, myColorName= %s%n", myColorInt, myColorName);
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				color.set(128, 128, 128, "Grey") ;     // Problem may occurs
				out.format("Thread2: myColorInt= %d, myColorName= %s%n", color.getRGB(), color.getName());
			}
		}).start();

	}

}
