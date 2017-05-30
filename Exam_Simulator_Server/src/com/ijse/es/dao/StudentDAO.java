/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.es.dao;

import com.ijse.es.dao.factory.SuperDaoController;
import com.ijse.es.dto.ExamDTO;
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
public class StudentDAO implements SuperDaoController{

    private static final File file = new File("./src/com/ijse/es/files/Student.txt");

    public static boolean addStudent(StudentDTO student) throws IOException, FileNotFoundException, ParseException {
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        String data = "";
        data += student.getSid() + "#";
        data += student.getName() + "#";
        data += student.getGender() + "#";
        data += student.getBatchID() + "#";

        BufferedWriter bufferedWritter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWritter = new BufferedWriter(fileWriter);
            bufferedWritter.write(data);
            bufferedWritter.newLine();

            return isAvailable(student.getSid());

        } finally {
            if (bufferedWritter != null) {
                bufferedWritter.close();
            }
        }

    }

    private static boolean isAvailable(String sid) throws IOException, FileNotFoundException, ParseException {
        StudentDTO student = searchStudent(sid);
        return student == null;
    }

    public static StudentDTO searchStudent(String sid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        StudentDTO student = null;
        try {

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("#");
                if (data[0].equals(sid)) {
                    student = new StudentDTO();
                    student.setSid(data[0]);
                    student.setName(data[1]);
                    student.setGender(data[2]);
                    student.setBatchID(data[3]);

                }
            }
            return student;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static List<StudentDTO> getAllStudent() throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<StudentDTO> studentList = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    StudentDTO student = new StudentDTO();
                    student.setSid(data[0]);
                    student.setName(data[1]);
                    student.setGender(data[2]);
                    student.setBatchID(data[3]);
                    studentList.add(student);

                }
            }

            return studentList;
        } finally {
            if (reader != null) {
                reader.close();

            }

        }

    }

    public static boolean deleteStudent(String sid) throws FileNotFoundException, IOException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(sid)) {
                    fileData.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(sid);
        } finally {
            if (bReader != null) {
                bReader.close();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }
      public static boolean updateStudent(StudentDTO  studentDTO) throws IOException, FileNotFoundException, ParseException {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            FileReader fileReader = new FileReader(file);
            bReader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                String[] data = line.split("#");
                if (!data[0].equals(studentDTO.getSid())) {
                    fileData.add(line);
                } else {
                    String update = "";
                    update += studentDTO.getSid() + "#";
                    update += studentDTO.getBatchID()+  "#";
                    update += studentDTO.getName() + "#";
                    update += studentDTO.getGender() + "#";
                    fileData.add(update);

                }

            }
            FileWriter fileWriter = new FileWriter(file);
            bWriter = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                bWriter.write(lineData);
                bWriter.newLine();
            }
            return isAvailable(studentDTO.getSid());
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
