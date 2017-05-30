/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.UserController;
import com.ijse.es.dto.UserDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;

/**
 *
 * @author UserDTO
 */
public class UserControllerImpl extends UnicastRemoteObject implements UserController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public UserControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addUser(UserDTO user) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getUserService().addUser(user);
    }

    @Override
    public boolean deleteUser(String userId) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getUserService().deleteUser(userId);
    }

    @Override
    public UserDTO searchUser(String userId) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getUserService().searchUser(userId);
    }

    @Override
    public boolean updateUser(UserDTO user) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getUserService().updateUser(user);
    }

}
