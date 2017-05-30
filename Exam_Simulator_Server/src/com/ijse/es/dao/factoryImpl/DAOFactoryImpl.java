/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao.factoryImpl;

import com.ijse.es.dao.AnswerDAO;
import com.ijse.es.dao.ExamDetailDAO;
import com.ijse.es.dao.ExamDAO;
import com.ijse.es.dao.LecturerDAO;
import com.ijse.es.dao.OptionDAO;
import com.ijse.es.dao.ProgressDetailDAO;
import com.ijse.es.dao.QuestionDAO;
import com.ijse.es.dao.StudentDAO;
import com.ijse.es.dao.TemporaryDAO;
import com.ijse.es.dao.UserDAO;
import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factory.SuperDaoController;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public class DAOFactoryImpl implements DAOFactory {

    public DAOFactoryImpl() {
    }

    @Override
    public AnswerDAO getAnswerDAO() {
        return new AnswerDAO();
    }

    @Override
    public ExamDetailDAO getExamDetailDAO() {
        return new ExamDetailDAO();
    }

    @Override
    public ExamDAO getExamDAO() {
        return new ExamDAO();
    }

    @Override
    public LecturerDAO getLecturerDAO() {
        return new LecturerDAO();
    }

    @Override
    public ProgressDetailDAO getProgressDetailDAO() {
        return new ProgressDetailDAO();
    }

    @Override
    public QuestionDAO getQuestionDAO() {
        return new QuestionDAO();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAO();
    }

    @Override
    public OptionDAO getOptionDAO() {
        return new OptionDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public TemporaryDAO getTemporaryDAO() {
      return new TemporaryDAO();
    }
    
}
