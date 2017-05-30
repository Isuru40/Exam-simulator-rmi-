/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller;

import com.ijse.controller.factory.SuperController;
import com.ijse.es.dto.QuestionDTO;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public interface QuestionController extends Remote,SuperController {

    public boolean addQuestion(QuestionDTO question) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean updateQuestion(QuestionDTO question) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public boolean deleteQuestion(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public List<QuestionDTO> getAllQuestion() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public String getLastQuestionID() throws RemoteException, IOException, ClassNotFoundException, ParseException;

    public HashMap<Integer, QuestionDTO> getRandomQuestion(String subject) throws RemoteException, IOException, ClassNotFoundException, ParseException;
}
