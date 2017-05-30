/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.service;

import com.ijse.es.dao.factory.DAOFactory;
import com.ijse.es.dao.factoryImpl.DAOFactoryImpl;
import com.ijse.es.dto.OptionDTO;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class OptionService {

    private final DAOFactory accessFactory = new DAOFactoryImpl();

    public boolean addOption(OptionDTO option) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getOptionDAO().addOption(option);
    }

    public OptionDTO searchOption(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getOptionDAO().searchOption(id);
    }

    public boolean deleteOption(String id) throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getOptionDAO().deleteOption(id);
    }

    public List<OptionDTO> getAllOption() throws RemoteException, ClassNotFoundException, ParseException, IOException {
        return accessFactory.getOptionDAO().getAllOption();
    }
}
