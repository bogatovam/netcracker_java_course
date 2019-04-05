package com.netcracker.mylinkedlist;

import java.lang.reflect.ParameterizedType;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;
    int modifyCount = 0;

    public MyLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(0) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) java.lang.reflect.Array.newInstance(first.item.getClass(), size);
        int index = 0;
        for (Node<E> el = first; el != null; el = el.next) {
            array[index++] = el.item;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List: { ");
        for (Node<E> el = first; el != null; el = el.next) {
            result.append(el.item == null ? "" : el.item.toString());
        }
        result.append(" }");
        return result.toString();
    }

    // Modification Operations
    private void linkFirst(E e) {
        Node<E> tmpNext = first;
        Node<E> newNode = new Node<>(null, e, tmpNext);
        first = newNode;
        if (isEmpty()) {
            last = newNode;
        } else {
            tmpNext.prev = newNode;
        }
        modifyCount++;
        size++;
    }

    private void linkLast(E e) {
        Node<E> tmpPrev = last;
        Node<E> newNode = new Node<>(tmpPrev, e, null);
        last = newNode;
        if (isEmpty()) {
            first = newNode;
        } else {
            tmpPrev.next = newNode;
        }
        modifyCount++;
        size++;
    }

    private void linkBefore(E e, Node<E> before) {
        Node<E> tmpPrev = before.prev;
        Node<E> source = new Node<>(before.prev, e, before);
        before.prev = source;
        if (tmpPrev != null) {
            tmpPrev.next = source;
        } else first = source;
        modifyCount++;
        size++;
    }

    private void linkAfter(E e, Node<E> after) {
        Node<E> tmpNext = after.next;
        Node<E> source = new Node<>(after, e, tmpNext);
        after.next = source;
        if (tmpNext != null) {
            tmpNext.prev = source;
        } else last = source;
        modifyCount++;
        size++;
    }

    private E unlink(Node<E> node) {
        //assign node != null
        E item = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        node.item = null;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        modifyCount++;
        size--;
        return item;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    public E getFirst() {
        return first.item;
    }

    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.item;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return unlink(first);
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return unlink(last);
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> el = first; el != null; el = el.next) {
            if (o != null) {
                if (el.item.equals(o))
                    unlink(el);
            } else {
                if (el.item == null)
                    unlink(el);
            }
        }
        return false;
    }

    // Bulk Modification Operations
    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modifyCount++;
    }

    // Comparison and hashing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLinkedList<E> that = (MyLinkedList<E>) o;

        if (size != that.size) return false;

        for (Node<E> el1 = first, el2 = that.first;
             el1 != null && el2 != null;
             el1 = el1.next, el2 = el2.next) {

            if (el1.item != null && el2.item != null) {
                if (!el1.item.equals(el2.item)) return false;
            } else if ((el1.item == null && el2.item != null) || (el1.item != null && el2.item == null)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = size;
        for (Node<E> el = first; el != null; el = el.next) {
            result = 31 * result + (el.item == null ? 0 : el.item.hashCode());
        }
        return result;
    }


    // Positional Access Operations
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public E get(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
        Node<E> result = first;
        for (int i = 0; i < index; ++i) {
            result = result.next;
        }
        return result.item;
    }

    @Override
    public E set(int index, E element) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
        Node<E> changed = first;
        for (int i = 0; i < index; ++i) {
            changed = changed.next;
        }
        E oldValue = changed.item;
        changed.item = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
        Node<E> before = first;
        for (int i = 0; i < index; ++i) {
            before = before.next;
        }
        linkBefore(element, before);
    }

    @Override
    public E remove(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
        Node<E> removed = first;
        for (int i = 0; i < index; ++i) {
            removed = removed.next;
        }
        E oldValue = removed.item;
        unlink(removed);
        return oldValue;
    }

    // Search Operations
    @Override
    public int indexOf(Object o) {
        Node<E> current = first;
        for (int i = 0; i < size; ++i) {
            if (current.item != null) {
                if (current.item.equals(o))
                    return i;
            } else if (o == null)
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListItr();
    }

    public IListIterator<E> listIterator() {
        return new ListItr();
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

    private class ListItr implements IListIterator<E> {
        private Node<E> used;
        private Node<E> next;
        private int nextIndex;
        private int expectedModifyCount = modifyCount;

        public ListItr() {
            used = null;
            next = first;
            nextIndex = 0;
        }

        public ListItr(int index) {
            used = null;
            if (index < size) {
                Node<E> start = first;
                for (int i = 0; i < index; ++i) {
                    start = start.next;
                }
                next = start;
                nextIndex = index;
            } else {
                next = null;
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E next() {
            checkModifyCount();

            if (!hasNext())
                throw new NoSuchElementException();
            used = next;
            next = next.next;
            nextIndex++;
            return used.item;
        }

        public E previous() {
            checkModifyCount();

            if (!hasPrevious())
                throw new NoSuchElementException();

            used = next = (next == null ? last : next.prev);
            nextIndex--;
            return used.item;
        }

        @Override
        public void remove() {
            checkModifyCount();
            if (used == null)
                throw new IllegalStateException();
            Node<E> tmp = used.next;
            unlink(used);
            if (next == used)
                next = tmp;
            else --nextIndex;
            used = null;
            expectedModifyCount++;
        }

        public void set(E e) {
            checkModifyCount();

            if (used == null)
                throw new IllegalStateException();
            used.item = e;
        }

        public void add(E e) {
            checkModifyCount();

            used = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModifyCount++;
        }

        final void checkModifyCount() {
            if (modifyCount != expectedModifyCount)
                throw new ConcurrentModificationException();
        }

    }
}