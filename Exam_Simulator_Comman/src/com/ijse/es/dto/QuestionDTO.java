/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dto;

/**
 *
 * @author User
 */
public class QuestionDTO extends SuperDTO {

    private String qid;
    private String question;
    private String subject;
    private String questionState;

    public QuestionDTO() {
    }

    public QuestionDTO(String qid, String question, String subject, String questionState) {
        this.qid = qid;
        this.question = question;
        this.subject = subject;
        this.questionState = questionState;
    }

    /**
     * @return the qid
     */
    public String getQid() {
        return qid;
    }

    /**
     * @param qid the qid to set
     */
    public void setQid(String qid) {
        this.qid = qid;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the questionState
     */
    public String getQuestionState() {
        return questionState;
    }

    /**
     * @param questionState the questionState to set
     */
    public void setQuestionState(String questionState) {
        this.questionState = questionState;
    }

}
