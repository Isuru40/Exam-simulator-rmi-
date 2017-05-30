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
public class AnswerDTO extends SuperDTO {

    private String qid;
    private String oid;
    private String answer;

    public AnswerDTO() {
    }

    public AnswerDTO(String qid, String oid, String answer) {
        this.qid = qid;
        this.oid = oid;
        this.answer = answer;
    }

    public AnswerDTO(String qid, String oid) {
        this.qid = qid;
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
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

}
