/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.StudentController;
import static com.ijse.es.controllerImpl.ExamControllerImpl.observersList;
import com.ijse.es.dto.StudentDTO;
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
public class StudentControllerImpl extends UnicastRemoteObject implements StudentController, Subject {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();
    public static ArrayList<Observer> observersList = new ArrayList<>();

    public StudentControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addStudent(StudentDTO student) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getStudentService().addStudent(student);
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getStudentService().updateStudent(student);
    }

    @Override
    public boolean deleteStudent(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getStudentService().deleteStudent(id);
    }

    @Override
    public List<StudentDTO> getAllStudent() throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getStudentService().getAllStudent();
    }

    @Override
    public StudentDTO searchstudent(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getStudentService().searchStudent(id);
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
