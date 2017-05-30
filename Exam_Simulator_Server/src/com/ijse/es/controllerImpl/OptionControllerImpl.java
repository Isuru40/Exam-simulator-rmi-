/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.controllerImpl;

import com.ijse.es.controller.OptionController;
import com.ijse.es.dto.OptionDTO;
import com.ijse.es.service.factory.ServiceFactory;
import com.ijse.es.service.factoryImpl.ServiceFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author User
 */
public class OptionControllerImpl extends UnicastRemoteObject implements OptionController {

    ServiceFactory serviceFactory = new ServiceFactoryImpl();

    public OptionControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addOpton(OptionDTO option) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getOptionService().addOption(option);
    }

    @Override
    public boolean updateOption(OptionDTO option) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOption(String id) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getOptionService().deleteOption(id);
    }

    @Override
    public OptionDTO searchOption(String eid) throws RemoteException, IOException, ParseException, ClassNotFoundException {
        return serviceFactory.getOptionService().searchOption(eid);
    }

    @Override
    public List<OptionDTO> getAllOptions(String qid) throws RemoteException, IOException, ClassNotFoundException, ParseException {
        return serviceFactory.getOptionService().getAllOption();
    }

}
