/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.QuestionDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class QuestionService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addQuestion(QuestionDTO question) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().addQuestion(question);
    }

    public QuestionDTO searchQuestion(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().searchQuestion(id);
    }

    public boolean deleteQuestion(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().deleteQuestion(id);
    }

    public List<QuestionDTO> getAllQuestion() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().getAllQuestion();
    }
     public String getLastQuestionID() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().getLastQuestionID();
    }
      public HashMap<Integer, QuestionDTO> getRandomQuestion(String subject) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getQuestionDAO().RandomQuestion(subject);
    }
}
