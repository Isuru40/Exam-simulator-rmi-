/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controller.reservation;

import com.ijse.es.controller.ExamController;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class ExamReservation {

    private HashMap<String, ExamController> reserved = new HashMap<>();

    public boolean reserveSeat(String eid, ExamController control) {
        if (reserved.containsKey(eid)) {
            if (reserved.get(eid) == control) {
                return true;
            } else {
                return false;
            }
        } else {
            reserved.put(eid, control);
            return true;
        }

    }

    public boolean releaseSeat(String eid, ExamController control) {
        if (reserved.get(eid) == control) {
            reserved.remove(eid);
            return true;
        } else {
            return false;
        }
    }
}
