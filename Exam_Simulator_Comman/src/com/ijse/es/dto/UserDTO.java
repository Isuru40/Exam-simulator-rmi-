/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dto;

/**
 *
 * @author UserDTO
 */
public class UserDTO extends SuperDTO {

    private String useid;
    private String name;
    private String password;
    private String privilage;

    public UserDTO(String useid, String name, String password, String privilage) {
        this.useid = useid;
        this.name = name;
        this.password = password;
        this.privilage = privilage;
    }

    public UserDTO() {
    }

    /**
     * @return the useid
     */
    public String getUseid() {
        return useid;
    }

    /**
     * @param useid the useid to set
     */
    public void setUseid(String useid) {
        this.useid = useid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the privilage
     */
    public String getPrivilage() {
        return privilage;
    }

    /**
     * @param privilage the privilage to set
     */
    public void setPrivilage(String privilage) {
        this.privilage = privilage;
    }

}
