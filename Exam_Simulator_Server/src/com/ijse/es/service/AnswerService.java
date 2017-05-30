/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.AnswerDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class AnswerService {

    private DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addAnswer(AnswerDTO answer) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getAnswerDAO().addAnswer(answer);
    }

    public AnswerDTO searchAnswer(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getAnswerDAO().searchAnswer(id);
    }

    public boolean deleteAnswer(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getAnswerDAO().deleteAnswer(id);
    }

    public List<AnswerDTO> getAllAnswer() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getAnswerDAO().getAllAnswer();
    }
}
