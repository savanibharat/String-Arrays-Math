How to seee if String has text or not?
=========
------ 

String are one of the most important concepts that we use in Java. 
 
But using them properly is hard thing to do.
 
Some times we encounter a string with length > 0 but it does not have anything in it.
It contains only space.
 
In this gist I try to explain how to use such string's in program.
 
Below is the utility method which is used to detect such Strings. 
 
32 is ASCII for space. We use that to compare every character in string.
If any character's(if present) does not meet the ASCII of the space then it will return true.
else it will return false;
 
return true: String has text in it. May or may not contain space.
return false: String does not have text.
```     
    // Checks if there is text in string(except space)
	/**
	 * Checks for text.
	 *
	 * @param str
	 *            the str
	 * @return true, if successful
	 */
	public static boolean hasText(String str) {

		if (!hasLength(str)) {
			return false;
		}
		// Check if any character exists except space
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == 32)) {// 32 is ASCII for space
				return true;
			}
		}
		return false;
	}```

