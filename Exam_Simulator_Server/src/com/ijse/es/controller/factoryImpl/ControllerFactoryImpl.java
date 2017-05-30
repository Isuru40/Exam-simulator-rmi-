/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller.factoryImpl;

import com.ijse.controller.factory.ControllerFactory;
import com.ijse.controller.factory.SuperController;
import com.ijse.es.controllerImpl.AnswerControllerImpl;
import com.ijse.es.controllerImpl.ExamControllerImpl;
import com.ijse.es.controllerImpl.ExamDetailsControllerImpl;
import com.ijse.es.controllerImpl.LecturerControllerImpl;
import com.ijse.es.controllerImpl.OptionControllerImpl;
import com.ijse.es.controllerImpl.ProgressDetailControllerImpl;
import com.ijse.es.controllerImpl.QuestionControllerImpl;
import com.ijse.es.controllerImpl.StudentControllerImpl;
import com.ijse.es.controllerImpl.TemporaryControllerImpl;
import com.ijse.es.controllerImpl.UserControllerImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author User
 */
public class ControllerFactoryImpl extends UnicastRemoteObject implements ControllerFactory {

    private static ControllerFactory controllerFactoryImpl;

    private ControllerFactoryImpl() throws RemoteException {
    }

    public static ControllerFactory getControllerFactory() throws RemoteException {
        if (controllerFactoryImpl == null) {
            controllerFactoryImpl = new ControllerFactoryImpl();
        }
        return controllerFactoryImpl;
    }

    @Override
    public SuperController getController(ControllerTypes controller) throws RemoteException {
        switch (controller) {
            case AnswerDTO:
                return new AnswerControllerImpl();
            case ExamDTO:
                return new ExamControllerImpl();
            case ExamDetailsDTO:
                return new ExamDetailsControllerImpl();
            case LecturerDTO:
                return new LecturerControllerImpl();
            case OptionDTO:
                return new OptionControllerImpl();
            case ProgressDetailDTO:
                return new ProgressDetailControllerImpl();
            case QuestionDTO:
                return new QuestionControllerImpl();
            case StudentDTO:
                return new StudentControllerImpl();
            case UserDTO:
                return new UserControllerImpl();
                 case TemporaryDTO:
                return new TemporaryControllerImpl();
            default:
                return null;
        }
    }

}
