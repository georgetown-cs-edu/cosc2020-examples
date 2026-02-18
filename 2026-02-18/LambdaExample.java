import java.util.Arrays;
import java.util.List;

class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Micah", "Ada", "Grace", "Linus");

        // Before Java 8: anonymous class
        names.sort(new java.util.Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length(); // shortest to longest
            }
        });
        System.out.println("Anonymous class sort: " + names);

        // Java 8+: lambda expression (same idea, much less boilerplate)
        names.sort((a, b) -> a.length() - b.length());
        System.out.println("Lambda sort: " + names);

        // Lambdas also show up a lot with forEach
        names.forEach(s -> System.out.println("Hi, " + s));
    }
}
