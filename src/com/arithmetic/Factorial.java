package com.arithmetic;

public class Factorial {

	private static long factorial[] = {

		1l, 					//0!
		1l, 					//1!
		2l, 					//2!
		6l, 					//3!
		24l, 					//4!
		120l, 					//5!
		720l, 					//6!
		5040l, 					//7!
		40320l, 				//8!
		362880l, 				//9!
		3628800l,				//10!
		39916800l, 				//11!
		479001600l, 			//12!
		6227020800l, 			//13!
		87178291200l, 			//14!
		1307674368000l,			//15!
		20922789888000l, 		//16!
		355687428096000l, 		//17!
		6402373705728000l,		//18!
		121645100408832000l, 	//19!
		2432902008176640000l 	//20!
	};

	/**
	 * @return the factorial
	 */
	public static long getFactorial(int number) {
		if (number < factorial.length)
			return factorial[number];
		return -1;
	}
}
