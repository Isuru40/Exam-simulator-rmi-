/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.TemporaryController;
import com.ijse.es.dto.TemporaryDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class TemporaryControllerImpl extends UnicastRemoteObject implements TemporaryController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public TemporaryControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addTemporaryDetail(TemporaryDTO dTO) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getTemporaryService().addAnswer(dTO);
    }

    @Override
    public boolean deleteFile() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getTemporaryService().deleteFile();
    }

    @Override
    public TemporaryDTO searchQID(String qid) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getTemporaryService().searchQID(qid);
    }

    @Override
    public boolean updateQID(TemporaryDTO temporaryDTO) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getTemporaryService().updateQID(temporaryDTO);
    }

    @Override
    public List<TemporaryDTO> getAllAnswer() throws FileNotFoundException, IOException, ParseException, RemoteException, ClassNotFoundException {
        return serviceFactory.getTemporaryService().getAllAnswer();
    }

}
