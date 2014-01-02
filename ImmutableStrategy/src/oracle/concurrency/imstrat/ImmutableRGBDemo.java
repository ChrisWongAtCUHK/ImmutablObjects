package oracle.concurrency.imstrat;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class ImmutableRGBDemo {
	public static void main(String[] args) {
		
		final ImmutableRGB color = new ImmutableRGB(0, 0, 0, "Pitch Black");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5);
				} catch (InterruptedException exception) {

				}
				int myColorInt = color.getRGB();      // Statement 1
				String myColorName = color.getName(); // Statement 2
				
				out.format("Thread1: myColorInt= %d, myColorName= %s%n", myColorInt, myColorName);
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				out.format("Thread2: myColorInt= %d, myColorName= %s%n", (new ImmutableRGB(128, 128, 128, "Grey")).getRGB(), (new ImmutableRGB(128, 128, 128, "Grey")).getName());
			}
			
		}).start();
	}
}
