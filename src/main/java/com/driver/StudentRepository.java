package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

//   studentMap = name vs studentObj
    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            List<String> temp;
            if(!teacherStudentMapping.containsKey(teacher)) {
                temp = new ArrayList<>();
            }
            else {
                temp = teacherStudentMapping.get(teacher);
            }
            temp.add(student);
            teacherStudentMapping.put(teacher, temp);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        return studentMap.getOrDefault(student, null);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        return teacherMap.getOrDefault(teacher, null);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        return teacherStudentMapping.getOrDefault(teacher, null);
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String> allStudents = new ArrayList<>();
        for(String name : studentMap.keySet()) {
            allStudents.add(name);
        }
        return allStudents;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){

    /*


    Set<String> teacherKeys = teacherMap.keySet();
    for (String teacher : teacherKeys) {
        teacherMap.remove(teacher);
    }

    */
        teacherMap.clear();
    }
}