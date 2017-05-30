/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.QuestionController;
import com.ijse.es.dto.QuestionDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class QuestionControllerImpl extends UnicastRemoteObject implements QuestionController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public QuestionControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addQuestion(QuestionDTO question) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getQuestionService().addQuestion(question);
    }

    @Override
    public boolean updateQuestion(QuestionDTO question) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteQuestion(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getOptionService().deleteOption(id);
    }

    @Override
    public List<QuestionDTO> getAllQuestion() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getQuestionService().getAllQuestion();
    }

    @Override
    public String getLastQuestionID() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getQuestionService().getLastQuestionID();
    }

    @Override
    public HashMap<Integer, QuestionDTO> getRandomQuestion(String subject) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getQuestionService().getRandomQuestion(subject);
    }

}
