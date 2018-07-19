package edu.luc.cs271.linkedstack;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class LinkedStack<E> implements IStack<E> {

    /**
     * The topmost node of this stack. The stack gets pushed down from here.
     */
    private Node<E> top;

    private int size = 0;

    // TODO why don't we need an explicit constructor?

    @Override
    public E push(final E obj) {
        top = new Node<>(obj, top);
        // TODO
        size++;
        return obj;
    }

    @Override
    public E peek() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return top.data;
        }
    }

    @Override
    public E pop() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E result = top.data;
            top = top.next;
            size--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        if (top == null) return true;
        else return false;
    }

    @Override
    public List<E> asList() {
        final ArrayList<E> result = new ArrayList<>(size);
        populateList(top, result); // TODO replace null with the right reference
        return result;
    }
    // TODO implement using an ArrayList.  Populate the ArrayList with the stack values, without deconstructing the stack!
    // TODO add any instance variable(s) required to support this

    private void populateList(final Node<E> curr, final List<E> result) {
        // TODO recursively populate the list in the desired order
        if (curr != null) {
            result.add(curr.data);
            populateList(curr.next, result);
        }
    private void populateFifoList(final Node<E> curr, final List<E> result){
            // TODO recursively populate the list in the desired order
            if (curr != null) {
                result.add(0, curr.data);
                populateFifoList(curr.next, result);
            }
        }
        @Override
        public List<E> asFifoList () {
            final ArrayList<E> result = new ArrayList<>(size);
            populateFifoList(top, result); // TODO replace null with the right reference
            return result;
        }
    }
}

