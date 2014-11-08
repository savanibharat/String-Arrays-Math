Replace a string pattern. 
=========
------ 

Suppose we have a string

```String str="bharatbharatbharatbharat";```

and we now want to remove all ```rat``` and replace it with ```xyz```.
 
One way of doing this task is to use String class method ```replaceAll(String regex, String replacement)```

This method will do our work. Output of following sentence::
```System.out.println("bharatbharatbharatbharat".replaceAll("rat", "xyz"));```

Output::

```bhaxyzbhaxyzbhaxyzbhaxyz```

We can built a similar method for this too.

Idea is simple.
Step 1 - We take the old pattern and see if it exists in string.
Step 2 - If it does then we append the previous part of string and then attach the replacement.
Step 3 - We again search further for any other replacement.
Step 4 - If found then we repeat step 2
Step 5 - If not found we return the new string.

```

    // replace old pattern with new pattern
	/**
	 * Replace.
	 *
	 * @param str
	 *            the str
	 * @param oldPattern
	 *            the old pattern
	 * @param newPattern
	 *            the new pattern
	 * @return the string
	 */
	public static String replace(String str, String oldPattern,
			String newPattern) {
		if (!hasLength(str) || !hasLength(oldPattern) || newPattern == null) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		int position = 0;
		int index = str.indexOf(oldPattern);
		int patternLength = oldPattern.length();
		while (index >= 0) {
			sb.append(str.substring(position, index));
			sb.append(newPattern);
			position = index + patternLength;
			index = str.indexOf(oldPattern, position);
		}
		return sb.append(str.substring(position)).toString();
	}