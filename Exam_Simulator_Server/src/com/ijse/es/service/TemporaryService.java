/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.TemporaryDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class TemporaryService {

    private DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addAnswer(TemporaryDTO temporaryDTO) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getTemporaryDAO().addTemporaryDetail(temporaryDTO);
    }

    public TemporaryDTO searchQID(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getTemporaryDAO().searchQID(id);
    }

    public List<TemporaryDTO> getAllAnswer() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getTemporaryDAO().getAllAnswer();
    }

    public boolean deleteFile() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getTemporaryDAO().deleteFile();
    }
    public boolean updateQID(TemporaryDTO dTO) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getTemporaryDAO().updateShedule(dTO);
    }
}
