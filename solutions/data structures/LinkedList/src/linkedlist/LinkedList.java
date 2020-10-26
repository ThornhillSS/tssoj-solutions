/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Ali
 */
public class LinkedList implements ADTListInterface{

    private class DNode{  
        int data;  
        DNode previous;  
        DNode next;  
  
        public DNode(int data) {  
            this.data = data;  
        }  
    }  
  
    DNode head, tail = null;  
    @Override
    public void addNode(int data) {  
        DNode newNode = new DNode(data);  
  
        if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.previous = tail;  
            tail = newNode;  
            tail.next = null;  
        }  
    }  
    @Override
    public void sortList() {  
        DNode current = null, index = null;  
        int temp;  
        if(head == null) {  
            return;  
        }  
        else {  
            for(current = head; current.next != null; current = current.next) {  
                for(index = current.next; index != null; index = index.next) {  
                    if(current.data > index.data) {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                }  
            }  
        }  
    }  
    @Override
    public void deletion() {  
        if(head == null) {  
            return;  
        }  
        else {  
            if(head != tail) {  
                head = head.next;  
                head.previous = null;  
            }  
            else {  
                head = tail = null;  
            }  
        }  
    }  
    @Override
    public void display() {  
        DNode current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Displaying linked list: ");  
        while(current != null) {  
            sortList();
            System.out.print(current.data + " ");
            System.out.println();
            current = current.next;  
        }  
    }  
  
    public static void main(String[] args) {  
  System.out.println("ali");
        for(int i=0;i<10;)
         i=i++;
        System.out.println("ali");
    }  
    
}
