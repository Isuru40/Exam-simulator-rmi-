/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.ProgressDetailDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class ProgressDetailService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addProgressDetail(ProgressDetailDTO detail) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().addProgressDetail(detail);
    }

    public ProgressDetailDTO searchProgressDetail(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().searchProgressDetail(id);
    }

    public boolean deleteProgressDetail(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().deleteProgressDetail(id);
    }

    public List<ProgressDetailDTO> getAllProgressDetail() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().getAllProgressDetail();
    }

    public ProgressDetailDTO searchProgressDetailsByEIDandSID(String eid, String sid) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().searchProgressDetailsByEIDandSID(eid, sid);
    }
     public List<ProgressDetailDTO> getStudentProgressDetail(String sid) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getProgressDetailDAO().getStudentProgressDetail(sid);
    }
}
