/*
 *  Copyright 2001-2013 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.primitives.collection.impl;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

import org.joda.primitives.IntUtils;
import org.joda.primitives.collection.IntCollection;
import org.joda.primitives.iterator.IntIterator;

/**
 * Abstract base class for collections of primitive <code>int</code> elements.
 * <p>
 * This class implements {@link java.util.Collection Collection} allowing
 * seamless integration with other APIs.
 * <p>
 * The <code>iterator</code> and <code>size</code> must be implemented by subclases.
 * To make the subclass modifiable, the <code>add(int)</code> and
 * iterator <code>remove()</code> methods must also be implemented.
 * Subclasses may override other methods to increase efficiency.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractIntCollection
        extends AbstractPrimitiveCollectable<Integer>
        implements IntCollection {
    // This file is CODE GENERATED. Do not change manually.

    /**
     * Constructor.
     */
    protected AbstractIntCollection() {
        super();
    }
    
    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation uses <code>intIterator()</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(int value) {
        for (IntIterator it = iterator(); it.hasNext(); ) {
            if (it.nextInt() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this collection contains all of the values in the specified array.
     * If the specified array is empty, <code>true</code> is returned.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param values  the values to search for, null treated as empty array
     * @return <code>true</code> if all of the values are found
     */
    public boolean containsAll(int[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (contains(values[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if this collection contains all of the values in the specified collection.
     * If the specified collection is empty, <code>true</code> is returned.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param values  the values to search for, null treated as empty collection
     * @return <code>true</code> if all of the values are found
     */
    public boolean containsAll(IntCollection values) {
        if (values != null) {
            for (IntIterator it = values.iterator(); it.hasNext(); ) {
                if (contains(it.nextInt()) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if this collection contain all the values in the specified range.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the result is <code>true</code>
     * as the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if the collection contains the entire range
     */
    public boolean containsAll(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            return true;
        }
        for (int i = startInclusive; i <= endInclusive; i++) {
            if (contains(i) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if this collection contains any of the values in the specified array.
     * If the specified array is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param values  the values to search for, null treated as empty array
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(int[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (contains(values[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this collection contains any of the values in the specified collection.
     * If the specified collection is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param values  the values to search for, null treated as empty collection
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(IntCollection values) {
        if (values != null) {
            for (IntIterator it = values.iterator(); it.hasNext(); ) {
                if (contains(it.nextInt())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this collection contain some of the values in the specified range.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the result is <code>false</code>
     * as the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if the collection contains at least one of the range
     */
    public boolean containsAny(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            return false;
        }
        for (int i = startInclusive; i <= endInclusive; i++) {
            if (contains(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the elements of this collection as an array.
     * <p>
     * This implementation uses <code>arrayCopy</code>.
     *
     * @return a new array containing a copy of the elements of this collection
     */
    public int[] toIntArray() {
        if (size() == 0) {
            return IntUtils.EMPTY_INT_ARRAY;
        }
        int[] result = new int[size()];
        arrayCopy(0, result, 0, size());
        return result;
    }

    /**
     * Copies the elements of this collection into an array at a specified position.
     * Previous values in the array are overwritten.
     * <p>
     * If the array specified is null a new array is created.
     * If the array specified is large enough, it will be modified.
     * If the array is not large enough, a new array will be created containing the
     * values from the specified array before the startIndex plus those from this collection.
     * <p>
     * This implementation uses <code>arrayCopy</code>.
     *
     * @param array  the array to add the elements to, null treated as empty array
     * @param startIndex  the position in the array to start setting elements
     * @return the array with the populated collection
     * @throws IndexOutOfBoundsException if the index is negative
     */
    public int[] toIntArray(int[] array, int startIndex) {
        if (startIndex < 0) {
            throw new IndexOutOfBoundsException("Start index must not be negative: " + startIndex);
        }
        int[] result = null;
        if (array == null) {
            // create new
            result = new int[startIndex + size()];
            
        } else if (array.length - startIndex - size() >= 0) {
            // room to fit data
            result = array;
            
        } else {
            // expand array
            result = new int[startIndex + size()];
            System.arraycopy(array, 0, result, 0, startIndex);
        }
        arrayCopy(0, result, startIndex, size());
        return result;
    }

    // Optional operations
    //-----------------------------------------------------------------------
    /**
     * Clears the collection/map of all elements (optional operation).
     * <p>
     * The collection/map will have a zero size after this method completes.
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection/map cannot be cleared.
     * <p>
     * This implementation uses <code>iterator()</code>.
     *
     * @throws UnsupportedOperationException if method not supported by this collection
     */
    public void clear() {
        checkRemoveModifiable();
        for (IntIterator it = iterator(); it.hasNext(); ) {
            it.nextInt();
            it.remove();
        }
    }

    /**
     * Adds a primitive value to this collection (optional operation).
     * <p>
     * This implementation throws UnsupportedOperationException.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(int value) {
        throw new UnsupportedOperationException("Collection does not support add");
    }

    /**
     * Adds an array of primitive values to this collection (optional operation).
     * <p>
     * This implementation uses <code>add(int)</code>.
     *
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(int[] values) {
        checkAddModifiable();
        boolean changed = false;
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                changed |= add(values[i]);
            }
        }
        return changed;
    }

    /**
     * Adds a collection of primitive values to this collection (optional operation).
     * <p>
     * This implementation uses <code>add(int)</code>.
     *
     * @param values  the values to add to this collection, null treated as empty collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(IntCollection values) {
        checkAddModifiable();
        boolean changed = false;
        if (values != null) {
            for (IntIterator it = values.iterator(); it.hasNext(); ) {
                changed |= add(it.nextInt());
            }
        }
        return changed;
    }

    /**
     * Adds a range of primitive values to this collection (optional operation).
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>add(int)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this set
     * @throws UnsupportedOperationException if not supported by this set
     */
    public boolean addAll(int startInclusive, int endInclusive) {
        checkAddModifiable();
        if (startInclusive > endInclusive) {
            return false;
        }
        boolean changed = false;
        for (int i = startInclusive; i <= endInclusive; i++) {
            changed |= add(i);
        }
        return changed;
    }

    /**
     * Removes the first occurrence of the specified primitive value from this collection
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeFirst(int value) {
        checkRemoveModifiable();
        for (IntIterator it = iterator(); it.hasNext(); ) {
            if (it.nextInt() == value) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all occurrences of the specified primitive value from this collection.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(int value) {
        checkRemoveModifiable();
        boolean changed = false;
        for (IntIterator it = iterator(); it.hasNext(); ) {
            if (it.nextInt() == value) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Removes all occurrences from this collection of each primitive in the specified array.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(int[] values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values != null) {
            for (IntIterator it = iterator(); it.hasNext(); ) {
                int value = it.nextInt();
                for (int i = 0; i < values.length; i++) {
                    if (values[i] == value) {
                        it.remove();
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    /**
     * Removes all occurrences from this collection of each primitive in the specified collection.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(IntCollection values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values != null) {
            for (IntIterator it = iterator(); it.hasNext(); ) {
                if (values.contains(it.nextInt())) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Removes all occurrences of a range of primitive values from this collection.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * The elements removed are greater than or equal to the start and
     * less than or equal to the end. Thus if the start is greater than the
     * end then no elements are removed.
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * set cannot be changed.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(int startInclusive, int endInclusive) {
        checkRemoveModifiable();
        if (startInclusive > endInclusive) {
            return false;
        }
        boolean changed = false;
        for (IntIterator it = iterator(); it.hasNext(); ) {
            int value = it.nextInt();
            if (value >= startInclusive && value <= endInclusive) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains each element of this collection that is present in the specified array
     * removing all other values.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(int[] values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values == null || values.length == 0) {
            changed = !isEmpty();
            clear();
        } else {
            for (IntIterator it = iterator(); it.hasNext(); ) {
                int next = it.nextInt();
                boolean match = false;
                for (int i = 0; i < values.length; i++) {
                    if (values[i] == next) {
                        match = true;
                        break;
                    }
                }
                if (match == false) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Retains each element of this collection that is present in the specified collection
     * removing all other values.
     * <p>
     * This implementation uses <code>iterator().remove()</code>.
     *
     * @param values  the values to retain in this collection, null treated as empty collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(IntCollection values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values == null || values.isEmpty()) {
            changed = !isEmpty();
            clear();
        } else {
            for (IntIterator it = iterator(); it.hasNext(); ) {
                if (values.contains(it.nextInt()) == false) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Retains all occurences of a range of primitive values within this collection
     * removing all values outside the range (optional operation).
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the range is equivalent to an empty collection.
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * set cannot be changed.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(int startInclusive, int endInclusive) {
        checkRemoveModifiable();
        boolean changed = false;
        for (IntIterator it = iterator(); it.hasNext(); ) {
            int value = it.nextInt();
            if (value < startInclusive || value > endInclusive) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    // Collection integration
    //-----------------------------------------------------------------------
    /**
     * Checks whether this collection contains a specified <code>Integer</code> value.
     * <p>
     * This implementation uses <code>contains(int)</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(Object value) {
        return contains(toPrimitive(value));
    }

    /**
     * Checks if the collection contains all of the primitive values.
     * <p>
     * This implementation uses <code>containsAll(int[])</code>.
     *
     * @param coll  the collection of values to search for
     * @return <code>true</code> if all the values are found
     */
    public boolean containsAll(Collection<?> coll) {
        if (coll == this || coll.size() == 0) {
            return true;
        }
        if (size() == 0) {
            return false;
        }
        return containsAll(toPrimitiveArray(coll));
    }

    /**
     * Checks if the collection contains any of the primitive values in the array.
     * If the specified collection is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>containsAny(int[])</code>.
     *
     * @param coll  the collection of values to search for
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(Collection<?> coll) {
        if (size() == 0 || coll.size() == 0) {
            return false;
        }
        if (coll == this) {
            return true;
        }
        return containsAny(toPrimitiveArray(coll));
    }

    /**
     * Gets the collection as an array of <code>Integer</code>.
     * 
     * @return an array of <code>Integer</code>
     */
    public Object[] toArray() {
        Object[] result = new Integer[size()];
        IntIterator it = iterator();
        for (int i = 0; it.hasNext(); i++) {
            result[i] = it.next();
        }
        return result;
    }

    /**
     * Gets the collection as an array, using the array provided.
     * 
     * @param <T>  the array type
     * @param array  the array to populate
     * @return an array of <code>Integer</code>
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {
        int size = size();
        if (array.length < size) {
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
        }

        Iterator<Integer> it = iterator();
        for (int i = 0; i < size; i++) {
            array[i] = (T) it.next();
        }

        if (array.length > size) {
            array[size] = null;
        }
        
        return array;
    }

    /**
     * Adds the <code>Integer</code> value to this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>add(int)</code>.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(Integer value) {
        checkAddModifiable();
        return add(toPrimitive(value));
    }

    /**
     * Adds a collection of <code>Integer</code> values to this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>addAll(int[])</code>.
     *
     * @param coll  the values to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws ClassCastException if any object is not <code>Integer</code>
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(Collection<? extends Integer> coll) {
        checkAddModifiable();
        return addAll(toPrimitiveArray(coll));
    }

    /**
     * Removes the first occurrance of the specified <code>Integer</code> value from
     * this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be removed from.
     * <p>
     * This implementation uses <code>removeFirst(int)</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean remove(Object value) {
        checkRemoveModifiable();
        return removeFirst(toPrimitive(value));
    }

    /**
     * Removes each of a collection of <code>Integer</code> values from this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>removeAll(int[])</code>.
     *
     * @param coll  the values to remove from this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(Collection<?> coll) {
        checkRemoveModifiable();
        if (coll == this) {
            int size = size();
            clear();
            return (size() != size);
        }
        return removeAll(toPrimitiveArray(coll));
    }

    /**
     * Retains each of a collection of <code>Integer</code> values, removing other
     * values (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>retainAll(int[])</code>.
     *
     * @param coll  the values to retain in this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(Collection<?> coll) {
        checkRemoveModifiable();
        if (coll == this) {
            return false;
        }
        return retainAll(toPrimitiveArray(coll));
    }

    // Basics
    //-----------------------------------------------------------------------
    /**
     * Gets a string representing this collection.
     * <p>
     * The format used is as per <code>Collection</code>.
     * 
     * @return collection as a String
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("[");

        IntIterator it = iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            buf.append(it.nextInt());
            hasNext = it.hasNext();
            if (hasNext) {
                buf.append(", ");
            }
        }

        buf.append("]");
        return buf.toString();
    }
    
    // Internals
    //-----------------------------------------------------------------------
    /**
     * Copies data from this collection into the specified array.
     * This method is pre-validated.
     * 
     * @param fromIndex  the index to start from
     * @param dest  the destination array
     * @param destIndex  the destination start index
     * @param size  the number of items to copy
     */
    protected void arrayCopy(int fromIndex, int[] dest, int destIndex, int size) {
        IntIterator it = iterator();
        for (int i = 0; it.hasNext() && i < size; i++) {
            dest[destIndex + i] = it.nextInt();
        }
    }

    /**
     * Are the add methods supported.
     * <p>
     * This implementation returns false.
     *
     * @return true if supported
     */
    protected boolean isAddModifiable() {
        return false;
    }

    /**
     * Are the remove methods supported.
     * <p>
     * This implementation returns false.
     *
     * @return true if supported
     */
    protected boolean isRemoveModifiable() {
        return false;
    }

    /**
     * Is the collection modifiable in any way.
     *
     * @return true if supported
     */
    public boolean isModifiable() {
        return isAddModifiable() || isRemoveModifiable();
    }

    /**
     * Check whether add is suported and throw an exception.
     */
    protected void checkAddModifiable() {
        if (isAddModifiable() == false) {
            throw new UnsupportedOperationException("Collection does not support add");
        }
    }

    /**
     * Check whether remove is suported and throw an exception.
     */
    protected void checkRemoveModifiable() {
        if (isRemoveModifiable() == false) {
            throw new UnsupportedOperationException("Collection does not support remove");
        }
    }

    /**
     * Wraps an <code>int</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    protected Integer toObject(int value) {
        return IntUtils.toObject(value);
    }

    /**
     * Checks if the object can be converted to a primitive successfully.
     * <p>
     * This implementation only allows non-null Int objects.
     * 
     * @param value  the Object wrapper
     * @return true if a primitive value can be successfully extracted
     */
    protected boolean isToPrimitivePossible(Object value) {
        return (value instanceof Integer);
    }

    /**
     * Unwraps the <code>Integer</code> to retrieve the primitive <code>int</code>.
     * <p>
     * This implementation only allows non-null Int objects.
     * 
     * @param value  the Object to convert to a primitive
     * @return the primitive value
     * @throws NullPointerException if the value is null and this is unacceptable
     * @throws ClassCastException if the object is of an unsuitable type
     */
    protected int toPrimitive(Object value) {
        return IntUtils.toPrimitive(value);
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>int</code>.
     * <p>
     * This implementation only allows non-null Int objects.
     * 
     * @param coll  the Collection to convert to primitives
     * @return the primitive value
     * @throws NullPointerException if the value is null and this is unacceptable
     * @throws ClassCastException if any object is of an unsuitable type
     */
    protected int[] toPrimitiveArray(Collection<?> coll) {
        return IntUtils.toPrimitiveArray(coll);
    }

}
