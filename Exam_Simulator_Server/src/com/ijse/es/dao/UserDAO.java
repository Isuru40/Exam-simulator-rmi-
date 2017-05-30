/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.UserDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UserDTO
 */
public class UserDAO implements SuperDaoController{

    private static final File file = new File("./src/com/ijse/es/files/User.txt");

    public static boolean addUser(UserDTO user) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += user.getUseid() + "#";
        data += user.getName() + "#";
        data += user.getPassword() + "#";
        data += user.getPrivilage() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(user.getUseid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String userID) throws IOException, FileNotFoundException, ParseException {
        UserDTO user = searchUser(userID);
        return user == null;
    }

    public static UserDTO searchUser(String userID) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        UserDTO user = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(userID)) {
                    user = new UserDTO();
                    user.setUseid(data[0]);
                    user.setName(data[1]);
                    user.setPassword(data[2]);
                    user.setPrivilage(data[3]);

                }
            }
            return user;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /*  public static ArrayList<User> getAllUser() throws FileNotFoundException, IOException, ParseException {
     BufferedReader reader = null;
     ArrayList<User> userList = new ArrayList<>();

     try {
     if (file.exists()) {
     FileReader fileReader = new FileReader(file);
     reader = new BufferedReader(fileReader);
     String line = null;
     while ((line = reader.readLine()) != null) {
     String[] data = line.split("@");
     UserDTO tr = new UserDTO();
     tr.setUseid(data[0]);
     tr.setName(data[1]);
     tr.setPassword(data[2]);
     userList.add(tr);

     }
     }

     return userList;
     } finally {
     if (reader != null) {
     reader.close();

     }

     }

     }*/
    public static boolean deleteUser(String id) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(id)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(id);
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }

    public static boolean updateUser(UserDTO user) throws IOException, FileNotFoundException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(user.getUseid())) {
                    fileData.add(line);
                } else {
                    String updateLine = "";
                    updateLine += user.getUseid() + "#";
                    updateLine += user.getName() + "#";
                    updateLine += user.getPassword() + "#";
                    updateLine += user.getPrivilage() + "#";
                    fileData.add(updateLine);
                }

            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(user.getUseid());
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }
}
