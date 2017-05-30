/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service.factoryImpl;

import com.ijse.es.service.AnswerService;
import com.ijse.es.service.ExamDetailService;
import com.ijse.es.service.ExamService;
import com.ijse.es.service.LecturerService;
import com.ijse.es.service.OptionService;
import com.ijse.es.service.ProgressDetailService;
import com.ijse.es.service.QuestionService;
import com.ijse.es.service.StudentService;
import com.ijse.es.service.TemporaryService;
import com.ijse.es.service.UserService;
import com.ijse.es.service.factory.ServiceFactory;

/**
 *
 * @author User
 */
public class ServiceFactoryImpl implements ServiceFactory {

    @Override
    public AnswerService getAnswerService() {
        return new AnswerService();
    }

    @Override
    public ExamDetailService getExamDetailService() {
        return new ExamDetailService();
    }

    @Override
    public ExamService getExamService() {
        return new ExamService();
    }

    @Override
    public LecturerService getLecturerService() {
        return new LecturerService();
    }

    @Override
    public OptionService getOptionService() {
        return new OptionService();
    }

    @Override
    public ProgressDetailService getProgressDetailService() {
        return new ProgressDetailService();
    }

    @Override
    public QuestionService getQuestionService() {
        return new QuestionService();
    }

    @Override
    public StudentService getStudentService() {
        return new StudentService();
    }

    @Override
    public UserService getUserService() {
        return new UserService();
    }

    @Override
    public TemporaryService getTemporaryService() {
        return new TemporaryService();
    }

}
