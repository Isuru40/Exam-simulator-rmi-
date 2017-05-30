/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.ExamDetailsController;
import com.ijse.es.dto.ExamDetailsDTO;
import com.ijse.es.dto.LecturerDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class ExamDetailsControllerImpl extends UnicastRemoteObject implements ExamDetailsController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public ExamDetailsControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addExamDetail(ExamDetailsDTO examDetails) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamDetailService().addExamDetail(examDetails);
    }

    @Override
    public boolean updateExamDetails(ExamDetailsDTO details) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLecture(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamDetailService().deleteExamDetails(id);
    }

    @Override
    public ExamDetailsDTO searchExamDetails(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getExamDetailService().searchExamDetails(eid);
    }

    @Override
    public List<ExamDetailsDTO> getAllExamDetailses() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamDetailService().getAllExamDetailses();
    }

    @Override
    public String getLastPaperID() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamDetailService().getLastPaperID();
    }

}
