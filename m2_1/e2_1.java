package e2_1;

import java.util.Arrays;

class Student {
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String birth_date;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;
    private String type;

    public Student(int id, String first_name, String middle_name, String last_name, String birth_date,
            String address, String phone, String faculty, int course, String group) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student() {
        // default
    }

    @Override
    public String toString() {
        return "Student: id " + id + ", " + last_name + " " + first_name + " " + middle_name + ", " + birth_date
                + ", " + address + ", " + phone + ", " + faculty + ", course " + course + ", " + group;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static Student[] create_student_mas() {
        return new Student[] {
                new Student(1, "Антон", "Васильович", "Кузнецов", "12.04.2004", "Address1", "0671234567", "Faculty1", 1,
                        "GroupA"),
                new Student(2, "Максим", "Володимирович", "Нагорний", "23.02.2002", "Address2", "0961234567",
                        "Faculty2", 2, "GroupB"),
        };
    }

    public static void main(String[] args) {
        Student[] students = create_student_mas();

        // a) list of students of the given faculty
        String target_faculty = "Faculty1";
        System.out.println("Students from " + target_faculty + ":");
        filter_and_print(students, "faculty", target_faculty);

        // b) lists of students for each faculty and course
        System.out.println("\nStudents grouped by faculty and course:");
        group_and_print(students, "faculty", "course");

        // c) list of students who were born after a given year
        int target_year = 2003;
        System.out.println("\nStudents born after " + target_year + ":");
        filter_and_print(students, "birthYear", target_year);

        // d) list of the study group
        String target_group = "GroupB";
        System.out.println("\nStudents from " + target_group + ":");
        filter_and_print(students, "group", target_group);
    }

    private static void filter_and_print(Student[] students, String filter_by, Object filter_value) {
        Arrays.stream(students)
                .filter(student -> {
                    switch (filter_by) {
                        case "faculty":
                            return student.faculty.equals(filter_value);
                        case "birthYear":
                            int target_year = (int) filter_value;
                            int student_birth_year = Integer.parseInt(student.birth_date.split("\\.")[2]);
                            return student_birth_year > target_year;
                        case "group":
                            return student.group.equals(filter_value);
                        default:
                            return false;
                    }
                })
                .forEach(System.out::println);
    }

    private static void group_and_print(Student[] students, String group_by1, String groupy2) {
        Arrays.stream(students)
                .collect(java.util.stream.Collectors.groupingBy(student -> student.faculty + "-" + student.course))
                .forEach((key, value) -> {
                    System.out.println("Group: " + key);
                    value.forEach(System.out::println);
                    System.out.println();
                });
    }
}
