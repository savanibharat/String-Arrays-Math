Trim all whitespace from String
=========
------ 

In previous ReadMe we saw how to remove leading and/or trailing white spaces.

In this blog we will how to remove all white space from String.

```String str="   a b   c      d    ";```

The above declared String contains white spaces. 

```str.trim()``` will help you get rid of the leading and trailing spaces.

So output will be 
```a b   c      d```

But for instance consider that you want to remove white space.

For such thing to achive we can write our own function.


    // Remove all white spaces
	/**
	 * Trim all white spaces.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String trimAllWhiteSpaces(String str) {
		if (!hasLength(str)) {
			return "";
		}
		StringBuffer sb = new StringBuffer(str);
		for (int index = 0; index < sb.length();) {
			if (sb.charAt(index) == 32) {
				sb.deleteCharAt(index);
			} else {
				index++;
			}
		}
		return sb.toString();
	}
