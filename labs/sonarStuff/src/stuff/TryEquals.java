package stuff;

import java.util.List;

public class TryEquals {

	private String x;
	private String y;
	private String z;



	/**
	 * Constructs a TryEquals object with the given x and y strings, and initializes z as the concatenation of x and y.
	 * @param x The first string
	 * @param y The second string
	 */
	public TryEquals(String x, String y) {
		this.x = x;
		this.y = y;
		this.z = x+y;
	}



	/**
	 * Gets the string z.
	 * @return The concatenated string z
	 */
	public String getZ() {
		return z;
	}


	/**
	 * Prints the concatenation of x, y, and z to the console.
	 */
	public void printAll() {
		System.out.println(x+y+z);
	}


	/**
	 * Sets the value of the concatenated string z.
	 * @param z The new value for z
	 */
	public void setZ(String z) {
		this.z = z;
	}

	 /**
     * Concatenates each string in the input list to x and y.
     * @param strings The list of strings to concatenate with x and y
     */
	public void putAllTogether(List<String> strings) {
		for (String str : strings) {
			x = x + str;
			y = y + str;

		}
	}



	@Override
	public boolean equals(Object obj) {
		if (testaNull(obj)) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TryEquals other = (TryEquals) obj;
		return x.equals(other.x) && y.equals(other.y);
	}


	/**
     * Compares this TryEquals object to the specified object for equality.
     * @param obj The object to compare to
     * @return true if the objects are equal, false otherwise
     */
	private static boolean testaNull(Object obj) {
		return obj != null;
	}


    /**
     * Checks if the given object is null.
     */
	public void increments() {
		int j = 0;
		for (int i = 0; i < 2; j++, i++) {
			x += 1;
			y = y+1;
		}
		System.out.println(j);
	}


	/**
	 * Increments the value of x based on the input integer z.
	 * If z is less than 10, x is incremented by z.
	 * If z is between 10 and 49, x is incremented by z+1.
	 * If z is 50 or more, x is incremented by z+10.
	 * @param z The value to increment x by
	 */
	public void incrementsByValue(int z) {
		if (z < 10) {
			x = x+z;

		}
		else if(z < 50)	{
			x= x+z+1;
		}
		else {
			x= x+z+10;
		}
	}

	/**
	 * Prints the value of x to the console if the input boolean a is true.
	 * @param a The condition for printing the value of x
	 */
	public void printX(boolean a) {
		System.out.println(a);
	}



}
