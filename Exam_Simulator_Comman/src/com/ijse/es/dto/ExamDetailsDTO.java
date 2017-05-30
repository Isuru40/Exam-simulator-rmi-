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
public class ExamDetailsDTO extends SuperDTO {

    private String pid;
    private String pQid;
    private ExamDTO examDTO;
    private QuestionDTO questionDTO;
    private String date;

    public ExamDetailsDTO() {
    }

    public ExamDetailsDTO(String pid, String pQid, ExamDTO examDTO, QuestionDTO questionDTO, String date) {
        this.pid = pid;
        this.pQid = pQid;
        this.examDTO = examDTO;
        this.questionDTO = questionDTO;
        this.date = date;
    }

   
    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the qid
     */
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the examDTO
     */
    public ExamDTO getExamDTO() {
        return examDTO;
    }

    /**
     * @param examDTO the examDTO to set
     */
    public void setExamDTO(ExamDTO examDTO) {
        this.examDTO = examDTO;
    }

    /**
     * @return the questionDTO
     */
    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    /**
     * @param questionDTO the questionDTO to set
     */
    public void setQuestionDTO(QuestionDTO questionDTO) {
        this.questionDTO = questionDTO;
    }

    /**
     * @return the pQid
     */
    public String getpQid() {
        return pQid;
    }

    /**
     * @param pQid the pQid to set
     */
    public void setpQid(String pQid) {
        this.pQid = pQid;
    }

}
