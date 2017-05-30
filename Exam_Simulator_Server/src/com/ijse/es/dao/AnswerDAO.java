/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.AnswerDTO;
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
public class AnswerDAO implements SuperDaoController {

    private static final File file = new File("./src/com/ijse/es/files/Answer.txt");
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static boolean addAnswer(AnswerDTO answer) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += answer.getQid() + "#";
        data += answer.getOid() + "#";
        data += answer.getAnswer() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            lock.writeLock().lock();
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(answer.getQid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
            lock.writeLock().unlock();
        }

    }

    private static boolean isAvailable(String qid) throws IOException, FileNotFoundException, ParseException {
        AnswerDTO answer = searchAnswer(qid);
        return answer == null;
    }

    public static AnswerDTO searchAnswer(String qid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        AnswerDTO answer = null;
        try {
            lock.readLock().lock();
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(qid)) {
                    answer = new AnswerDTO();
                    answer.setQid(data[0]);
                    answer.setOid(data[1]);

                }
            }
            return answer;
        } finally {
            if (reader != null) {
                reader.close();
            }
            lock.readLock().unlock();
        }
    }

    public static List<AnswerDTO> getAllAnswer() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<AnswerDTO> answerList = new ArrayList<>();

        try {
            lock.readLock().lock();
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    AnswerDTO answer = new AnswerDTO();
                    answer.setQid(data[0]);
                    answer.setOid(data[1]);
                    answer.setAnswer(data[2]);
                    answerList.add(answer);

                }
            }

            return answerList;
        } finally {
            if (reader != null) {
                reader.close();

            }
            lock.readLock().unlock();

        }

    }

    public static boolean deleteAnswer(String qid) throws FileNotFoundException, IOException, ParseException {
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
                if (!data[0].equals(qid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(qid);
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

}
