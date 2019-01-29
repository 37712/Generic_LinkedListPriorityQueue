# Generic_ArrayPriorityQueue
SDSU CS310 Spring 2018 Programming Assignment #2

For this assignment, you will write two more implementations of a Priority Queue. Using the same interface as program #1, you will write two linked listed implementations.     
Your implementations will be:   
    1. Ordered Singly Linked List	    
    2. Unordered Singly Linked List		    

Both implementations must have identical behavior, and must implement the PriorityQueue interface used in program #1. The implementations must have a single no-argument contructor. As linked lists are never full, there is no default size or maximum size.

Thus, your project will consist of the following files. You must use exactly these filenames.	    
    • PriorityQueue.java The ADT interface (provided in prog1)	    
    • OrderedLinkedListPriorityQueue.java The ordered list implementation.	    
    • UnorderedLinkedListPriorityQueue.java The unordered list implementation.	    
Additional Details:	    
    • Each method must be as efficient as possible. That is, a O(n) is unacceptable if the method could be written with O(log n) complexity.	    
    • You may not make any modifications to the PriorityQueue interface provided. I will grade your project with my copy of this file. This interface is UNCHANGED from project #1	    
    • All relevant requirements from the first assignment apply here. Of course, arrays will have a limited size but linked lists do not. Thus, all references to maximum size are not relevant for this assignment.	    
    • The isFull() method should be hardcoded to return false.	    
    • You should ignore (but do not remove) the DEFAULT_MAX_CAPACITY variable in the interface.	    
