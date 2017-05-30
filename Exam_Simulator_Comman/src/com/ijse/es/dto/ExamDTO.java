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
public class ExamDTO extends SuperDTO {

    private String eid;
    private LecturerDTO lecturerDTO;
    private String examTitle;
    private String subject;
    private String time;
    private String date;
    private int hardQ;
    private int mediumQ;
    private int easyQ;
    private String batch;

    public ExamDTO() {
    }

    public ExamDTO(String eid, LecturerDTO lecturerDTO, String examTitle, String subject, String time, String date, int hardQ, int mediumQ, int easyQ, String batch) {
        this.eid = eid;
        this.lecturerDTO = lecturerDTO;
        this.examTitle = examTitle;
        this.subject = subject;
        this.time = time;
        this.date = date;
        this.hardQ = hardQ;
        this.mediumQ = mediumQ;
        this.easyQ = easyQ;
        this.batch = batch;
    }
     public String toString(){
        return examTitle;
    }

    /**
     * @return the eid
     */
    public String getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getExamTitle() {
        return examTitle;
    }

    /**
     * @param examTitle the examTitle to set
     */
    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

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
     * @return the hardQ
     */
    public int getHardQ() {
        return hardQ;
    }

    /**
     * @param hardQ the hardQ to set
     */
    public void setHardQ(int hardQ) {
        this.hardQ = hardQ;
    }

    /**
     * @return the mediumQ
     */
    public int getMediumQ() {
        return mediumQ;
    }

    /**
     * @param mediumQ the mediumQ to set
     */
    public void setMediumQ(int mediumQ) {
        this.mediumQ = mediumQ;
    }

    /**
     * @return the easyQ
     */
    public int getEasyQ() {
        return easyQ;
    }

    /**
     * @param easyQ the easyQ to set
     */
    public void setEasyQ(int easyQ) {
        this.easyQ = easyQ;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the lecturerDTO
     */
    public LecturerDTO getLecturerDTO() {
        return lecturerDTO;
    }

    /**
     * @param lecturerDTO the lecturerDTO to set
     */
    public void setLecturerDTO(LecturerDTO lecturerDTO) {
        this.lecturerDTO = lecturerDTO;
    }

}
