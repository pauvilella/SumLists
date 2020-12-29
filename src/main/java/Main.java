public class Main {
    public static MyDoublyLinkedList<Integer> sum(MyDoublyLinkedList<Integer> num1, MyDoublyLinkedList<Integer> num2) {
        MyDoublyLinkedList<Integer> result = new MyDoublyLinkedList<Integer>();
        MyDoublyLinkedList<Integer> result2 = new MyDoublyLinkedList<Integer>();
        int carry = 0;
        MyDoublyLinkedListNode<Integer> i1 = num1.head;
        MyDoublyLinkedListNode<Integer> i2 = num2.head;
        i1 = num1.tail;
        i2 = num2.tail;

        while(i1 != null || i2 != null) {
            int x, y;
            if(i1 != num1.head) {
                x = i1.data;
            } else {
                x = 0;
            }

            if(i2 != num2.head) {
                y = i2.data;
            } else {
                y = 0;
            }
            int z = x + y + carry;
            if (z >= 10) {
                z = z - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if(z != 0)
                result.addEnd(z);
            if(i1 != null)
                i1 = i1.previous;
            if(i2 != null)
                i2 = i2.previous;
        }

        MyDoublyLinkedListNode<Integer> r = result.tail;
        while (r != result.head) {
            result2.addEnd(r.data);
            r = r.previous;
        }

        return result2;
    }
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> num1 = new MyDoublyLinkedList<Integer>();
        num1.addEnd(6);
        num1.addEnd(1);
        num1.addEnd(7);
        num1.printMe();

        MyDoublyLinkedList<Integer> num2 = new MyDoublyLinkedList<Integer>();
        num2.addEnd(2);
        num2.addEnd(9);
        num2.addEnd(5);
        num2.printMe();

        MyDoublyLinkedList<Integer> result = sum(num1, num2);
        result.printMe();
    }
}
