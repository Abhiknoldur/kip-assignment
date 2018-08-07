package com.knoldus.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStudentDriver {

    public static void main(String[] args) {



        ClassRoom abhishekClass=new ClassRoom(111,Optional.empty());
       /// ClassRoom nikhilClass=new ClassRoom(222,Optional.of());
       Student abhishek = new Student("Abhishek", 2090, Optional.empty());
        Student nikhil=new Student("Nikhil",2089,Optional.of("English"));
        Student sachin=new Student("Sachin",87,Optional.of("Physics"));

        List<ClassRoom> classList=new ArrayList<>();

        List<Student> studentList = new ArrayList<>();
        studentList.add(abhishek);
        studentList.add(nikhil);
        studentList.add(sachin);
        classList.add(abhishekClass);

      /*  studentList.stream().forEach((stu)->{
            System.out.println("students associated with a room that have no subjects associated",
                    stu.name(),stu.rollNumber(),)});
        List<String> subjectOfStudent=classList.stream().filter(stu->stu.roomID==111).map(studentList.stream().map(stu->stu.subject)).collect(Collectors.toList());
        System.out.println(subjectOfStudent);
*/
        classList.stream().filter(print->print.studentList.isPresent()).forEach((print)-> System.out.println("hello Student"));


    }
}



/*
1. Find the students associated with a room that have no subjects associated.
        2. Find the subjects of students associated with a room that has roomID "xyz".
        3. print "hello Student" if a room has students associated.
*/
