/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.ProgressDetailDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProgressDetailController extends Remote, SuperController {

    public boolean addProgressDetails(ProgressDetailDTO progressDetail) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateProgressDetail(ProgressDetailDTO progressDetail) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteProgressDetail(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<ProgressDetailDTO> getAllProgressDetail() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public ProgressDetailDTO searchProgressDetails(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public ProgressDetailDTO searchProgressDetailsByEIDandSID(String eid, String sid) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public List<ProgressDetailDTO> getStudentProgressDetail(String sid) throws RemoteException, IOException, ClassNotFoundException, ParseException;

}
