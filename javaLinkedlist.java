import java.util.Scanner;

class Node {
   // implement your own data structure here
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public int getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node next){
        this.next = next;
    }
}

public class javaLinkedlist {
// implement your own data structure here
    private Node head;
    private Node tail;
    private int size;
    public javaLinkedlist(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }
    public int getFirst(){
        if(this.size == 0){
            return -1;
        }
        return this.head.getData();
    }
    public int getLast(){
        if(this.size == 0){
            return -1;
        }
        return this.tail.getData();
    }
    public int removeFirst(){
        if(this.size == 0){
            return -1;
        }
        int data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return data;
    }
    public int removeLast(){
        if(this.size == 0){
            return -1;
        }
        int data = this.tail.getData();
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node current = this.head;
            while(current.getNext() != this.tail){
                current = current.getNext();
            }
            current.setNext(null);
            this.tail = current;
        }
        this.size--;
        return data;
    }
    public void print(){
        Node current = this.head;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    public void reverse(){
        Node current = this.head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.head = prev;
    }
    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public static void main(String[] args){
        javaLinkedlist list = new javaLinkedlist();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        //read a interger which is the number of operations
        Scanner total = new Scanner(System.in);
        int n = total.nextInt();
        //read the operations
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            int op = input.nextInt();
            switch(op){
                case 0:
                    System.out.println(list.size());
                    break;
                case 1:
                    System.out.println(list.isEmpty());
                    break;
                case 2:
                    int data = input.nextInt();
                    list.addFirst(data);
                    break;
                case 3:
                    data = input.nextInt();
                    list.addLast(data);
                    break;
                case 4:
                    System.out.println(list.getFirst());
                    break;
                case 5:
                    System.out.println(list.getLast());
                    break;
                case 6:
                    System.out.println(list.removeFirst());
                    break;
                case 7:
                    System.out.println(list.removeLast());
                    break;
                case 8:
                    list.print();
                    break;
                case 9:
                    list.reverse();
                    break;
                case 10:
                    list.clear();
                    break;
            }
        }




    }
}

