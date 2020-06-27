public class App {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedListImpl<>();
        list.add("Hello");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
