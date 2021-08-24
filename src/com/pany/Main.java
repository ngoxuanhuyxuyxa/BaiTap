package com.pany;

import com.pany.exception.NameUniqueException;
import com.pany.exception.UniqueException;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static StudentManagement studentManagement = new StudentManagement();

    public static void main(String[] args) {
        int choice;
        do {
            Menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Hiển thị danh sác sinh viên:");
                    studentManagement.showAll();
                    break;
                }
                case 2: {
                    addNewStudent(studentManagement);
                    break;
                }
                case 3: {
                    System.exit(0);
                }
            }
        } while (choice != 0);
    }

    private static void Menu() {
        System.out.println("Menu");
        System.out.println("1.Hiển thị tất cả:");
        System.out.println("2.Thêm sinh viên:");
        System.out.println("0.Exit");
        System.out.println("nhập lựa chọn:");
    }

    private static void addNewStudent(StudentManagement studentManagement) {
        String id = "";
        do {
            try {
                id =  inputId(studentManagement);
            } catch (UniqueException e) {
                System.err.println("id này đã tồn tại");
            }
        }while (id.equals(""));
        String name = "";
        do {
            try {
                name = getName(studentManagement);
            } catch (NameUniqueException e) {
                System.err.println("trùng tên");;
            }
        }while (name.equals(""));



        System.out.println("nhập birthdate");
        String birthdate = scanner.nextLine();

        Student student = new Student(id,name,birthdate);
        studentManagement.addNewStudent(student);
    }

    private static String getName(StudentManagement studentManagement) throws NameUniqueException {
        System.out.println("nhập tên:");
        String name = scanner.nextLine();
        if (studentManagement.searchName(name) != -1){
            throw new NameUniqueException();
        }
        return name;
    }

    private static String inputId(StudentManagement studentManagement) throws UniqueException {
        System.out.println("id");
        String id = scanner.nextLine();
        if (studentManagement.searchId(id) != -1) {
            throw new UniqueException();
        }
        return id;
    }

}
