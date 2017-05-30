/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.ExamController;
import com.ijse.es.controller.reservation.ExamReservation;
import com.ijse.es.dto.ExamDTO;
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
public class ExamControllerImpl extends UnicastRemoteObject implements ExamController, Subject {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static ExamReservation examReservation = new ExamReservation();
    public static ArrayList<Observer> observersList = new ArrayList<>();

    public ExamControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addExam(ExamDTO exam) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        boolean addExam = serviceFactory.getExamService().addExam(exam);
        notifyAllObservers(exam.getExamTitle() + " added to system");
        return addExam;
    }

    @Override
    public boolean updateExam(ExamDTO exam) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamService().updateExam(exam);
    }

    @Override
    public boolean deleteExam(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamService().deleteExam(id);
    }

    @Override
    public List<ExamDTO> getAllExam() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamService().getAllExam();
    }

    @Override
    public ExamDTO searchExam(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getExamService().searchExam(id);
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

    @Override
    public boolean reserveExam(String eid) throws RemoteException {
        return examReservation.reserveSeat(eid, this);
    }

    @Override
    public boolean releaseExam(String eid) throws RemoteException {
        return examReservation.releaseSeat(eid, this);
    }

}
