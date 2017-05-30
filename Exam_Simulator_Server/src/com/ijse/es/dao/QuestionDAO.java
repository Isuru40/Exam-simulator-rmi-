/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author User
 */
public class QuestionDAO implements SuperDaoController {

    private static final File file = new File("./src/com/ijse/es/files/Question.txt");

    public static boolean addQuestion(QuestionDTO question) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += question.getQid() + "#";
        data += question.getQuestion() + "#";
        data += question.getSubject() + "#";
        data += question.getQuestionState() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(question.getQid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String qid) throws IOException, FileNotFoundException, ParseException {
        QuestionDTO question = searchQuestion(qid);
        return question == null;
    }

    public static QuestionDTO searchQuestion(String qid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        QuestionDTO question = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(qid)) {
                    question = new QuestionDTO();
                    question.setQid(data[0]);
                    question.setQuestion(data[1]);
                    question.setSubject(data[2]);
                    question.setQuestionState(data[3]);

                }
            }
            return question;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<QuestionDTO> getAllQuestion() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<QuestionDTO> questionList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    QuestionDTO question = new QuestionDTO();
                    question.setQid(data[0]);
                    question.setQuestion(data[1]);
                    question.setSubject(data[2]);
                    question.setQuestionState(data[3]);
                    System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + "" + data[3]);
                    questionList.add(question);

                }
            }

            return questionList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

    public static boolean deleteQuestion(String qid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
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
        }
    }

    public static String getLastQuestionID() throws IOException, FileNotFoundException, ParseException {
        String questionid = "Q1";
        List<QuestionDTO> questions = getAllQuestion();
        if (questions == null) {
            return questionid;
        } else {
            for (QuestionDTO question : questions) {
                questionid = question.getQid();
            }
            return questionid;
        }

    }

     public static HashMap<Integer, QuestionDTO> RandomQuestion(String subject) throws IOException, FileNotFoundException, ParseException {
        List<QuestionDTO> questionList = getAllQuestion();
        HashMap<Integer, QuestionDTO> questionHashSet = new HashMap<>();
        int i = 1;
        for (QuestionDTO questionList1 : questionList) {
            if (questionList1.getSubject().equals(subject)) {
                questionHashSet.put(i, questionList1);
                i++;
            }
        }
        return questionHashSet;
    }

}
