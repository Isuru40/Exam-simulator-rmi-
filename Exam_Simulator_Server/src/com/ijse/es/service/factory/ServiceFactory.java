 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service.factory;

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

/**
 *
 * @author User
 */
public interface ServiceFactory {

    public AnswerService getAnswerService();

    public ExamDetailService getExamDetailService();

    public ExamService getExamService();

    public LecturerService getLecturerService();

    public OptionService getOptionService();

    public ProgressDetailService getProgressDetailService();

    public QuestionService getQuestionService();

    public StudentService getStudentService();

    public UserService getUserService();

    public TemporaryService getTemporaryService();
}
