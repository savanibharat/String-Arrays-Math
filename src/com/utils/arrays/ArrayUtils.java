package com.utils.arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayUtils {

	/**
	 * Checks if is empty.
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
	 * Union.
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the sets the
	 */
	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {

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
			return new LinkedHashSet<T>();
		}

		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();
		Iterator<T> iterB = setB.iterator();

		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		while (iterB.hasNext()) {
			setC.add(iterB.next());
		}
		return Collections.unmodifiableSet(setC);
	}
	
	/**
	 * Intersection.
	 *
	 * @param <T>
	 *            the generic type
	 * @param setA
	 *            the set a
	 * @param setB
	 *            the set b
	 * @return the sets the
	 */
	public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();

		while (iterA.hasNext()) {
			T obj = iterA.next();
			if (setB.contains(obj)) {
				setC.add(obj);
			}
		}
		return Collections.unmodifiableSet(setC);
	}
}
