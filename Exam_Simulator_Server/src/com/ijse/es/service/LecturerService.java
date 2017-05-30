/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.LecturerDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class LecturerService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addLecturer(LecturerDTO lecturer) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getLecturerDAO().addLecturer(lecturer);
    }

    public LecturerDTO searchLecturer(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getLecturerDAO().searchLecturer(id);
    }

    public boolean deleteLecturer(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getLecturerDAO().deleteLecturer(id);
    }

    public List<LecturerDTO> getAllLecturer() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getLecturerDAO().getAllLecturer();
    }
}
