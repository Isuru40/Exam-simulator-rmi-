/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.ExamDetailsDTO;
import com.ijse.es.dto.LecturerDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface ExamDetailsController extends Remote, SuperController {

    public boolean addExamDetail(ExamDetailsDTO examDetails) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateExamDetails(ExamDetailsDTO details) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteLecture(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public ExamDetailsDTO searchExamDetails(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException;

    public List<ExamDetailsDTO> getAllExamDetailses() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public String getLastPaperID() throws RemoteException, IOException, ClassNotFoundException, ParseException;

}
