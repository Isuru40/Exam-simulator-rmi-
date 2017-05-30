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
public class TemporaryDTO extends SuperDTO{
    private String qid;
    private String oid;

    public TemporaryDTO(String qid, String oid) {
        this.qid = qid;
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
    
}
