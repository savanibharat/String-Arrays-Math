How to Resolve Null String?
=========
<br>
We often face problem for checking the null string in our projects or programs.
 
What we do is simple thing.

```
        //Some Code
    	if(str==null){
      	   //Some Code
    	}
    	//Some Code
```
But is thing enough.
    
There can be several strings coming into the program and what we can do is duplicate the above code several times.
    
But is it the Solution? No, it isn't.
    
What can be the better Solution?
 
Create a method that would handle it gracefully.

```     
        // Always use this function to avoid NullPointerException on Strings
		/**
		 * Resolve null string.
		 *
		 * @param str
		 *            the str
		 * @return the string
		 */
		public static String resolveNullString(String str) {
			if (str == null) {
				return "";
			}
			return str;
		}```