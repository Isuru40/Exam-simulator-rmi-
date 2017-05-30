/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.ExamDTO;
import com.ijse.es.dto.ProgressDetailDTO;
import com.ijse.es.dto.StudentDTO;
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
public class ProgressDetailDAO implements SuperDaoController {

    private static final File file = new File("./src/com/ijse/es/files/ProgressDetail.txt");

    public static boolean addProgressDetail(ProgressDetailDTO progressDetail) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += progressDetail.getPid() + "#";
        data += progressDetail.getStudentDTO().getSid() + "#";
        data += progressDetail.getExamDTO().getEid() + "#";
        data += progressDetail.getPresentage() + "#";
        data += progressDetail.getDate() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(progressDetail.getPid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String pQid) throws IOException, FileNotFoundException, ParseException {
        ProgressDetailDTO progressDetail = searchProgressDetail(pQid);
        return progressDetail == null;
    }

    public static ProgressDetailDTO searchProgressDetail(String pid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        ProgressDetailDTO progressDetail = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(pid)) {
                    progressDetail = new ProgressDetailDTO();
                    progressDetail.setPid(data[0]);
                    StudentDTO studentDTO = StudentDAO.searchStudent(data[1]);
                    progressDetail.setStudentDTO(studentDTO);
                    ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                    progressDetail.setExamDTO(examDTO);
                    progressDetail.setPresentage(Double.parseDouble(data[3]));
                    progressDetail.setDate(data[4]);

                }
            }
            return progressDetail;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<ProgressDetailDTO> getAllProgressDetail() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<ProgressDetailDTO> progressDetailList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    ProgressDetailDTO progressDetail = new ProgressDetailDTO();
                    progressDetail.setPid(data[0]);
                    StudentDTO studentDTO = StudentDAO.searchStudent(data[1]);
                    progressDetail.setStudentDTO(studentDTO);
                    ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                    progressDetail.setExamDTO(examDTO);
                    progressDetail.setPresentage(Double.parseDouble(data[3]));
                    progressDetail.setDate(data[4]);
                    progressDetailList.add(progressDetail);

                }
            }

            return progressDetailList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

    public static boolean deleteProgressDetail(String pid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(pid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(pid);
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }

    public static ProgressDetailDTO searchProgressDetailsByEIDandSID(String eid, String sid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        ProgressDetailDTO progressDetail = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[1].equals(sid) && data[2].equals(eid)) {
                    progressDetail = new ProgressDetailDTO();
                    progressDetail.setPid(data[0]);
                    StudentDTO studentDTO = StudentDAO.searchStudent(data[1]);
                    progressDetail.setStudentDTO(studentDTO);
                    ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                    progressDetail.setExamDTO(examDTO);
                    progressDetail.setPresentage(Double.parseDouble(data[3]));
                    progressDetail.setDate(data[4]);

                }
            }
            return progressDetail;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<ProgressDetailDTO> getStudentProgressDetail(String sid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<ProgressDetailDTO> progressDetailList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[1].equals(sid)) {
                        ProgressDetailDTO progressDetail = new ProgressDetailDTO();
                        progressDetail.setPid(data[0]);
                        StudentDTO studentDTO = StudentDAO.searchStudent(data[1]);
                        progressDetail.setStudentDTO(studentDTO);
                        ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                        progressDetail.setExamDTO(examDTO);
                        progressDetail.setPresentage(Double.parseDouble(data[3]));
                        progressDetail.setDate(data[4]);
                        progressDetailList.add(progressDetail);
                    }
            }
        }

        return progressDetailList;
    }

    
        finally {
            if (reader != null) {
            reader.close();

        }

    }

}

}
