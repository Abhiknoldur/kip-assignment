package com.knoldus.problem1;

import java.util.Optional;

public class Student {
     String name;
     int rollNumber;
     Optional<String> subject;


    public Student(String name, int rollNumber, Optional<String> subject) {
       this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
    }
    public String toString(){
        return "Student{"+"name="+name+",rollNumber="+rollNumber+",subject="+subject+"}";
    }
}
