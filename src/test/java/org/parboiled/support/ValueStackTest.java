/*
 * Copyright (C) 2009-2010 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.support;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValueStackTest {

    @Test
    public void testValueStack() {
        ValueStack<Integer> stack = new ValueStack<Integer>();

        assertTrue(stack.isEmpty());

        stack.push(18);
        assertEquals(stack.size(), 1);
        assertFalse(stack.isEmpty());
        assertEquals(stack.peek(), (Integer)18);
        assertEquals(stack.pop(), (Integer)18);
        assertTrue(stack.isEmpty());

        stack.pushAll(18, 26, 42);
        assertEquals(stack.size(), 3);
        assertFalse(stack.isEmpty());
        assertEquals(stack.peek(), (Integer)42);
        assertEquals(stack.peek(2), (Integer)18);
        assertEquals(stack.pop(), (Integer)42);
        assertEquals(stack.size(), 2);

        stack.swap();
        assertEquals(stack.size(), 2);
        assertEquals(stack.peek(), (Integer)18);
        assertEquals(stack.peek(1), (Integer)26);
        assertEquals(stack.pop(1), (Integer)26);
        assertEquals(stack.size(), 1);
        assertEquals(stack.peek(), (Integer)18);
        assertEquals(stack.peek(0), (Integer)18);

        stack.pushAll(19, 20);
        stack.swap3();
        assertEquals(Lists.newLinkedList(stack), Arrays.asList(18,19,20));
    }

}
