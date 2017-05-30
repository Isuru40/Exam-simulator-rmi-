/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.connector;

import com.ijse.controller.factory.ControllerFactory;
import com.ijse.es.controller.AnswerController;
import com.ijse.es.controller.ExamController;
import com.ijse.es.controller.ExamDetailsController;
import com.ijse.es.controller.LecturerController;
import com.ijse.es.controller.OptionController;
import com.ijse.es.controller.ProgressDetailController;
import com.ijse.es.controller.QuestionController;
import com.ijse.es.controller.StudentController;
import com.ijse.es.controller.TemporaryController;
import com.ijse.es.controller.UserController;
import com.ijse.es.dto.AnswerDTO;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public class ServerConnector {

    private static ServerConnector serverConnector;

    private final ControllerFactory controllerFactory;
    private AnswerController answerController;
    private ExamController examController;
    private ExamDetailsController examDetailsController;
    private LecturerController lecturerController;
    private OptionController optionController;
    private ProgressDetailController progressDetailController;
    private QuestionController questionController;
    private StudentController studentController;
    private UserController userController;
    private TemporaryController temporaryController;

    public ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        controllerFactory = (ControllerFactory) Naming.lookup("rmi://localhost:5050/ExamSimulatorServer");
    }

    public AnswerController getAnswerController() throws RemoteException {
        if (answerController == null) {
            answerController = (AnswerController) controllerFactory.getController(ControllerFactory.ControllerTypes.AnswerDTO);
        }
        return answerController;
    }

    public ExamController getExamController() throws RemoteException {
        if (examController == null) {
            examController = (ExamController) controllerFactory.getController(ControllerFactory.ControllerTypes.ExamDTO);
        }
        return examController;
    }

    public ExamDetailsController getExamDetailsController() throws RemoteException {
        if (examDetailsController == null) {
            examDetailsController = (ExamDetailsController) controllerFactory.getController(ControllerFactory.ControllerTypes.ExamDetailsDTO);
        }
        return examDetailsController;
    }

    public LecturerController getLecturerController() throws RemoteException {
        if (lecturerController == null) {
            lecturerController = (LecturerController) controllerFactory.getController(ControllerFactory.ControllerTypes.LecturerDTO);
        }
        return lecturerController;
    }

    public OptionController getOptionController() throws RemoteException {
        if (optionController == null) {
            optionController = (OptionController) controllerFactory.getController(ControllerFactory.ControllerTypes.OptionDTO);
        }
        return optionController;
    }

    public ProgressDetailController getProgressDetailController() throws RemoteException {
        if (progressDetailController == null) {
            progressDetailController = (ProgressDetailController) controllerFactory.getController(ControllerFactory.ControllerTypes.ProgressDetailDTO);
        }
        return progressDetailController;
    }

    public QuestionController getQuestionController() throws RemoteException {
        if (questionController == null) {
            questionController = (QuestionController) controllerFactory.getController(ControllerFactory.ControllerTypes.QuestionDTO);
        }
        return questionController;
    }

    public StudentController getStudentController() throws RemoteException {
        if (studentController == null) {
            studentController = (StudentController) controllerFactory.getController(ControllerFactory.ControllerTypes.StudentDTO);
        }
        return studentController;
    }

    public UserController getUserController() throws RemoteException {
        if (userController == null) {
            userController = (UserController) controllerFactory.getController(ControllerFactory.ControllerTypes.UserDTO);
        }
        return userController;
    }

    public TemporaryController getTemporaryController() throws RemoteException {
        if (temporaryController == null) {
            temporaryController = (TemporaryController) controllerFactory.getController(ControllerFactory.ControllerTypes.TemporaryDTO);
        }
        return temporaryController;
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }
}
