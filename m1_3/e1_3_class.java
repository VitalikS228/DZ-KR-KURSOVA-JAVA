public class e1_3_class {
    public String public_field = "This is a public field of e1_3class";
    private String private_field = "This is a private field of e1_3class";
    protected String protected_field = "This is a protected field of e1_3class";
    String default_access_field = "This is a default access field of e1_3class";

    public e1_3_class() {
        System.out.println("This is a constructor of e1_3class");
    }

    public void public_method() {
        System.out.println("This is a public method of e1_3class");
    }

    private void private_method() {
        System.out.println("This is a private method of e1_3class");
    }

    protected void protected_method() {
        System.out.println("This is a protected method of e1_3class");
    }

    void default_access_method() {
        System.out.println("This is a default access method of e1_3class");
    }
}
