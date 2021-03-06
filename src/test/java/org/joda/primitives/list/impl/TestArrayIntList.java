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
package org.joda.primitives.list.impl;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.iterator.IntIterator;

/**
 * Tests for ArrayIntList.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayIntList extends AbstractTestIntList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayIntList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayIntList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Integer> makeEmptyList() {
        return new ArrayIntList();
    }

    //-----------------------------------------------------------------------
    protected int dataLength(Object obj) throws Exception {
        Field field = obj.getClass().getDeclaredField("data");
        field.setAccessible(true);
        Object value = field.get(obj);
        return Array.getLength(value);
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ArrayIntList c = new ArrayIntList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayIntList c = new ArrayIntList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayIntList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayIntList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_intarray() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ArrayIntList c = new ArrayIntList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toIntArray(), a));
        
        c = new ArrayIntList((int[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayIntList c = new ArrayIntList((Collection<Integer>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Integer> coll = new ArrayList<Integer>();
        coll.add(new Integer(0));
        c = new ArrayIntList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0, c.iterator().nextInt());
        
        ArrayIntList c2 = new ArrayIntList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0, c2.iterator().nextInt());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ArrayIntList c = new ArrayIntList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeInt(6);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0));
        assertEquals(true, c.contains(2));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0));
        assertEquals(true, c.contains(2));
    }

    public void testEnsureCapacity() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ArrayIntList c = new ArrayIntList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ArrayIntList c = new ArrayIntList(a);
        
        assertEquals(true, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ArrayIntList c = new ArrayIntList(a);
        
        IntIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0, it.nextInt());
        assertEquals(6, it.nextInt());
        it.reset();
        assertEquals(0, it.nextInt());
        assertEquals(6, it.nextInt());
    }

}
