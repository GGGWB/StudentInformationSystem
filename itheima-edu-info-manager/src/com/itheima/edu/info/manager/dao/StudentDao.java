package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] students = new Student[5];

    public boolean addStudent(Student student) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            Student stu = students[i];
            if (stu == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            students[index] = student;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return students;
    }

    public void delStudentById(String delStuId) {
        int index = getIndex(delStuId);
        students[index] = null;
    }

    private int getIndex(String delStuId) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            Student stu = students[i];
            if (stu != null && stu.getId().equals(delStuId)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String id, Student student) {
        int index = getIndex(id);
        students[index] = student;
    }
}
