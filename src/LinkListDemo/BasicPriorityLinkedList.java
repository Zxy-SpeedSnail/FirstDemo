package LinkListDemo;

import java.util.*;

/**
 * Created by yuan on 16-9-8.
 */

/**
 * 优先级链表
 */

public class BasicPriorityLinkedList {


    protected LinkedList[] linkedLists;
    protected int priorities;
    protected int size;


    public BasicPriorityLinkedList(int priorities) {
        this.priorities = priorities;
        initDeques();
    }
    public void addFirst(Object obj, int priority) {
        linkedLists[priority].addFirst(obj);
        size++;
    }
    public void addLast(Object obj, int priority) {
        linkedLists[priority].addLast(obj);
        size++;
    }
    public Object removeFirst() {
        Object obj = null;
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.removeFirst();
                break;
            }
        }
        if (obj != null) {
            size--;
        }
        return obj;
    }
    public Object removeLast() {
        Object obj = null;
        for (int i = 0; i < priorities; i++) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.removeLast();
            }
            if (obj != null) {
                break;
            }
        }
        if (obj != null) {
            size--;
        }
        return obj;
    }


    public Object peekFirst() {
        Object obj = null;
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList ll = linkedLists[i];
            if (!ll.isEmpty()) {
                obj = ll.getFirst();
            }
            if (obj != null) {
                break;
            }
        }
        return obj;
    }


    public List getAll() {
        List all = new ArrayList();
        for (int i = priorities - 1; i >= 0; i--) {
            LinkedList deque = linkedLists[i];
            all.addAll(deque);
        }
        return all;
    }


    public void clear() {
        initDeques();
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public ListIterator iterator() {
        return new PriorityLinkedListIterator(linkedLists);
    }


    protected void initDeques() {
        linkedLists = new LinkedList[priorities];
        for (int i = 0; i < priorities; i++) {
            linkedLists[i] = new LinkedList();
        }
        size = 0;
    }


    class PriorityLinkedListIterator implements ListIterator {
        private LinkedList[] lists;
        private int index;
        private ListIterator currentIter;
        PriorityLinkedListIterator(LinkedList[] lists) {
            this.lists = lists;
            index = lists.length - 1;
            currentIter = lists[index].listIterator();
        }


        public void add(Object arg0) {
            throw new UnsupportedOperationException();
        }


        public boolean hasNext() {
            if (currentIter.hasNext()) {
                return true;
            }
            while (index >= 0) {
                if (index == 0 || currentIter.hasNext()) {
                    break;
                }
                index--;
                currentIter = lists[index].listIterator();
            }
            return currentIter.hasNext();
        }


        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }


        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return currentIter.next();
        }


        public int nextIndex() {
            throw new UnsupportedOperationException();
        }


        public Object previous() {
            throw new UnsupportedOperationException();
        }


        public int previousIndex() {
            throw new UnsupportedOperationException();
        }


        public void remove() {
            currentIter.remove();
            size--;
        }


        public void set(Object obj) {
            throw new UnsupportedOperationException();
        }
    }


}
