/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.ExamDTO;
import com.ijse.es.dto.ExamDetailsDTO;
import com.ijse.es.dto.QuestionDTO;
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
public class ExamDetailDAO implements SuperDaoController {

    private final static File file = new File("./src/com/ijse/es/files/ExamDetails.txt");
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static boolean addExamDetails(ExamDetailsDTO examDetails) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        if (!file.exists()) {
            boolean create = file.createNewFile();
        }
        String data = "";
        data += examDetails.getPid() + "#";
        data += examDetails.getpQid() + "#";
        data += examDetails.getExamDTO().getEid() + "#";
        data += examDetails.getQuestionDTO().getQid() + "#";
        data += examDetails.getDate() + "#";

        BufferedWriter bufferedWriter = null;
        try {
            lock.writeLock().lock();
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();

            return isAvalible(examDetails.getpQid());
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            lock.writeLock().unlock();
        }
    }

    private static boolean isAvalible(String pQid) throws IOException, FileNotFoundException, ParseException {
        ExamDetailsDTO examDetails = searchExamDetails(pQid);
        return examDetails == null;
    }

    public static ExamDetailsDTO searchExamDetails(String pQid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bufferedReader = null;
        ExamDetailsDTO examDetails = null;
        try {
            lock.readLock().lock();
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[1].equals(pQid)) {
                    examDetails = new ExamDetailsDTO();
                    ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                    QuestionDTO questionDTO = QuestionDAO.searchQuestion(data[3]);
                    examDetails.setPid(data[0]);
                    examDetails.setpQid(data[1]);
                    examDetails.setExamDTO(examDTO);
                    examDetails.setQuestionDTO(questionDTO);
                    examDetails.setDate(data[3]);

                }
            }
            return examDetails;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            lock.readLock().unlock();
        }
    }

    public static List<ExamDetailsDTO> getAllExamDetails() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<ExamDetailsDTO> examDetailsList = new ArrayList<>();

        try {
            lock.readLock().lock();
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    ExamDetailsDTO examDetails = new ExamDetailsDTO();
                    ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                    QuestionDTO questionDTO = QuestionDAO.searchQuestion(data[3]);
                    examDetails.setPid(data[0]);
                    examDetails.setpQid(data[1]);
                    examDetails.setQuestionDTO(questionDTO);
                    examDetails.setExamDTO(examDTO);
                    examDetails.setDate(data[3]);

                    examDetailsList.add(examDetails);
                }
            }

            return examDetailsList;
        } finally {
            if (reader != null) {
                reader.close();

            }
            lock.readLock().unlock();

        }

    }

    public static boolean deleteExamDetails(String pid) throws FileNotFoundException, IOException, ParseException {
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
                if (!data[1].equals(pid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvalible(pid);
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

    public static String getLastPaperID() throws IOException, FileNotFoundException, ParseException {
        String questionid = "P1";
        List<ExamDetailsDTO> paperList = getAllExamDetails();
        if (paperList == null) {
            return questionid;
        } else {
            for (ExamDetailsDTO paperList1 : paperList) {
                questionid = paperList1.getPid();
            }
            return questionid;
        }

    }

    public static List<ExamDetailsDTO> getGivenExam(String pid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<ExamDetailsDTO> examDetailsList = new ArrayList<>();

        try {
            lock.readLock().lock();
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[0].equals(pid)) {
                        ExamDetailsDTO examDetails = new ExamDetailsDTO();
                        ExamDTO examDTO = ExamDAO.searchExam(data[2]);
                        QuestionDTO questionDTO = QuestionDAO.searchQuestion(data[3]);
                        examDetails.setPid(data[0]);
                        examDetails.setpQid(data[1]);
                        examDetails.setQuestionDTO(questionDTO);
                        examDetails.setExamDTO(examDTO);
                        examDetails.setDate(data[3]);

                        examDetailsList.add(examDetails);
                    }
                }
            }

            return examDetailsList;
        } finally {
            if (reader != null) {
                reader.close();

            }
            lock.readLock().unlock();

        }

    }

}
