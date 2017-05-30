/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.controller.factory;

import com.ijse.es.dto.TemporaryDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public interface ControllerFactory extends Remote {

    public enum ControllerTypes {

        AnswerDTO, ExamDTO, ExamDetailsDTO, LecturerDTO, OptionDTO, ProgressDetailDTO, QuestionDTO, StudentDTO, UserDTO,TemporaryDTO;
    }

    public SuperController getController(ControllerTypes controller) throws RemoteException;
}
