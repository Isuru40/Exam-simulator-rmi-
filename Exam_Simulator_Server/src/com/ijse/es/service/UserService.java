/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.UserDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author UserDTO
 */
public class UserService {
    DAOFactory accessFactory=new DAOFactoryImpl();
    public boolean addUser(UserDTO user)throws RemoteException,ParseException,ClassNotFoundException,IOException{
       return accessFactory.getUserDAO().addUser(user);
    }
    public boolean deleteUser(String userID)throws RemoteException,ParseException,ClassNotFoundException,IOException{
        return accessFactory.getUserDAO().deleteUser(userID);
    }
    public UserDTO searchUser(String userID)throws RemoteException, IOException, ParseException{
        return accessFactory.getUserDAO().searchUser(userID);
    }
    public boolean updateUser(UserDTO user) throws IOException, FileNotFoundException, ParseException{
        return accessFactory.getUserDAO().updateUser(user);
    }
}
