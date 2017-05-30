/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.StudentDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface StudentController extends Remote, SuperController {

    public boolean addStudent(StudentDTO student) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateStudent(StudentDTO student) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteStudent(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<StudentDTO> getAllStudent() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public StudentDTO searchstudent(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;
}
