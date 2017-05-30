/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.ProgressDetailController;
import static com.ijse.es.controllerImpl.ExamControllerImpl.observersList;
import com.ijse.es.dto.ProgressDetailDTO;
import com.ijse.es.observer.Observer;
import com.ijse.es.observer.Subject;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProgressDetailControllerImpl extends UnicastRemoteObject implements ProgressDetailController, Subject {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    public static ArrayList<Observer> observersList = new ArrayList<>();

    public ProgressDetailControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addProgressDetails(ProgressDetailDTO progressDetail) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        boolean add = serviceFactory.getProgressDetailService().addProgressDetail(progressDetail);
        notifyAllObservers(progressDetail.getExamDTO().getExamTitle() + " progress detail added");
        return add;

    }

    @Override
    public boolean updateProgressDetail(ProgressDetailDTO progressDetail) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteProgressDetail(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getProgressDetailService().deleteProgressDetail(id);
    }

    @Override
    public List<ProgressDetailDTO> getAllProgressDetail() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getProgressDetailService().getAllProgressDetail();
    }

    @Override
    public ProgressDetailDTO searchProgressDetails(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getProgressDetailService().searchProgressDetail(eid);
    }

    @Override
    public ProgressDetailDTO searchProgressDetailsByEIDandSID(String eid, String sid) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getProgressDetailService().searchProgressDetailsByEIDandSID(eid, sid);
    }

    @Override
    public List<ProgressDetailDTO> getStudentProgressDetail(String sid) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getProgressDetailService().getStudentProgressDetail(sid);

    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        observersList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        observersList.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws RemoteException {
        new Thread() {
            public void run() {
                try {
                    for (Observer observersList1 : observersList) {
                        observersList1.update(message);
                    }
                } catch (RemoteException e) {
                }
            }
        }.start();
    }

}
