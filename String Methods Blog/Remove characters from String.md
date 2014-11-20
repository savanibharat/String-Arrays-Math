# How to remove characters from a String?

The question is that given a String we are required to remove some characters from that String.

For example:
```
String str="The quick brown fox jumps over the lazy dog";
String charsToRemove="aeiou";
```
After removing all the characters from the ```input``` String we get ```output``` as ::
```
Th qck brwn fx jmps vr th lzy dg
```
To built a method which can do this task is relatively easy to do.

We need two inputs compulsory.
* ```Input String ```
* ```Chacters to delete```

We consider that the characters that are to be deleted will be inputed as a String.

```
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (charsToDelete.indexOf(str.charAt(i)) == -1) {
				sb.append(str.charAt(i));
			}
		}
```
In above function we iterate through the input String.<br>
While iterating we try to check whether the character pointing at ith location is present in charsToDelete String.<br>
If NOT present then we can append it to StringBuilder object.<br>
Else we need NOT append it.<br>

Following is the code for the method
```
    // delete characters from string
	/**
	 * Chars to delete.
	 *
	 * @param str
	 *            the str
	 * @param charsToDelete
	 *            the chars to delete
	 * @return the string
	 */
	public static String charsToDelete(String str, String charsToDelete) {

		if (!hasLength(str) || !hasLength(charsToDelete)
				|| charsToDelete == null) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (charsToDelete.indexOf(str.charAt(i)) == -1) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
```