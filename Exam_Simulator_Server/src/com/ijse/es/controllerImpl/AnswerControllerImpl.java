/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.AnswerController;
import com.ijse.es.dto.AnswerDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;

/**
 *
 * @author User
 */
public class AnswerControllerImpl extends UnicastRemoteObject implements AnswerController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public AnswerControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addAnswer(AnswerDTO answer) throws RemoteException, IOException, ClassNotFoundException, ParseException {
      return serviceFactory.getAnswerService().addAnswer(answer);
    }

    @Override
    public boolean updateAnswer(AnswerDTO answer) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAnswer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
  return serviceFactory.getAnswerService().deleteAnswer(id);
    }

    @Override
    public AnswerDTO searchAnswer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getAnswerService().searchAnswer(id);
    }

}
