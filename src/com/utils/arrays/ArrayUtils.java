package com.utils.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class ArrayUtils {

	/**
	 * The Primitives and the Wrapper classes are used to initialize the array of length 0.
	 * This arrays are used as return value if the parameter passed array is null or length is 0.
	 * This utilities are used as a means of not to duplicate the code for null or length of 0.
	 **/
	
	/** The Constant BYTE_ARRAY. */
	public static final byte[] BYTE_ARRAY = new byte[0];

	/** The Constant BYTE_WRAPPER_ARRAY. */
	public static final Byte[] BYTE_WRAPPER_ARRAY = new Byte[0];

	/** The Constant SHORT_ARRAY. */
	public static final short[] SHORT_ARRAY = new short[0];

	/** The Constant SHORT_WRAPPER_ARRAY. */
	public static final Short[] SHORT_WRAPPER_ARRAY = new Short[0];

	/** The Constant INT_ARRAY. */
	public static final int[] INT_ARRAY = new int[0];

	/** The Constant INTEGER_WRAPPER_ARRAY. */
	public static final Integer[] INTEGER_WRAPPER_ARRAY = new Integer[0];

	/** The Constant LONG_ARRAY. */
	public static final long[] LONG_ARRAY = new long[0];

	/** The Constant LONG_WRAPPER_ARRAY. */
	public static final Long[] LONG_WRAPPER_ARRAY = new Long[0];

	/** The Constant FLOAT_ARRAY. */
	public static final float[] FLOAT_ARRAY = new float[0];

	/** The Constant FLOAT_WRAPPER_ARRAY. */
	public static final Float[] FLOAT_WRAPPER_ARRAY = new Float[0];

	/** The Constant DOUBLE_ARRAY. */
	public static final double[] DOUBLE_ARRAY = new double[0];

	/** The Constant DOUBLE_WRAPPER_ARRAY. */
	public static final Double[] DOUBLE_WRAPPER_ARRAY = new Double[0];

	/** The Constant BOOLEAN_ARRAY. */
	public static final boolean[] BOOLEAN_ARRAY = new boolean[0];

	/** The Constant BOOLEAN_WRAPPER_ARRAY. */
	public static final Boolean[] BOOLEAN_WRAPPER_ARRAY = new Boolean[0];

	/** The Constant CHAR_ARRAY. */
	public static final char[] CHAR_ARRAY = new char[0];

	/** The Constant CHARACTER_WRAPPER_ARRAY. */
	public static final Character[] CHARACTER_WRAPPER_ARRAY = new Character[0];

	/** The Constant OBJECT_ARRAY. */
	public static final Object[] OBJECT_ARRAY = new Object[0];

	/**
	 * List<ANY> is null 
	 * ANY - Integer, Float, Long, Double
	 * 
	 * Used for conversion of Primitive array to List<ANY> 
	 * */
	/** The Constant INTEGER_LIST. */
	public static final List<Integer> INTEGER_LIST = new ArrayList<Integer>();

	/** The Constant FLOAT_LIST. */
	public static final List<Float> FLOAT_LIST = new ArrayList<Float>();

	/** The Constant LONG_LIST. */
	public static final List<Long> LONG_LIST = new ArrayList<Long>();

	/** The Constant DOUBLE_LIST. */
	public static final List<Double> DOUBLE_LIST = new ArrayList<Double>();

	/**
	 * Checks if Collection is empty.
	 *
	 * @param <E>
	 *            the element type
	 * @param collection
	 *            the collection
	 * @return true, if is empty
	 */
	public static <E> boolean isEmpty(Collection<? super E> collection) {

		if ((collection.size() == 0) || (collection == null))
			return true;
		return false;
	}

	/**
	 * Union of 2 sets 
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the setC
	 * 			  the set c as Collections.unmodifiableSet(setC);
	 */
	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {

		/**
		 * SetA empty & SetB has values
		 * SetA is null or 0 in length.
		 * SetB contains values.
		 * Return SetB as UnModifiableSet
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		/**
		 * SetA has values & SetB empty
		 * SetB is null or 0 in length.
		 * SetA contains values.
		 * Return SetA as UnModifiableSet
		 * */
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		/**
		 * If both the Sets are empty then return new Set
		 * need to return as Collections.unmodifiableSet(new LinkedHashSet<T>());
		 * */
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		/**
		 * Checks for Set equality
		 * */
		if (setA.equals(setB)) {
			return setA;
		}

		/**
		 * Initialize a new SetC
		 * Take iterator for SetA and SetB
		 * */
		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();
		Iterator<T> iterB = setB.iterator();

		/**
		 * Add all values of SetA and SetB in SetC
		 * */
		
		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		while (iterB.hasNext()) {
			setC.add(iterB.next());
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * Intersection of 2 sets
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the set c as Collections.unmodifiableSet(setC);
	 */
	public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
		/**
		 * SetA empty & SetB has values
		 * SetA is null or 0 in length.
		 * SetB contains values.
		 * Return UnModifiableSet as SetA intersection with SetB results in no values.
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		/**
		 * SetA has values & SetB empty
		 * SetB is null or 0 in length.
		 * SetA contains values.
		 * Return SetA as UnModifiableSet
		 * */
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		/**
		 * If both of the sets are empty then intersection has no values.
		 * */
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}
		
		/**
		 * SetA and SetB contains same values.
		 * Retuns SetA.
		 * Its does not matter which set to return as both of them are same.
		 * */
		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();

		/**
		 * Equality check for the common values in both the sets.
		 * Common values are inserted into SetC
		 * */
		while (iterA.hasNext()) {
			T obj = iterA.next();
			if (setB.contains(obj)) {
				setC.add(obj);
			}
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * Checks if SetA is subset of SetB
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * Subset is defined as either set has same values or all values in other set.
	 * @return true, if SetA is SubSet of SetB
	 */
	public static <T> boolean isSubSet(Set<T> setA, Set<T> setB) {

		/**
		 * Said as IS SetA SUBSET OF SetB
		 * SetA empty & SetB has values
		 * SetA is null or 0 in length
		 * SetB contains values
		 * Returns false as SetA is empty and SetB has values
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return true;
		}

		/**
		 * SetB is empty 
		 * Hence, SetB is Subset of SetA
		 * */
		if (!isEmpty(setA) && isEmpty(setB)) {
			return false;
		}

		/**
		 * If both the sets are empty then SetA is subset of SetB
		 * */
		if (isEmpty(setA) && isEmpty(setB)) {
			return true;
		}

		/**
		 * If both the sets are equal then return true
		 * */
		if (setA.equals(setB)) {
			return true;
		}

		/**
		 * If setA is subset of setB then setA size will be same or less than setB
		 * */ 
		if (setA.size() <= setB.size()) {

			Iterator<T> iterA = setA.iterator();
			while (iterA.hasNext()) {
				if (!setB.contains(iterA.next())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Cartesian product.
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the Lists in Set
	 * 
	 * Output
	 * SetA [1, 3]
	 * SetB [43, 47]
	 * Cartesian Product [[1, 43], [1, 47], [3, 43], [3, 47]]
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> cartesianProduct(Set<T> setA, Set<T> setB) {

		/**
		 * SetA empty & SetB has values
		 * Return SetB as UnModifiableSet
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		/**
		 * SetA has values & SetB is empty
		 * Return SetA as UnModifiableSet
		 * */
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		/**
		 * Cartesian Product for two empty set is not possible
		 * */
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		T[] A = (T[]) setA.toArray();
		T[] B = (T[]) setB.toArray();

		ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();
		ArrayList<T> subList = new ArrayList<T>();

		/**
		 * To built the cartesian product we need to add the values from both the sets and built the list for it
		 * */
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {

				subList.add(A[i]);
				subList.add(B[j]);
				list.add(subList);
				subList = new ArrayList<T>();
			}
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<ArrayList<T>> listIter = list.iterator();
		while (listIter.hasNext()) {
			setC.add((T) listIter.next());
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * A = {1, 2, 3, 4, 5} and B = {3, 4, 5, 6, 7, 8}. 
	 * To find the difference A - B of these two sets, we begin by writing all 
	 * of the elements of A, and then take away every element of A that is also an 
	 * element of B. Since A shares the elements 3, 4 and 5 with B, this gives us the 
	 * set difference A - B = {1, 2}.
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the set of difference A - B
	 */

	public static <T> Set<T> diffAbyB(Set<T> setA, Set<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();
		Iterator<T> iterB = setB.iterator();

		/**
		 * Add all elements of SetA in resulting setC*/
		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		/**
		 * Now compare for the SetB elements in SetC
		 * If exists then remove that element.
		 * */
		while (iterB.hasNext()) {
			T o = iterB.next();
			if (setC.contains(o)) {
				setC.remove(o);
			}
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * Union list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list1
	 *            the list1
	 * @param list2
	 *            the list2
	 * @return the list
	 */
	public static <T> List<T> unionList(List<T> list1, List<T> list2) {

		if (isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}
		// list1 empty & list2 has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return list2;
		}

		// list1 has values & list2 is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return list1;
		}

		List<T> list3 = new ArrayList<T>();
		Set<T> set = new LinkedHashSet<T>(list1);

		set.addAll(list2);
		list3.addAll(set);

		return list3;
	}

	/**
	 * Intersect list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list1
	 *            the list1
	 * @param list2
	 *            the list2
	 * @return the list
	 */
	public static <T> List<T> intersectList(List<T> list1, List<T> list2) {

		if (isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}
		// list1 empty & list2 has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return new ArrayList<T>();
		}

		// list1 has values & list2 is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}

		if (list1.equals(list2)) {
			return list1;
		}

		List<T> list3 = new ArrayList<T>();
		for (T object : list1) {
			if (list2.contains(object)) {
				if (!list3.contains(object)) {
					list3.add(object);
				}
			}
		}
		return list3;
	}

	/**
	 * Checks if is sub set list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list1
	 *            the list1
	 * @param list2
	 *            the list2
	 * @return true, if is sub set list
	 */
	public static <T> boolean isSubSetList(List<T> list1, List<T> list2) {

		// SetA empty & SetB has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return false;
		}

		// SetA has values & SetB is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return true;
		}

		// Both set are empty
		if (isEmpty(list1) && isEmpty(list2)) {
			return true;// double check
		}

		if (list1.equals(list2)) {
			return true;
		}

		// If setA is subset of setB then setA size will be same or less than
		// setB
		if (list1.size() <= list2.size()) {

			Iterator<T> iterA = list1.iterator();
			while (iterA.hasNext()) {
				if (!list2.contains(iterA.next())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Cartesian product list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> cartesianProductList(List<T> listA, List<T> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & List is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<T>();
		}

		T[] A = (T[]) listA.toArray();
		T[] B = (T[]) listB.toArray();

		ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();
		ArrayList<T> subList = new ArrayList<T>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				subList.add(A[i]);
				subList.add(B[j]);
				if (!list.contains(subList)) {
					list.add(subList);
				}
				subList = new ArrayList<T>();
			}
		}
		ArrayList<T> setC = new ArrayList<T>();
		Iterator<ArrayList<T>> listIter = list.iterator();
		while (listIter.hasNext()) {
			setC.add((T) listIter.next());
		}
		return setC;
	}

	/**
	 * *************************************************************************
	 * *****************.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */

	public static List<Integer> addIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		return list;
	}

	/**
	 * Adds the float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> addFloatLists(List<Float> listA, List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Adds the double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> addDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract integer lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Integer> subtractIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> subtractFloatLists(List<Float> listA,
			List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> subtractDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	public static void main(String[] args) {

		Set<Integer> list1 = new LinkedHashSet<Integer>();
		list1.add(1);
		list1.add(3);
		System.out.println("SetA "+list1);
		//list1.add(3);
		Set<Integer> list2 = new LinkedHashSet<Integer>();
		list2.add(43);
		list2.add(47);
		System.out.println("SetB "+list2);
		System.out.println("Cartesian Product "+cartesianProduct(list1, list2));
	}

}
