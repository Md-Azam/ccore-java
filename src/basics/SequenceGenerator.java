package basics;

public class SequenceGenerator {
	
	/*
	 *Define a class SequenceGenerator with A private integer variable counter.
	 *Constructor SequenceGenerator() Initialize counter to 1.
	 *Method getNextString()
	 *Format the current value of counter as a string with
	 *Prefix "G" 6-digit zero-padded number (e.g., "G000001") 
	 *Store the formatted string in a variable nextString.
	 *Increment counter by 1.
	 *Return nextString.
	 *Main Method
	 *Create an object generator of SequenceGenerator.
	 *Loop from i = 1 to i < 5 (4 times)
	 *Call generator.getNextString() and store result in nextString
	 *Print nextString.
	 */
	private int counter;

	//Constructor gets called automatically when an object of Main is created
	public SequenceGenerator() {
		// Initialize the counter to 1
		this.counter = 1;
	}
		//Non-static methods belong to an object.
		public String getNextString() {
			// Format the string with the counter
			String nextString = String.format("SLH%06d", counter);
			// Increment the counter for the next call
			counter++;
			return nextString;
		}
		public static void main(String[] args) {
			SequenceGenerator generator = new SequenceGenerator();
			// Generate and print the next 5 strings in the sequence
			for (int i = 1; i < 15; i++) {
				String nextString = generator.getNextString();
				System.out.println(nextString);
			}
		}
}
