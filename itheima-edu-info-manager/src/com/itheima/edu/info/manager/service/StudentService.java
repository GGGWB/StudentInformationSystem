package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student student) {

        boolean result = studentDao.addStudent(student);
        return result;
    }

    public boolean isExists(String id) {

        Student[] stus = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            if(allStudent[i] != null){
                flag = true;
                break;
            }
        }
        if(flag){
            return allStudent;
        }else{
            return null;
        }

    }

    public void delStudentById(String delStuId) {
        studentDao.delStudentById(delStuId);
    }


    public void updateStudent(String id, Student student) {
        studentDao.updateStudent(id, student);
    }
}
