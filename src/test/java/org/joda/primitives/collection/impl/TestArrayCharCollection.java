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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Test ArrayCharCollection.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayCharCollection extends AbstractTestCharCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayCharCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayCharCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Character> makeCollection() {
        return new ArrayCharCollection();
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
        ArrayCharCollection c = new ArrayCharCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayCharCollection c = new ArrayCharCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayCharCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayCharCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_chararray() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharCollection c = new ArrayCharCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toCharArray(), a));
        
        c = new ArrayCharCollection((char[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayCharCollection c = new ArrayCharCollection((Collection<Character>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Character> coll = new ArrayList<Character>();
        coll.add(new Character((char) 0));
        c = new ArrayCharCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((char) 0, c.iterator().nextChar());
        
        ArrayCharCollection c2 = new ArrayCharCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((char) 0, c2.iterator().nextChar());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayCharCollection c = new ArrayCharCollection((Iterator<Character>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Character> coll = new ArrayList<Character>();
        coll.add(new Character((char) 0));
        c = new ArrayCharCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals((char) 0, c.iterator().nextChar());
        
        ArrayCharCollection c2 = new ArrayCharCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals((char) 0, c2.iterator().nextChar());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharCollection c = new ArrayCharCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst('A');
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((char) 0));
        assertEquals(true, c.contains('Z'));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((char) 0));
        assertEquals(true, c.contains('Z'));
    }

    public void testEnsureCapacity() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharCollection c = new ArrayCharCollection(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(5);
        assertEquals(7, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

}
