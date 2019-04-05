package com.netcracker.mylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface IListIterator<E>  extends Iterator<E> {
    @Override
    boolean hasNext();

    boolean hasPrevious();

    @Override
    E next();

    E previous();

    @Override
    void remove();

    void set(E e);

    void add(E e);
}