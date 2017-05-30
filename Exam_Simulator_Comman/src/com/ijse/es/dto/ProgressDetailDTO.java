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
public class ProgressDetailDTO extends SuperDTO {

    private String pid;
    private StudentDTO studentDTO;
    private ExamDTO examDTO;
    private double presentage;
    private String date;

    public ProgressDetailDTO(String pid, StudentDTO studentDTO, ExamDTO examDTO, double presentage, String date) {
        this.pid = pid;
        this.studentDTO = studentDTO;
        this.examDTO = examDTO;
        this.presentage = presentage;
        this.date = date;
    }

    public ProgressDetailDTO() {
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
     * @return the sid
     */
    /**
     * @return the presentage
     */
    public double getPresentage() {
        return presentage;
    }

    /**
     * @param presentage the presentage to set
     */
    public void setPresentage(double presentage) {
        this.presentage = presentage;
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
     * @return the studentDTO
     */
    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    /**
     * @param studentDTO the studentDTO to set
     */
    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
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

}
