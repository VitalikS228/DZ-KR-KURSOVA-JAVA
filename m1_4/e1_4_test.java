public class e1_4_test {
    protected int protected_field = 123;

    public class manipulating_class {
        public void manipulate() {
            System.out.println("Manipulating class accesses protected field: " + protected_field);
        }
    }
}
