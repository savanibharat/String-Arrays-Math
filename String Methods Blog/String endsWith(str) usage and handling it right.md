String endsWith(str) usage and handling it right.
=========
------ 

In this blog we will see how to use endsWith() method of String API.

```
String str="Sony Playstation";
str.endsWith("station"); //returns true
str.endsWith("Sony"); //returns false
```

We will use this function in such a way that it handles few extra conditions

The following code explains that whether the string input or prefix is not present the method should return false.
```
    if ((!hasLength(str)) && !(hasLength(prefix))) {
		return false;
	}
```

Now, if the length of prefix is greater than the length of string then we return false.
```
	if (prefix.length() > str.length()) {
		return false;
	}
```

If above 2 conditions fail means we are ready to use endsWith(str) method.
Important :: We are converting the input string and prefix to lowerCase because we are comparing them as case insensitive.
```
	if (str.toLowerCase().endsWith(prefix.toLowerCase())) {
		return true;
	}
```

Following is the code for entire method::

    // endsWith prefix (Ignore case)
	/**
	 * Ends with ignore case.
	 *
	 * @param str
	 *            the str
	 * @param suffix
	 *            the suffix
	 * @return true, if successful
	 */
	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if ((!hasLength(str)) && !(hasLength(suffix))) {
			return false;
		}
		if (suffix.length() > str.length()) {
			return false;
		}
		if (str.toLowerCase().endsWith(suffix.toLowerCase())) {
			return true;
		}
		return false;
	}
	