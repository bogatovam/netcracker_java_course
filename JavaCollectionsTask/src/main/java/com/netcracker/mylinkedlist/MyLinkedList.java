package com.netcracker.mylinkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    public MyLinkedList() {
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public <T> T[] toArray() {
        return null;
    }

    // Modification Operations
    private void linkBefore(E e, Node<E> source) {
    }

    private E unlink(Node<E> node) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    public boolean addFirst(E e) {

        return false;
    }

    public boolean addLast(E e) {

        return false;
    }

    public E getFirst(E e) {

        return e;
    }

    public E getLast(E e) {

        return e;
    }

    public boolean removeFirst(E e) {

        return false;
    }

    public boolean removeLast(E e) {

        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }


    // Bulk Modification Operations
    @Override
    public void clear() {

    }

    // Comparison and hashing
    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    // Positional Access Operations
    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    // Search Operations
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    private class Node<U> {
        U item;
        Node<U> next;
        Node<U> prev;

        public Node(Node<U> prev, U element, Node<U> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class ListItr implements Iterator<E> {
        private Node<E> current;
        private Node<E> next;
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return false;
        }

        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }

        public void set(E e) {

        }

        public void add(E e) {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}

//    Iterator<E> iterator();
//    boolean containsAll(Collection<?> c);
//
//    boolean addAll(Collection<? extends E> c);
//
//    boolean addAll(int index, Collection<? extends E> c);
//
//    boolean removeAll(Collection<?> c);
//
//    boolean retainAll(Collection<?> c);
//    // List Iterators
//
//    ListIterator<E> listIterator();
//
//    ListIterator<E> listIterator(int index);
