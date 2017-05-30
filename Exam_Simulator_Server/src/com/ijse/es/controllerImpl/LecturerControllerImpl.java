/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.LecturerController;
import com.ijse.es.dto.LecturerDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class LecturerControllerImpl extends UnicastRemoteObject implements LecturerController {
    
    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    
    public LecturerControllerImpl() throws RemoteException {
    }
    
    @Override
    public boolean addLecturer(LecturerDTO lecturer) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getLecturerService().addLecturer(lecturer);
    }
    
    @Override
    public boolean updateLecturer(LecturerDTO lecturer) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean deleteLecture(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getLecturerService().deleteLecturer(id);
    }
    
    @Override
    public List<LecturerDTO> getAllLecturers() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getLecturerService().getAllLecturer();
    }
    
    @Override
    public LecturerDTO searchLecturer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getLecturerService().searchLecturer(id);
    }
    
}
