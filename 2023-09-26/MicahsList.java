public class MicahsList {
    
    private Node head;
    
    private int x;

    class Node extends Object {
        public Object data;
        public Node next;
        private int x;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add( Object o ) {
        Node n = new Node(o);
        n.next = head;
        head = n;
    }


    @Override
    public String toString() {
        return "hi";
    }

}
