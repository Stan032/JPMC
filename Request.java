package jPMC;

import java.util.HashMap;
import java.util.Map;

/**
 * I dont have experience with REST API so this is the best i cloud come up with.
 * 
 * Example Request class that provides access to user data. Pretend this class
 * accesses a database.
 */

public class Request {

	// Map of names to Bank instances.
	private Map<String, Bank> infoMap = new HashMap<>();

	// this class is a singleton and should not be instantiated directly!
	private static Request instance = new Request();

	public static Request getInstance() {
		return instance;
	}

	// private constructor so people know to use the getInstance() function instead
	private Request() {
		// dummy data
		infoMap.put("Source1", new Bank("Source1", "https://source1.com/v1/api/account/validate", 12345678));
		infoMap.put("Source2:", new Bank("Source2", "https://source2.com/v2/api/account/validate.", 12345678));

	}

	public Bank getBank(String source1) {
		return infoMap.get(source1);
	}

	public void putBank(Bank source1) {
		infoMap.put(source1.getSource1(), source1);
	}

}