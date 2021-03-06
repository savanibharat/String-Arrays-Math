package com.util.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtils {

	/**
	 * The Primitives and the Wrapper classes are used to initialize the array
	 * of length 0. This arrays are used as return value if the parameter passed
	 * array is null or length is 0. This utilities are used as a means of not
	 * to duplicate the code for null or length of 0.
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
	 * List<ANY> is null ANY - Integer, Float, Long, Double
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

	public static final int INDEX_NOT_FOUND = -1;

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
	 * returns the length of the array
	 * 
	 * @param obj
	 * @return 0 if null
	 * @return obj.length
	 */
	public static int getArrayLenth(Object obj) {
		if (obj == null) {
			return 0;
		}
		return Array.getLength(obj);
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
	 * @return the setC the set c as Collections.unmodifiableSet(setC);
	 */
	public static <T> Set<T> union(final Set<T> setA, final Set<T> setB) {

		/**
		 * SetA empty & SetB has values SetA is null or 0 in length. SetB
		 * contains values. Return SetB as UnModifiableSet
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		/**
		 * SetA has values & SetB empty SetB is null or 0 in length. SetA
		 * contains values. Return SetA as UnModifiableSet
		 * */
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		/**
		 * If both the Sets are empty then return new Set need to return as
		 * Collections.unmodifiableSet(new LinkedHashSet<T>());
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
		 * Initialize a new SetC Take iterator for SetA and SetB
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
	public static <T> Set<T> intersection(final Set<T> setA, final Set<T> setB) {
		/**
		 * SetA empty & SetB has values SetA is null or 0 in length. SetB
		 * contains values. Return UnModifiableSet as SetA intersection with
		 * SetB results in no values.
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		/**
		 * SetA has values & SetB empty SetB is null or 0 in length. SetA
		 * contains values. Return SetA as UnModifiableSet
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
		 * SetA and SetB contains same values. Retuns SetA. Its does not matter
		 * which set to return as both of them are same.
		 * */
		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();

		/**
		 * Equality check for the common values in both the sets. Common values
		 * are inserted into SetC
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
	 *            the set b Subset is defined as either set has same values or
	 *            all values in other set.
	 * @return true, if SetA is SubSet of SetB
	 */
	public static <T> boolean isSubSet(final Set<T> setA, final Set<T> setB) {

		/**
		 * Said as IS SetA SUBSET OF SetB SetA empty & SetB has values SetA is
		 * null or 0 in length SetB contains values Returns false as SetA is
		 * empty and SetB has values
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return true;
		}

		/**
		 * SetB is empty Hence, SetB is Subset of SetA
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
		 * If setA is subset of setB then setA size will be same or less than
		 * setB
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
	 *         Output SetA [1, 3] SetB [43, 47] Cartesian Product [[1, 43], [1,
	 *         47], [3, 43], [3, 47]]
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> cartesianProduct(final Set<T> setA,
			final Set<T> setB) {

		/**
		 * SetA empty & SetB has values Return SetB as UnModifiableSet
		 * */
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		/**
		 * SetA has values & SetB is empty Return SetA as UnModifiableSet
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
		 * To built the cartesian product we need to add the values from both
		 * the sets and built the list for it
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
	 * A = {1, 2, 3, 4, 5} and B = {3, 4, 5, 6, 7, 8}. To find the difference A
	 * - B of these two sets, we begin by writing all of the elements of A, and
	 * then take away every element of A that is also an element of B. Since A
	 * shares the elements 3, 4 and 5 with B, this gives us the set difference A
	 * - B = {1, 2}.
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the set of difference A - B
	 */

	public static <T> Set<T> diffAbyB(final Set<T> setA, final Set<T> setB) {

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
		 * Add all elements of SetA in resulting setC
		 */
		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		/**
		 * Now compare for the SetB elements in SetC If exists then remove that
		 * element.
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
	public static <T> List<T> unionList(final List<T> list1, final List<T> list2) {

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
	public static <T> List<T> intersectList(final List<T> list1,
			final List<T> list2) {

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
	public static <T> boolean isSubSetList(final List<T> list1,
			final List<T> list2) {

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
	public static <T> List<T> cartesianProductList(final List<T> listA,
			final List<T> listB) {

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
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */

	public static List<Integer> addIntegerLists(final List<Integer> listA,
			final List<Integer> listB) {

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
	public static List<Float> addFloatLists(final List<Float> listA,
			final List<Float> listB) {

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
	public static List<Double> addDoubleLists(final List<Double> listA,
			final List<Double> listB) {

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
	public static List<Integer> subtractIntegerLists(final List<Integer> listA,
			final List<Integer> listB) {

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
	public static List<Float> subtractFloatLists(final List<Float> listA,
			final List<Float> listB) {

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
	public static List<Double> subtractDoubleLists(final List<Double> listA,
			final List<Double> listB) {

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

	/**
	 * This method is used to convert the Integer(wrapper class objects) to
	 * primitive type. We use method intValue() which returns int.
	 *
	 * @param arr
	 *            the arr
	 * @return the int[]
	 */
	public static int[] toPrimitive(final Integer[] arr) {

		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return INT_ARRAY;
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i].intValue();
		}
		return result;
	}

	/**
	 * This method is used to convert the int(primitive) to Wrapper type. We
	 * dont use any method for this as compiler uses {@code Integer.valueOf(i);}
	 * Converting a primitive value (an int, for example) into an object of the
	 * corresponding wrapper class (Integer) is called autoboxing. The Java
	 * compiler applies autoboxing when a primitive value is: Passed as a
	 * parameter to a method that expects an object of the corresponding wrapper
	 * class. Assigned to a variable of the corresponding wrapper class.
	 * 
	 * @param arr
	 *            the arr
	 * @return the integer[]
	 */
	public static Integer[] toObject(final int[] arr) {

		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return INTEGER_WRAPPER_ARRAY;
		}
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	/**
	 * This method is used to convert the Float(wrapper class objects) to
	 * primitive type. We use method floatValue() which returns float.
	 *
	 * @param arr
	 *            the arr
	 * @return the float[]
	 */
	public static float[] toPrimitive(final Float[] arr) {
		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return FLOAT_ARRAY;
		}
		float[] result = new float[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i].floatValue();
		}
		return result;
	}

	/**
	 * This method is used to convert the float(primitive) to its Wrapper type
	 * Float. We don't use any method for this as compiler uses
	 * {@code Float.valueOf(i);} Converting a primitive value (an float, for
	 * example) into an object of the corresponding wrapper class (Float) is
	 * called autoboxing. The Java compiler applies autoboxing when a primitive
	 * value is: Passed as a parameter to a method that expects an object of the
	 * corresponding wrapper class. Assigned to a variable of the corresponding
	 * wrapper class.
	 *
	 * @param arr
	 *            the arr
	 * @return the float[]
	 */
	public static Float[] toObject(final float[] arr) {
		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return FLOAT_WRAPPER_ARRAY;
		}
		Float[] result = new Float[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	/**
	 * This method is used to convert the Double(wrapper class objects) to
	 * primitive type. We use method doubleValue() which returns double.
	 *
	 * @param arr
	 *            the arr
	 * @return the double[]
	 */
	public static double[] toPrimitive(final Double[] arr) {

		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return DOUBLE_ARRAY;
		}
		double[] result = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i].doubleValue();
		}
		return result;
	}

	/**
	 * This method is used to convert the double(primitive) to its Wrapper type
	 * Double. We don't use any method for this as compiler uses
	 * {@code Double.valueOf(i);} Converting a primitive value (an double, for
	 * example) into an object of the corresponding wrapper class (Double) is
	 * called autoboxing. The Java compiler applies autoboxing when a primitive
	 * value is: Passed as a parameter to a method that expects an object of the
	 * corresponding wrapper class. Assigned to a variable of the corresponding
	 * wrapper class.
	 *
	 * @param arr
	 *            the arr
	 * @return the double[]
	 */
	public static Double[] toObject(final double[] arr) {

		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return DOUBLE_WRAPPER_ARRAY;
		}
		Double[] result = new Double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	/**
	 * To list.
	 *
	 * @param arr
	 *            the arr
	 * @return the list
	 */
	public static List<Integer> toList(final int[] arr) {

		if (arr == null) {
			return null;
		}

		if (arr.length == 0) {
			return INTEGER_LIST;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	/**
	 * To list.
	 *
	 * @param arr
	 *            the arr
	 * @return the list
	 */
	public static List<Float> toList(final float[] arr) {

		if (arr == null) {
			return null;
		}

		if (arr.length == 0) {
			return FLOAT_LIST;
		}
		List<Float> result = new ArrayList<Float>();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	/**
	 * To list.
	 *
	 * @param arr
	 *            the arr
	 * @return the list
	 */
	public static List<Double> toList(final double[] arr) {

		if (arr == null) {
			return null;
		}

		if (arr.length == 0) {
			return DOUBLE_LIST;
		}
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	/**
	 * To list.
	 *
	 * @param arr
	 *            the arr
	 * @return the list
	 */
	public static List<Long> toList(final long[] arr) {

		if (arr == null) {
			return null;
		}

		if (arr.length == 0) {
			return LONG_LIST;
		}
		List<Long> result = new ArrayList<Long>();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	/**
	 * This method returns the sub array of int[] start and end values are
	 * handled gracefully
	 * */
	public static int[] subArray(final int[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return INT_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return INT_ARRAY;
		}
		int[] result = new int[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of float[] start and end values are
	 * handled gracefully
	 * */
	public static float[] subArray(final float[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return FLOAT_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return FLOAT_ARRAY;
		}
		float[] result = new float[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of byte[] start and end values are
	 * handled gracefully
	 * */
	public static byte[] subArray(final byte[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return BYTE_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return BYTE_ARRAY;
		}
		byte[] result = new byte[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of short[] start and end values are
	 * handled gracefully
	 * */
	public static short[] subArray(final short[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return SHORT_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return SHORT_ARRAY;
		}
		short[] result = new short[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of long[] start and end values are
	 * handled gracefully
	 * */
	public static long[] subArray(final long[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return LONG_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return LONG_ARRAY;
		}
		long[] result = new long[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of double[] start and end values are
	 * handled gracefully
	 * */
	public static double[] subArray(final double[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return DOUBLE_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return DOUBLE_ARRAY;
		}
		double[] result = new double[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of boolean[] start and end values are
	 * handled gracefully
	 * */
	public static boolean[] subArray(final boolean[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return BOOLEAN_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return BOOLEAN_ARRAY;
		}
		boolean[] result = new boolean[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of char[] start and end values are
	 * handled gracefully
	 * */
	public static char[] subArray(final char[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return CHAR_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return CHAR_ARRAY;
		}
		char[] result = new char[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	/**
	 * This method returns the sub array of Object[] start and end values are
	 * handled gracefully
	 * */
	public static Object[] subArray(final Object[] a, int start, int end) {

		if (a == null) {
			return null;
		}
		if (a.length == 0) {
			return OBJECT_ARRAY;
		}
		if (start < 0) {
			start = 0;
		}
		if (end >= a.length) {
			end = a.length - 1;
		}
		int resultSize = end - start;
		if (resultSize <= 0) {
			return OBJECT_ARRAY;
		}
		Object[] result = new Object[resultSize];
		System.arraycopy(a, start, result, 0, resultSize);
		return result;
	}

	public static boolean contains(final int[] a, int key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final int[] a, int key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final int[] a, int key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final int[] a, int key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final float[] a, float key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final float[] a, float key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final float[] a, float key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final float[] a, float key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final char[] a, char key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final char[] a, char key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final char[] a, char key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final char[] a, char key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final double[] a, double key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final double[] a, double key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final double[] a, double key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final double[] a, double key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final byte[] a, byte key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final byte[] a, byte key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(byte[] a, byte key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final byte[] a, byte key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final short[] a, short key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final short[] a, short key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final short[] a, short key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final short[] a, short key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final long[] a, long key, int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final long[] a, long key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final long[] a, long key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final long[] a, long key) {
		return indexOf(a, key, 0);
	}

	public static boolean contains(final boolean[] a, boolean key,
			int startIndex) {
		return !(indexOf(a, key, startIndex) == INDEX_NOT_FOUND);
	}

	public static boolean contains(final boolean[] a, boolean key) {
		return !(indexOf(a, key, 0) == INDEX_NOT_FOUND);
	}

	public static int indexOf(final boolean[] a, boolean key, int startIndex) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (startIndex > a.length - 1) {
			startIndex = (a.length - 1);
		}
		int n = a.length;
		for (int i = startIndex; i < n; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int indexOf(final boolean[] a, boolean key) {
		return indexOf(a, key, 0);
	}

	public static int lastIndexOf(final int[] a, int key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final float[] a, float key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final byte[] a, byte key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final short[] a, short key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final long[] a, long key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final double[] a, double key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final boolean[] a, boolean key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	public static int lastIndexOf(final char[] a, char key) {

		if (a == null || a.length == 0) {
			return INDEX_NOT_FOUND;
		}
		int n = a.length - 1;
		for (int i = n; i >= 0; i--) {
			if (a[i] == key) {
				return i;
			}
		}
		return INDEX_NOT_FOUND;
	}

	// int, float, char, double, byte, short, long, boolean

	public static boolean isSorted(final int[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final float[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final char[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final double[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final byte[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final short[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final long[] a) {

		if (a == null) {
			return false;
		} else if (a.length == 0) {
			return true;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * StartValue and EndValue inclusive
	 * 
	 * @param startValue
	 * @param endValue
	 * @return int[]
	 */
	public static int[] fill(int startValue, int endValue) {

		int n = Math.abs(startValue - endValue) + 1;
		int[] result = new int[n];
		// 5 > 1
		if (startValue > endValue) {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue--;
			}
		}
		// 5 < 10
		else {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue++;
			}
		}
		return result;
	}

	/**
	 * StartValue and EndValue inclusive
	 * 
	 * @param startValue
	 * @param endValue
	 * @return float[]
	 */
	public static float[] fill(float startValue, float endValue) {

		int n = (int) Math.abs(startValue - endValue) + 1;
		float[] result = new float[n];
		// 5 > 1
		if (startValue > endValue) {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue--;
			}
		}
		// 5 < 10
		else {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue++;
			}
		}
		return result;
	}

	/**
	 * StartValue and EndValue inclusive
	 * 
	 * @param startValue
	 * @param endValue
	 * @return long[]
	 */
	public static long[] fill(long startValue, long endValue) {

		int n = (int) Math.abs(startValue - endValue) + 1;
		long[] result = new long[n];
		// 5 > 1
		if (startValue > endValue) {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue--;
			}
		}
		// 5 < 10
		else {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue++;
			}
		}
		return result;
	}

	/**
	 * StartValue and EndValue inclusive
	 * 
	 * @param startValue
	 * @param endValue
	 * @return double[]
	 */
	public static double[] fill(double startValue, double endValue) {

		int n = (int) Math.abs(startValue - endValue) + 1;
		double[] result = new double[n];
		// 5 > 1
		if (startValue > endValue) {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue--;
			}
		}
		// 5 < 10
		else {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue++;
			}
		}
		return result;
	}

	/**
	 * StartValue and EndValue inclusive
	 * 
	 * @param startValue
	 * @param endValue
	 * @return double[]
	 */
	public static char[] fill(char startValue, char endValue) {

		int n = (int) Math.abs(startValue - endValue) + 1;
		char[] result = new char[n];
		if (startValue > endValue) {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue--;
			}
		} else {
			for (int i = 0; i < n; i++) {
				result[i] = startValue;
				startValue++;
			}
		}
		return result;
	}

	/**
	 * Reverse entire or part of array
	 * @param a
	 * @param start - start inclusive
	 * @param end - end exclusive
	 * @return
	 */
	public static int[] reverse(int[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			int temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire int[] array
	 * @param a
	 * @return
	 */
	public static int[] reverse(int[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static float[] reverse(float[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			float temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire float[] array
	 * @param a
	 * @return
	 */
	public static float[] reverse(float[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static long[] reverse(long[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			long temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire double[] array
	 * @param a
	 * @return
	 */
	public static long[] reverse(long[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static double[] reverse(double[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			double temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire double[] array
	 * @param a
	 * @return
	 */
	public static double[] reverse(double[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static byte[] reverse(byte[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			byte temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire byte[] array
	 * @param a
	 * @return
	 */
	public static byte[] reverse(byte[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static short[] reverse(short[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			short temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire short[] array
	 * @param a
	 * @return
	 */
	public static short[] reverse(short[] a){
		return reverse(a,0,a.length);
	}
	
	/**
	 * @param a
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	public static char[] reverse(char[] a, int start, int end){
		
		if(getArrayLenth(a)==0){
			return a;
		}
		
		start = start < 0 ? 0 : start;
		end = end > (a.length - 1) ? a.length - 1 : end - 1;
		
		while(start<end){
			char temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		return a;
	}
	
	/**
	 * reverse entire char[] array
	 * @param a
	 * @return
	 */
	public static char[] reverse(char[] a){
		return reverse(a,0,a.length);
	}
	
	public static void main(final String[] args) {
		//remove and removeSeveral and removeAll
		//isSameLength
		//clone
		//addValue(index), addValue(at end)
		//addAll
		int[] a={1,2,3,4,5};
		int[] res=reverse(a,0,2);  
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
