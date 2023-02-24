package daopattern;

import entities.Classes;
import entities.Student;

import java.util.ArrayList;

public class StudentsDAO implements DAOInterface<Student> {
    @Override
    public ArrayList<Student> getAll() {
        return null;
    }

    @Override
    public boolean create(Student classes) {
        return false;
    }

    @Override
    public boolean update(Student classes) {
        return false;
    }

    @Override
    public boolean delete(Student classes) {
        return false;
    }

    @Override
    public Student find(Integer id) {
        return null;
    }
}
