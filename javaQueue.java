public class javaQueue {
  //this class implements the queue data structure
  private int[] queue;
  private int size;
  private int front;
  private int rear;
  private int count;

  public javaQueue(int size) {
    //constructor
    this.size = size;
    queue = new int[size];
    front = 0;
    rear = -1;
    count = 0;
  }

  public void enqueue(int data) {
    //adds an element to the queue
    if (count == size) {
      System.out.println("Queue is full");
    } else {
      if (rear == size - 1) {
        rear = -1;
      }
      queue[++rear] = data;
      count++;
    }
  }

  public int dequeue() {
    //removes an element from the queue
    int temp = queue[front++];
    if (front == size) {
      front = 0;
    }
    count--;
    return temp;
  }

  public int peek() {
    //returns the front element of the queue
    return queue[front];
  }

  public int size() {
    //returns the size of the queue
    return count;
  }

  public boolean isEmpty() {
    //returns true if the queue is empty
    return count == 0;
  }

  public boolean isFull() {
    //returns true if the queue is full
    return count == size;
  }
  public void printQueue() {
    //prints the queue
    for (int i = 0; i < size; i++) {
      System.out.print(queue[i] + " ");
    }
    System.out.println();
  }
  public void reverseQueue() {
    //reverses the queue
    int[] temp = new int[size];
    for (int i = 0; i < size; i++) {
      temp[i] = dequeue();
    }
    for (int i = 0; i < size; i++) {
      enqueue(temp[i]);
    }
  }
  public void sortQueue() {
    //sorts the queue
    int temp;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - 1; j++) {
        if (queue[j] > queue[j + 1]) {
          temp = queue[j];
          queue[j] = queue[j + 1];
          queue[j + 1] = temp;
        }
      }
    }
  }
}





