import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

public class Student implements Comparable<Student> {

        private int id;
        private String name;
        private String major;
        private double gpa;

        ////////////////
        /// Override methods
        ////////////////

        @Override
        public int compareTo(Student other){
            return this.name.compareTo(other.name);
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

        // Override equals() method to compare students based on their id
        @Override 
        public boolean equals(Object other){
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Student student = (Student) other;
            return id == student.id;

        }

        // Override hashCode() method to ensure that equal objects have the same hash code based on their id.
        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        ////////////////
        /// Comparators
        /////////////////
        
        Comparator<Student> compareByGpa = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        };

        Comparator<Student> compareByID = new Comparator<Student>(){
            
            @Override 
            public int compare(Student s1, Student s2){
                return Integer.compare(s1.getId(), s2.getId());
            }
        };

        ////////////////
        /// Constructors
        ////////////////
        
        // Constructor with all fields
        public Student(int id, String name, String major, double gpa) {
            this.id = id;
            this.name = name;
            this.major = major;
            this.gpa = gpa;
        }

        // Constructor without id
        public Student(String name, String major, double gpa) {
            this.name = name;
            this.major = major;
            this.gpa = gpa;
        }

        /////////////
        /// Getters and Setters
        /////////////

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

        ///////////////
        /// Traversal methods
        //////////////////

        public static void displayStudentBody(List<Student> list) {
            for (Student student : list) {
                System.out.println(student);
            }
            System.out.println("\n");
        }

        public static void displayStudentBodyIterator(List<Student> list) {
            Iterator<Student> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println("\n");
        }

        public static void displayStudentBodyLambda(List<Student> list) {
            list.forEach(student -> System.out.println(student));
            System.out.println("\n");
        }





    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "John", "Computer Science", 3.2));
        list.add(new Student(2, "Jane", "Mathematics", 3.8));
        list.add(new Student(3, "Kristian", "Physics", 3.9));
        list.add(new Student(4, "Ryan", "Biology", 3.1));
        list.add(new Student(5, "George", "Chemistry", 3.7));
        list.add(new Student(6, "Alice", "Psychology", 3.5));
        list.add(new Student(7,"Stooge", "Philosophy", 3.0));
        //System.out.println("Student ID: " + list.get(4).getId());



		System.out.println("=== Original ordering ===");
        Student.displayStudentBody(list);

        ////////////////////
        /// Section D
        //////////////////////

        System.out.println("Section D - Remove and Contains");
        System.out.println("What is the size of the list before removal? :" + list.size());
        list.remove(5);
        System.out.println("Does the list contain the student with ID 7? :" + list.contains(new Student(7,"Stooge", "Philosophy", 3.0)));
        System.out.println("What is the size of the list after removal? :" + list.size());
        System.out.println("Just to be sure, is the list empty? :" + list.isEmpty());
		Collections.sort(list);

        ///////////////////
        /// Section E
        ///////////////////////
        System.out.println("\n");

        System.out.println("Section E - Traversal Methods");
		Student.displayStudentBody(list);
        Student.displayStudentBodyIterator(list);
        Student.displayStudentBodyLambda(list);

        ////////////////////////
        /// Section F
        /////////////////////////
        
        // Sort the list by GPA using the compareByGpa comparator
        System.out.println("Section F - Sorting");
        System.out.println("Sorting by GPA\n");
        System.out.println("Before sorting by GPA");
        Student.displayStudentBody(list);
        list.sort(list.get(0).compareByGpa);
        System.out.println("After sorting by GPA");
        Student.displayStudentBody(list);

        // Sort the list by ID using the compareByID comparator
        System.out.println("Sorting by ID\n");
        System.out.println("Before sorting by ID");
        Student.displayStudentBody(list);
        list.sort(list.get(0).compareByID);
        System.out.println("After sorting by ID");
        Student.displayStudentBody(list);






    }
}
