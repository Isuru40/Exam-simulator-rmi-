/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.ExamDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public interface ExamController extends Remote, SuperController {

    public boolean addExam(ExamDTO exam) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateExam(ExamDTO exam) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteExam(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<ExamDTO> getAllExam() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public ExamDTO searchExam(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean reserveExam(String eid) throws RemoteException;

    public boolean releaseExam(String eid) throws RemoteException;
}
