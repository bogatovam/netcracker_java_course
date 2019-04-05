package com.netcracker.mylinkedlist;

import java.util.*;
import java.util.function.UnaryOperator;

public interface ILinkedList<E> extends Iterable<E> {
    int size();

    E[] toArray();

    @Override
    String toString();

    // Modification Operations

    boolean add(E e);

    boolean remove(Object o);

    // Bulk Modification Operations

    void clear();

    // Comparison and hashing

    boolean equals(Object o);

    int hashCode();

    // Positional Access Operations

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    // Search Operations

    int indexOf(Object o);

    boolean contains(Object o);

    Iterator<E> iterator();

    IListIterator<E> listIterator();

}
