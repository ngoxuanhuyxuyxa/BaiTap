package com.pany;

import com.pany.Student;

import java.util.ArrayList;

public class StudentManagement {
    public static ArrayList<Student> students = new ArrayList<>();

    public void showAll(){
        for (Student student:students
             ) {
            System.out.println(student);
        }
    }
    public  void addNewStudent(Student student){
        students.add(student);
    }
    public int searchId(String id){
        int index = -1;
        for (int i = 0; i <students.size() ; i++) {
            if(id.equals(students.get(i).getId())){
                 index = i;
                 break;
            }
        }
        return index;

    }

    public int searchName(String name){
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (name.equals(students.get(i).getName())){
                index = i;
            }
        }
        return index;
    }
}
