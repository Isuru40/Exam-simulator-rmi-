/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.ExamDTO;
import com.ijse.es.dto.LecturerDTO;
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
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author User
 */
public class ExamDAO implements SuperDaoController {

    private final static File file = new File("./src/com/ijse/es/files/Exam.txt");
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static boolean addExam(ExamDTO exam) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += exam.getEid() + "#";
        data += exam.getLecturerDTO().getLid() + "#";
        data += exam.getExamTitle() + "#";
        data += exam.getSubject() + "#";
        data += exam.getTime() + "#";
        data += exam.getDate() + "#";
        data += exam.getHardQ() + "#";
        data += exam.getMediumQ() + "#";
        data += exam.getEasyQ() + "#";
        data += exam.getBatch() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            lock.writeLock().lock();
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvalible(exam.getEid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
            lock.writeLock().unlock();
        }

    }

    private static boolean isAvalible(String eid) throws IOException, FileNotFoundException, ParseException {
        ExamDTO exam = searchExam(eid);
        return exam == null;
    }

    public static ExamDTO searchExam(String eid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bufferedReader = null;
        ExamDTO exam = null;
        try {
            //  lock.readLock().lock();
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(eid)) {
                    exam = new ExamDTO();
                    exam.setEid(data[0]);
                    LecturerDTO lecturerDTO = LecturerDAO.searchLecturer(data[1]);
                    exam.setLecturerDTO(lecturerDTO);
                    exam.setExamTitle(data[2]);
                    exam.setSubject(data[3]);
                    exam.setTime(data[4]);
                    exam.setDate(data[5]);
                    exam.setHardQ(Integer.parseInt(data[6]));
                    exam.setMediumQ(Integer.parseInt(data[7]));
                    exam.setEasyQ(Integer.parseInt(data[8]));
                    exam.setBatch(data[9]);
                }
            }
            return exam;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // lock.readLock().unlock();
        }
    }

    public static List<ExamDTO> getAllExam() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<ExamDTO> examList = new ArrayList<>();

        try {
            // lock.readLock().lock();
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    ExamDTO exam = new ExamDTO();
                    exam.setEid(data[0]);
                    LecturerDTO lecturerDTO = LecturerDAO.searchLecturer(data[1]);
                    exam.setLecturerDTO(lecturerDTO);
                    exam.setExamTitle(data[2]);
                    exam.setSubject(data[3]);
                    exam.setTime(data[4]);
                    exam.setDate(data[5]);
                    exam.setHardQ(Integer.parseInt(data[6]));
                    exam.setMediumQ(Integer.parseInt(data[7]));
                    exam.setEasyQ(Integer.parseInt(data[8]));
                    exam.setBatch(data[9]);
                    examList.add(exam);
                }
            }

            return examList;
        } finally {
            if (reader != null) {
                reader.close();

            }
            //  lock.readLock().unlock();

        }

    }

    public static boolean deleteExam(String eid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            lock.writeLock().lock();
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(eid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvalible(eid);
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
            lock.writeLock().unlock();
        }
    }

    public static boolean updateExan(ExamDTO exam) throws IOException, FileNotFoundException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(exam.getEid())) {
                    fileData.add(line);
                } else {
                    String update = "";
                    update += exam.getEid() + "#";
                    update += exam.getLecturerDTO().getLid() + "#";
                    update += exam.getExamTitle() + "#";
                    update += exam.getSubject() + "#";
                    update += exam.getTime() + "#";
                    update += exam.getDate() + "#";
                    update += exam.getHardQ() + "#";
                    update += exam.getMediumQ() + "#";
                    update += exam.getEasyQ() + "#";
                    update += exam.getBatch() + "#";

                    fileData.add(update);

                }

            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvalible(exam.getEid());
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
