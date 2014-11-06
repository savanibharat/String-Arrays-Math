String countOccurencesofString(String str, String subString) 
=========
------ 

In this blog we will see how to use ```indexOf(str1,str2)``` overloaded method of String API.
First let us see how normal ```indexOf(str)``` works.
```System.out.println("abcd".indexOf("a")); 0```
It returns 0 as it finds at oth index the string "a"
```indexOf(str)``` is case sensitive method so make sure that you are comparing it properly.

The below statement when executed return -1 as it cannot find A character in the string abcd
Remember due to case sensitive nature it returns -1.
```System.out.println("abcd".indexOf('A')); -1```

```
		
		System.out.println("abcd".indexOf('A')); -1
		System.out.println("abcd".indexOf("b")); 1
		System.out.println("abcd".indexOf('B')); -1
		System.out.println("abcd".indexOf("c")); 2
		System.out.println("abcd".indexOf('C')); -1
		System.out.println("abcd".indexOf("d")); 3
		System.out.println("abcd".indexOf('D')); -1
		
```

We will use this function in such a way that it handles few extra conditions

The following code explains 4 things:
	if input string length is 0 or if it is null
	if subString to be found has length 0 or if it is null
	
	return 0
```
    if (!hasLength(str) || !hasLength(subString) || str.length() == 0
			|| subString.length() == 0) {
		return 0;
	}
```

Now, if the length of prefix is greater than the length of string then we return false.
```
	if (subString.length() > str.length()) {
		return false;
	}
```

If above 2 conditions fail means we are ready to use indexOf(str,subString) method.
Following is the code for counting the total occurences of sub string in string.
```
	int count = 0;  //Initialize count to 0
	int pos = 0;    //Let us assume position = 0
	int index;
	//Now take the index using the indexOf(str,subString) and see if it is -1
	//if -1 then we subString does not exists
	while ((index = str.indexOf(subString, pos)) != -1) {
		//if we made till this line then subString exists,
		//So increment the counter
		count++;
		//update the position as current index+subString.length()
		pos = index + subString.length();
	}
```

Following is the code for entire method::

    // Count occurrences of string
	/**
	 * Count occurencesof string.
	 *
	 * @param str
	 *            the str
	 * @param subString
	 *            the sub string
	 * @return the int
	 */
	public static int countOccurencesofString(String str, String subString) {

		if (!hasLength(str) || !hasLength(subString) || str.length() == 0
				|| subString.length() == 0) {
			return 0;
		}
		if(subString.length()>str.length()){
			return 0;
		}
		int count = 0;
		int pos = 0;
		int index;
		while ((index = str.indexOf(subString, pos)) != -1) {
			count++;
			pos = index + subString.length();
		}
		return count;
	}

Try to play with this method by printing the count and pos.