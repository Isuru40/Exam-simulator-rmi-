/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.OptionDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface OptionController extends SuperController,Remote {

    public boolean addOpton(OptionDTO option) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateOption(OptionDTO option) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteOption(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public OptionDTO searchOption(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public List<OptionDTO> getAllOptions(String qid) throws RemoteException, IOException, ClassNotFoundException, ParseException;

}
