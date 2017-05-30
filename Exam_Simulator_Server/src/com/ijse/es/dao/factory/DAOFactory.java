/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao.factory;

import com.ijse.es.dao.AnswerDAO;
import com.ijse.es.dao.ExamDAO;
import com.ijse.es.dao.ExamDetailDAO;
import com.ijse.es.dao.LecturerDAO;
import com.ijse.es.dao.OptionDAO;
import com.ijse.es.dao.ProgressDetailDAO;
import com.ijse.es.dao.QuestionDAO;
import com.ijse.es.dao.StudentDAO;
import com.ijse.es.dao.TemporaryDAO;
import com.ijse.es.dao.UserDAO;

/**
 *
 * @author User
 */
public interface DAOFactory {

    public AnswerDAO getAnswerDAO();

    public ExamDetailDAO getExamDetailDAO();

    public ExamDAO getExamDAO();

    public LecturerDAO getLecturerDAO();

    public ProgressDetailDAO getProgressDetailDAO();

    public QuestionDAO getQuestionDAO();

    public StudentDAO getStudentDAO();

    public OptionDAO getOptionDAO();

    public UserDAO getUserDAO();

    public TemporaryDAO getTemporaryDAO();
}
