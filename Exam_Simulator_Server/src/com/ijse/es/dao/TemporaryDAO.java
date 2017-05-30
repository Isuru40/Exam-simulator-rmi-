/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dto.AnswerDTO;
import com.ijse.es.dto.TemporaryDTO;
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
public class TemporaryDAO {

    private static final File file = new File("./src/com/ijse/es/files/Temporary.txt");

    public static boolean addTemporaryDetail(TemporaryDTO temporaryDTO) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += temporaryDTO.getQid() + "#";
        data += temporaryDTO.getOid() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(temporaryDTO.getQid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String qid) throws IOException, FileNotFoundException, ParseException {
        TemporaryDTO dTO = searchQID(qid);
        return dTO == null;
    }

    public static TemporaryDTO searchQID(String qid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        TemporaryDTO temporaryDTO = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(qid)) {
                    temporaryDTO = new TemporaryDTO();
                    temporaryDTO.setQid(data[0]);
                    temporaryDTO.setOid(data[1]);

                }
            }
            return temporaryDTO;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static boolean updateShedule(TemporaryDTO temporaryDTO) throws IOException, FileNotFoundException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(temporaryDTO.getQid())) {
                    fileData.add(line);
                } else {
                    String updateLine = "";
                    updateLine += temporaryDTO.getQid() + "#";
                    updateLine += temporaryDTO.getOid() + "#";

                    fileData.add(updateLine);

                }

            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(temporaryDTO.getQid());
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }
    public static boolean deleteFile(){
        if(file.exists()){
            file.delete();
            return  file.exists();
        }else{
            return false;
        }
    }
      public static List<TemporaryDTO> getAllAnswer() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<TemporaryDTO> answerList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    TemporaryDTO temporaryDTO=new TemporaryDTO();
                    temporaryDTO.setQid(data[0]);
                    temporaryDTO.setOid(data[1]);
                    answerList.add(temporaryDTO);

                }
            }

            return answerList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

}
