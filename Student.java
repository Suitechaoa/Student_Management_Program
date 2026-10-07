import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

        private int id;
        private String name;
        private String major;
        private double gpa;

        @Override
        public int compareTo(Student other){
            return this.name.compareTo(other.name);
        }

        public Student(int id, String name, String major, double gpa) {
            this.id = id;
            this.name = name;
            this.major = major;
            this.gpa = gpa;
        }
        public Student(String name, String major, double gpa) {
            this.name = name;
            this.major = major;
            this.gpa = gpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getMajor() {
            return major;
        }

        public double getGpa() {
            return gpa;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        // override toString() method to display student information
        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", major='" + major + '\'' +
                    ", gpa=" + gpa +
                    '}';
        }



    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Landon", "Newton", 3.25));
        list.add(new Student("Valentina", "Carter", 3.5));
        list.add(new Student("Kristian", "Saunders", 3.9));
        list.add(new Student("Ryan", "Robles", 3.1));
		System.out.println("=== Original ordering ===");
        for (Student student : list)
			System.out.println(student);
		Collections.sort(list);
		System.out.println("=== Sorted list ===");
        for (Student student : list)
			System.out.println(student);
    }
}
