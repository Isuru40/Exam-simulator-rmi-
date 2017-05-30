/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.ExamDetailsDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class ExamDetailService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addExamDetail(ExamDetailsDTO details) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDetailDAO().addExamDetails(details);
    }

    public ExamDetailsDTO searchExamDetails(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDetailDAO().searchExamDetails(id);
    }

    public boolean deleteExamDetails(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDetailDAO().deleteExamDetails(id);
    }

    public List<ExamDetailsDTO> getAllExamDetailses() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDetailDAO().getAllExamDetails();
    }
     public String getLastPaperID() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDetailDAO().getLastPaperID();
    }
}
