/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.UserDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author UserDTO
 */
public interface UserController extends Remote,SuperController {

    public boolean addUser(UserDTO user) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public boolean deleteUser(String userId) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public UserDTO searchUser(String userId) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public boolean updateUser(UserDTO user) throws RemoteException, IOException, ParseException, ClassNotFoundException;

}
