class MyLinkedList {

    private Node head;

    class Node {
        Object val;
        Node next;
        Node(Object val) {
            this.val = val;
            this.next = null;
        }
    }


    public MyLinkedList() {
        head = null;
    }

    public void add(Object val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

}