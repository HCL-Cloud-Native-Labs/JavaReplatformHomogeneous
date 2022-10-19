package com.presto.banking.util;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.poi.ss.formula.functions.T;
public class UserList extends ArrayList {
    private final String additionalItem;

    UserList(String additionalItems) {
        this.additionalItem = additionalItems;
    }

    @Override
    public int size() {
        return super.size() + 1;
    }

    public  Iterator<T> iterator() {
        return new InternalIterator();
    }

    class InternalIterator implements Iterator{
        Integer cursor;

        Integer lastRet=-1;

        Integer expectedModCount=modCount;

        public  boolean hasNext() {
            return cursor != size();
        }

        public  T next() {
            checkForComodification();
            int i = cursor;
            if (i >= size())
            throw new NoSuchElementException();
            cursor = i + 1;
            lastRet = i;
            return (T) get(i);
        }

        public  void remove() {
            if (lastRet < 0)
            throw new IllegalStateException();
            checkForComodification();

            try {
            UserList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
            };
        }

        final  void checkForComodification() {
            if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        }
    }
}