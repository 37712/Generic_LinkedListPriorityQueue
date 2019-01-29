
/*  CS310 Spring 2018
    Programming Assignment #2
    Carlos A. Gamino Reyes
*/

/*  The PriorityQueue ADT may store objects in any order.  However,
    removal of objects from the PQ must follow specific criteria.
    The object of highest priority that has been in the PQ longest
    must be the object returned by the remove() method.  FIFO return
    order must be preserved for objects of identical priority.
   
    Ranking of objects by priority is determined by the Comparable<E>
    interface.  All objects inserted into the PQ must implement this
    interface.
*/

package data_structures;

import java.util.Iterator;

public class OrderedLinkedListPriorityQueue
        <E extends Comparable <E>> implements PriorityQueue <E>{
    
    private Node<E> head;
    private int size;
    
    public OrderedLinkedListPriorityQueue(){
        head = null;
        size = 0;
    }
    
    private class Node<E> {
        private E data;
        private Node next;
        
        public Node(E obj) {
            data = obj;
            next = null;
        }
    }
    
    //  Inserts a new object into the priority queue.  Returns true if
    //  the insertion is successful.  If the PQ is full, the insertion
    //  is aborted, and the method returns false.
    public boolean insert(E obj){
        Node<E> tmp = new Node<E>(obj);
        Node<E> prev = null, ptr = head;        
        while(ptr != null && obj.compareTo(ptr.data) >= 0){//move along the link
            prev = ptr;
            ptr = ptr.next; 
        }
        if(prev == null) { //insert at head
            tmp.next = head;
            head = tmp;
        }
        else {//insert in the middle or end
            prev.next = tmp;
            tmp.next = ptr;
        }
        size++;
        return true;
    }  
    
    //  Removes the object of highest priority that has been in the
    //  PQ the longest, and returns it.  Returns null if the PQ is empty.
    public E remove(){
        if(isEmpty()) return null;
        E tmp = head.data;
        head = head.next;
        size--;
        return tmp;
    }
    
    //  Deletes all instances of the parameter obj from the PQ if found, and
    //  returns true.  Returns false if no match to the parameter obj is found.
    public boolean delete(E obj){
        Node<E> prev = null, ptr = head;
        boolean flag = false;
        while(ptr != null && ptr.data.compareTo(obj) <= 0){
            if(obj.compareTo(ptr.data) == 0){//found??
                if(ptr == head)//ptr is at the head    
                        head = head.next;
                else{//ptr is not at the head
                    prev.next = ptr.next;
                    ptr = prev;
                }
                size--;
                flag = true;
            }
            prev = ptr;
            ptr = ptr.next;
        }
        return flag;
    }
    
    //  Returns the object of highest priority that has been in the
    //  PQ the longest, but does NOT remove it. 
    //  Returns null if the PQ is empty.
    public E peek(){ if(isEmpty()) return null; return head.data; }
    
    //  Returns true if the priority queue contains the specified element
    //  false otherwise.
    public boolean contains(E obj){
        Node<E> ptr = head;
        while(ptr != null){
            if(obj.compareTo(ptr.data) == 0)return true;
            ptr = ptr.next;
        }
        return false;
    }
    
    //  Returns the number of objects currently in the PQ.
    public int size(){ return size; }
      
    //  Returns the PQ to an empty state.
    public void clear(){ head = null; size = 0; }
   
    //  Returns true if the PQ is empty, otherwise false
    public boolean isEmpty(){ return size == 0; }
   
    //  Returns true if the PQ is full, otherwise false.  List based
    //  implementations should always return false.
    public boolean isFull(){ return false; }  
    
    //  Returns an iterator of the objects in the PQ, in no particular
    //  order.  
    public Iterator<E> iterator(){ return new IteratorHelper(); }
    
    private class IteratorHelper implements Iterator<E>{
        
        private Node<E> ptr = head;
        
        public E next(){
            E tmp = ptr.data;
            ptr = ptr.next;
            return tmp;
        }
        
        public boolean hasNext(){ return ptr != null; }
        
        public void remove(){ throw new UnsupportedOperationException(); }
        
    }
} 