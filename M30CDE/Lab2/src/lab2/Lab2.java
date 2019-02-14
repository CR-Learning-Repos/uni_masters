/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author rollingc
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentManager stm = new StudentManager();
        stm.printStudents();
    }

    public static class StudentManager {

        public static void printStudents() {
            ArrayList<Student> students = new ArrayList<Student>();
            students.add(new Student("1", "Jhon"));
            students.add(new Student("2", "Jill"));

            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).Name);
            }
        }
    }
};
