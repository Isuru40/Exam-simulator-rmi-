/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.LecturerDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface LecturerController extends SuperController {

    public boolean addLecturer(LecturerDTO lecturer) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateLecturer(LecturerDTO lecturer) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteLecture(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<LecturerDTO> getAllLecturers() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public LecturerDTO searchLecturer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;
}
