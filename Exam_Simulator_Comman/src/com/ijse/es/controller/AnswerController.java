/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.AnswerDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author User
 */
public interface AnswerController extends Remote,SuperController {

    public boolean addAnswer(AnswerDTO answer) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateAnswer(AnswerDTO answer) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteAnswer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public AnswerDTO searchAnswer(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

}
