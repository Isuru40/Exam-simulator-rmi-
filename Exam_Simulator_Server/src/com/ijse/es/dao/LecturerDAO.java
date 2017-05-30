/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.LecturerDTO;
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
public class LecturerDAO implements SuperDaoController{
     private static final File file = new File("./src/com/ijse/es/files/Lecturer.txt");

    public static boolean addLecturer(LecturerDTO lecturer) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += lecturer.getLid() + "#";
        data += lecturer.getName() + "#";
        data += lecturer.getSpeciality() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(lecturer.getLid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String lid) throws IOException, FileNotFoundException, ParseException {
        LecturerDTO lecturer = searchLecturer(lid);
        return lecturer == null;
    }

    public static LecturerDTO searchLecturer(String lid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        LecturerDTO lecturer = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(lid)) {
                    lecturer = new LecturerDTO();
                    lecturer.setLid(data[0]);
                    lecturer.setName(data[1]);
                    lecturer.setSpeciality(data[2]);

                }
            }
            return lecturer;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<LecturerDTO> getAllLecturer() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<LecturerDTO> lecturerList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    LecturerDTO lecturer = new LecturerDTO();
                    lecturer.setLid(data[0]);
                    lecturer.setName(data[1]);
                    lecturer.setSpeciality(data[2]);
                    lecturerList.add(lecturer);

                }
            }

            return lecturerList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

    public static boolean deleteLecturer(String lid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(lid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(lid);
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
