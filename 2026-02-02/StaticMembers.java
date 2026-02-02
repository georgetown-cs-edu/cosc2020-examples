public class StaticMembers {
    
    public static int count1 = 0;
    public int count2 = 0;

    public void increment() {
        count1++;
        count2++;
    }

    public static void incrementByTwo() {
        count1 += 2;
    }

    public static void printCount1() {
        System.out.println("count1 = " + count1);
        // System.out.println("count2 = " + count2); // ERROR! Why?!
    }

    public static void main(String args[]) {
        StaticMembers.incrementByTwo();

        StaticMembers s1 = new StaticMembers();
        StaticMembers s2 = new StaticMembers();

        s1.increment();
        s2.increment();

        System.out.println("s1.count1 = " + s1.count1);
        System.out.println("s1.count2 = " + s1.count2);

        System.out.println("s2.count1 = " + s2.count1);
        System.out.println("s2.count2 = " + s2.count2);
    }
}
