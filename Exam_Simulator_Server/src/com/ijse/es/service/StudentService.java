/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.StudentDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class StudentService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addStudent(StudentDTO student) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getStudentDAO().addStudent(student);
    }

    public StudentDTO searchStudent(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getStudentDAO().searchStudent(id);
    }

    public boolean deleteStudent(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getStudentDAO().deleteStudent(id);
    }

    public List<StudentDTO> getAllStudent() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getStudentDAO().getAllStudent();
    }
     public boolean updateStudent(StudentDTO student) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getStudentDAO().updateStudent(student);
    }
}
