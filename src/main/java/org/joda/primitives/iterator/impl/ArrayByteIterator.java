/*
 *  Copyright 2001-2010 Stephen Colebourne, Jason Tiscione
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
package org.joda.primitives.iterator.impl;

import java.util.NoSuchElementException;

import org.joda.primitives.ByteUtils;
import org.joda.primitives.iterator.ByteIterator;

/**
 * An iterator over an array of <code>byte</code> values.
 * <p>
 * This class implements {@link java.util.Iterator Iterator} allowing
 * seamless integration with other APIs.
 * <p>
 * The iterator can be reset to the start if required.
 * It is unmodifiable and <code>remove()</code> is unsupported.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayByteIterator implements ByteIterator {
    // This file is CODE GENERATED. Do not change manually.

    /** The array to iterate over */
    protected final byte[] array;
    /** Cursor position */
    protected int cursor = 0;

    /**
     * Constructs an iterator over an <code>byte</code> array.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public ArrayByteIterator(byte[] array) {
        super();
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        this.array = array;
    }

    //-----------------------------------------------------------------------
    public boolean isModifiable() {
        return false;
    }

    public boolean isResetable() {
        return true;
    }

    //-----------------------------------------------------------------------
    public boolean hasNext() {
        return (cursor < array.length);
    }

    public byte nextByte() {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        return array[cursor++];
    }

    public Byte next() {
        return ByteUtils.toObject(nextByte());
    }

    public void remove() {
        throw new UnsupportedOperationException("ArrayByteIterator does not support remove");
    }

    public void reset() {
        cursor = 0;
    }

}
