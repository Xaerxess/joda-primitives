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
package org.joda.primitives.list;

import org.joda.primitives.collection.ShortCollection;
import org.joda.primitives.iterator.ShortIterator;
import org.joda.primitives.listiterator.ShortListIterator;

/**
 * Defines a list of primitive <code>short</code> values.
 * <p>
 * This interface extends {@link java.util.List List} allowing seamless integration
 * with other APIs.
 * All List methods can be used, using the primitive wrapper class {@link Short}.
 * However, it will be <em>much</em> more efficient to use the methods defined here.
 * 
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public interface ShortList extends PrimitiveList<Short>, ShortCollection {
    // This file is CODE GENERATED. Do not change manually.

    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Gets an iterator over this list capable of accessing the primitive values.
     *
     * @return an iterator over this list, not null
     */
    ShortIterator iterator();
    // This method is specified here, despite being in {@code ShortCollection},
    // due to compiler bug 6487370.

    /**
     * Gets the primitive value at the specified index.
     *
     * @param index  the index to get from
     * @return value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    short getShort(int index);

    /**
     * Gets the first primitive value.
     *
     * @return value at index zero
     * @throws IndexOutOfBoundsException if the size is zero
     */
    short firstShort();

    /**
     * Gets the last primitive value.
     *
     * @return value at index <code>size() - 1</code>
     * @throws IndexOutOfBoundsException if the size is zero
     */
    short lastShort();

    /**
     * Gets a list iterator over this list capable of accessing the primitive values.
     *
     * @return an iterator over this list, not null
     */
    ShortListIterator listIterator();

    /**
     * Gets a list iterator over this list from a start index capable of accessing the primitive values.
     *
     * @param index  the index to start from
     * @return an iterator over this list, not null
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    ShortListIterator listIterator(int index);

    /**
     * Gets the first index of the specified primitive value.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    int indexOf(short value);

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that a
     * negative index is treated as zero, and an index greater than the list
     * size will simply return <code>-1</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    int indexOf(short value, int fromIndexInclusive);

    /**
     * Gets the last index of the specified primitive value.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    int lastIndexOf(short value);

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that an
     * index greater than the list size will start searching at the list size,
     * and a negative index simply returns <code>-1</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    int lastIndexOf(short value, int fromIndexInclusive);

    /**
     * Gets a range of elements as an array.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new array containing a copy of the range of elements, not null
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    short[] toShortArray(int fromIndexInclusive, int toIndexExclusive);

    /**
     * Gets a range view of part of this list.
     * <p>
     * This method allows operations to work on a range within the greater list.
     * Changes made to the either object will affect the other.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new ShortList for the subList, not null
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    ShortList subList(int fromIndexInclusive, int toIndexExclusive);

    // Optional operations
    //-----------------------------------------------------------------------
    /**
     * Adds a primitive value to this list at an index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to add at
     * @param value  the value to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    boolean add(int index, short value);

    /**
     * Adds an array of primitive values to this list at an index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to add at
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    boolean addAll(int index, short[] values);

    /**
     * Removes a primitive value by index from the list (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This method is deprecated to serve as a warning to developers.
     * Using it can be confusing as it removes by index rather than by primitive.
     * The method will still function correctly as the method is defined in the List interface.
     * Use {@link #removeShortAt} instead.
     *
     * @deprecated use short removeShortAt(int)
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws UnsupportedOperationException if not supported by this collection
     */
    @Deprecated
    Short remove(int index);

    /**
     * Removes a primitive value by index from the list (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws UnsupportedOperationException if not supported by this collection
     */
    short removeShortAt(int index);

    /**
     * Sets the primitive value at a specified index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be changed.
     *
     * @param index  the index to set
     * @param value  the value to store
     * @return the previous value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    short set(int index, short value);

}
