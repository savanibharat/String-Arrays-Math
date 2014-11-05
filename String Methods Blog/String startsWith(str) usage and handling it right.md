String startsWith(str) usage and handling it right.
=========
------ 

In this blog we will see how to use startsWith() method of String API.

```
String str="Sony Playstation";
str.startsWith("Sony"); //returns true
str.startsWith("Sony"); //returns false
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

If above 2 conditions fail means we are ready to use startsWith(str) method.
Important :: We are converting the input string and prefix to lowerCase because we are comparing them as case insensitive.
```
	if (str.toLowerCase().startsWith(prefix.toLowerCase())) {
		return true;
	}
```

Following is the code for entire method::

    // startsWith prefix (Ignore case)
	/**
	 * Starts with ignore case.
	 *
	 * @param str
	 *            the str
	 * @param prefix
	 *            the prefix
	 * @return true, if successful
	 */
	public static boolean startsWithIgnoreCase(String str, String prefix) {

		if ((!hasLength(str)) && !(hasLength(prefix))) {
			return false;
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		if (str.toLowerCase().startsWith(prefix.toLowerCase())) {
			return true;
		}
		return false;
	}