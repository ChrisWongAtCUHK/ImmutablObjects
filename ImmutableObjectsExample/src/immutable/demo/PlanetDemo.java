package immutable.demo;

import java.util.Calendar;

import static java.lang.System.out;

/**
 * <p>
 *  PlanetDemo is a demostration
 * </p>
 * @author Chris Wong
 *
 */
public class PlanetDemo {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		
		// planet 1
		cal.set(1999, Calendar.SEPTEMBER, 24);
		Planet planet1 = new Planet(924, "Chris Wong", cal.getTime());
		out.format("planet1: mass=%f; name=%s%n", planet1.getMass(), planet1.getName());
		
		// planet 2
		cal.set(2036, Calendar.JULY, 9);
		Planet planet2 = new Planet(21, "Amby Andy", cal.getTime());
		out.format("planet2: mass=%f; name=%s%n", planet2.getMass(), planet2.getName());
		
		// planet 3
		Planet planet3 = new Planet(planet1.getMass(), planet1.getName(), planet1.getDateOfDiscovery());
		out.format("planet3: mass=%f; name=%s%n", planet3.getMass(), planet3.getName());
	}
}
