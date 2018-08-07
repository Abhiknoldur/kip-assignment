package com.knoldus.problem1;

import java.util.Optional;

public class ClassRoom {
    int roomID;
    Optional<Student> studentList;


    public ClassRoom(int roomID, Optional<Student> studentList) {
        this.roomID = roomID;
        this.studentList = studentList;
    }
}














//studentList(Optional<List<Student>>