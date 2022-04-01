public class javaStack {
    private int[] stack;
    private int top;
    private int max;

    public javaStack(int max) {
        this.max = max;
        stack = new int[max];
        top = -1;
    }

    public void push(int item) {
        if (top == max - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = item;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        javaStack stack = new javaStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printStack();
        System.out.println("\nPopped: " + stack.pop());
        stack.printStack();
        System.out.println("\nPeek: " + stack.peek());
        stack.printStack();
    }


}
