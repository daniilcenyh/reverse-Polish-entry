package StackX;

public class StackX {
    private int max_size;
    private char[] stack_array;
    private int top;

    public StackX(int length) {
        max_size = length;
        stack_array = new char[max_size];
        top = -1;
    }

    public void push(char item) {
        stack_array[++top] = item;
    }

    public char pop() {
        return stack_array[top--];
    }

    public char peek() {
        return stack_array[top];
    }

    public boolean is_empty() {
        return top == -1;
    }

    public int size() {
        return top+1;
    }

    public char peek_n_element(int n) {
        return stack_array[n];
    }

    public void display_stack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom --> top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peek_n_element(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
