/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.OptionDTO;
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
 * @author User
 */
public class OptionDAO implements SuperDaoController{
      private static final File file = new File("./src/com/ijse/es/files/Option.txt");

    public static boolean addOption(OptionDTO option) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += option.getOid() + "#";
        data += option.getQid() + "#";
        data += option.getOption() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(option.getOid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String oid) throws IOException, FileNotFoundException, ParseException {
        OptionDTO option = searchOption(oid);
        return option == null;
    }

    public static OptionDTO searchOption(String oid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        OptionDTO option = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(oid)) {
                    option = new OptionDTO();
                    option.setOid(data[0]);
                    option.setQid(data[1]);
                    option.setOption(data[2]);

                }
            }
            return option;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<OptionDTO> getAllOption() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<OptionDTO> optionList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    OptionDTO option = new OptionDTO();
                    option.setOid(data[0]);
                    option.setQid(data[1]);
                    option.setOption(data[2]);
                    optionList.add(option);

                }
            }

            return optionList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

    public static boolean deleteOption(String oid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(oid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(oid);
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
