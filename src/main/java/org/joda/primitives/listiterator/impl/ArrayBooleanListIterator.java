/*
 *  Copyright 2001-2010 Stephen Colebourne
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
package org.joda.primitives.listiterator.impl;

import java.util.NoSuchElementException;

import org.joda.primitives.BooleanUtils;
import org.joda.primitives.listiterator.BooleanListIterator;

/**
 * An iterator over an array of <code>boolean</code> values.
 * <p>
 * This class implements {@link java.util.ListIterator ListIterator} allowing
 * seamless integration with other APIs.
 * <p>
 * The iterator can be reset to the start if required.
 * <code>add()</code> and <code>remove()</code> are unsupported, but
 * <code>set()</code> is supported.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayBooleanListIterator implements BooleanListIterator {
    // This file is CODE GENERATED. Do not change manually.

    /** The array to iterate over */
    protected final boolean[] array;
    /** Cursor position */
    protected int cursor = 0;
    /** Last returned position */
    protected int last = -1;

    /**
     * Creates an iterator over a copy of an array of <code>boolean</code> values.
     * <p>
     * The specified array is copied, ensuring the original data is unaltered.
     * Note that the class is not immutable due to the {@code set} methods.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public static ArrayBooleanListIterator copyOf(boolean[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        return new ArrayBooleanListIterator(array.clone());
    }

    /**
     * Constructs an iterator over an array of <code>boolean</code> values.
     * <p>
     * The array is assigned internally, thus the caller holds a reference to
     * the internal state of the returned iterator. It is not recommended to
     * modify the state of the array after construction.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public ArrayBooleanListIterator(boolean[] array) {
        super();
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        this.array = array;
    }

    //-----------------------------------------------------------------------
    public boolean isModifiable() {
        return true;
    }

    public boolean isResettable() {
        return true;
    }

    //-----------------------------------------------------------------------
    public boolean hasNext() {
        return (cursor < array.length);
    }

    public int nextIndex() {
        return cursor;
    }

    public boolean nextBoolean() {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        last = cursor;
        return array[cursor++];
    }

    public Boolean next() {
        return BooleanUtils.toObject(nextBoolean());
    }

    public boolean hasPrevious() {
        return (cursor > 0);
    }

    public int previousIndex() {
        return cursor - 1;
    }

    public boolean previousBoolean() {
        if (hasPrevious() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        last = --cursor;
        return array[cursor];
    }

    public Boolean previous() {
        return BooleanUtils.toObject(previousBoolean());
    }

    public void add(boolean value) {
        throw new UnsupportedOperationException("ArrayBooleanListIterator does not support add");
    }

    public void add(Boolean value) {
        throw new UnsupportedOperationException("ArrayBooleanListIterator does not support add");
    }

    public void remove() {
        throw new UnsupportedOperationException("ArrayBooleanListIterator does not support remove");
    }

    public void set(boolean value) {
        if (last < 0) {
            throw new IllegalStateException("ArrayBooleanListIterator cannot be set until next is called");
        }
        array[last] = value;
    }

    public void set(Boolean value) {
        set(BooleanUtils.toPrimitive(value));
    }

    public void reset() {
        cursor = 0;
        last = -1;
    }

}
