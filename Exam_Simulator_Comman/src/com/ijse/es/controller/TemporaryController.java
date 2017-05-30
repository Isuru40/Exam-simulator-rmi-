/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.TemporaryDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface TemporaryController extends SuperController {

    public boolean addTemporaryDetail(TemporaryDTO dTO) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteFile() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public TemporaryDTO searchQID(String qid) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateQID(TemporaryDTO temporaryDTO) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<TemporaryDTO> getAllAnswer() throws RemoteException, IOException, ClassNotFoundException, ParseException;
}
