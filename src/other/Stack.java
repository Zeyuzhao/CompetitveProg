package other;

/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/
/**
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, getting the number of
 *  items in the stack, and iterating over the items in LIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a nested class for
 *  linked-list nodes.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this stack
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {
    private int n;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    public Item pop(){
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        Item popped = first.item;
        first = first.next;
        n--;
        return popped;
    }
    public Item peek(){
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return first.item;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item : this){
            s.append(item);
            s.append(' ');
        }
        return s.substring(0, s.length() - 2);
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        String[] splitted = input.replaceAll("\\s", "").split(",");

        Stack<String> stringCheese = new Stack<>();
        for (String item : splitted){
            stringCheese.push(item);
        }
        System.out.println("Final Stack: [" + stringCheese + "]");

    }
}
