Remove all Leading and Trailing spaces from String
=========
------ 

String can contain white space. Sometimes those white space are not important so we try to remove them.

```String str="   some string goes here    ";```

The above declared String contains white spaces. 

```str.trim()``` will help you get rid of the leading and trailing spaces.

But for instance consider that you want to remove only Leading or Trailing white space.

For such thing to achive we can write our own function.

If there are any leading white spaces they will be removed by loop
```
    while (sb.length() > 0 && sb.charAt(0) == 32) {
		sb.deleteCharAt(0);
	}
```
If there are any trailing white spaces they will be removed by loop
```
    while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 32) {
		sb.deleteCharAt(sb.length() - 1);
	}
```
```

    // Trim all first and all last spaces from string
	/**
	 * Trim white spaces sync.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String trimWhiteSpacesSync(String str) {

		if (!hasLength(str)) {
			return "";
		}
		StringBuffer sb = new StringBuffer(str);
		sb = removeLeadingWhiteSpaces(sb);
		sb = removeTrailingWhiteSpaces(sb);
		return sb.toString();
	}

	/**
	 * Removes the all leading white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string buffer
	 */
	public static StringBuffer removeLeadingWhiteSpaces(StringBuffer sb) {
		while (sb.length() > 0 && sb.charAt(0) == 32) {
			sb.deleteCharAt(0);
		}
		return sb;
	}

	/**
	 * Removes the all trailing white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string buffer
	 */
	public static StringBuffer removeTrailingWhiteSpaces(StringBuffer sb) {
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 32) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}
