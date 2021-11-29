package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teachers = new Teacher[5];
    public boolean addTeacher(Teacher teacher) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            if(teachers[i] == (null)){
                index = i;
                break;
            }
        }
        if(index == -1){
            return false;
        }else{
            teachers[index] = teacher;
            return true;
        }
    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }
}
