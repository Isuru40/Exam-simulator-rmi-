 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.ExamDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class ExamService {

    private DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addExam(ExamDTO examDTO) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDAO().addExam(examDTO);
    }

    public ExamDTO searchExam(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDAO().searchExam(id);
    }

    public boolean deleteExam(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDAO().deleteExam(id);
    }

    public List<ExamDTO> getAllExam() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDAO().getAllExam();
    }
      public boolean updateExam(ExamDTO examDTO) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getExamDAO().updateExan(examDTO);
    }
}
