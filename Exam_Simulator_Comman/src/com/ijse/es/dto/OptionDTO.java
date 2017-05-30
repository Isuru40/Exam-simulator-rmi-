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
public class OptionDTO extends SuperDTO {

    private String oid;
    private String qid;
    private String option;

    public OptionDTO(String oid, String qid, String option) {
        this.oid = oid;
        this.qid = qid;
        this.option = option;
    }

    public OptionDTO() {
    }

    /**
     * @return the oid
     */
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
     * @return the option
     */
    public String getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(String option) {
        this.option = option;
    }

}
