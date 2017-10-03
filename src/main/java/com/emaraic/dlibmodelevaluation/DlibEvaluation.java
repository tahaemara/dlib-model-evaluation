package com.emaraic.dlibmodelevaluation;

import au.com.bytecode.opencsv.CSVReader;
import com.emaraic.util.PairFileParser;
import com.emaraic.util.Vector;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taha Emara 
 * Website: http://www.emaraic.com 
 * Email : taha@emaraic.com
 * Created on: Oct 2, 2017
 */
public class DlibEvaluation {

    private static final String DATA_FILE_PATH = "data.csv";
    private static final String PAIRS_FILE_PATH = "pairs.txt";

    public LinkedHashMap<String, Vector> loadFacesData(String filepath) {
        LinkedHashMap<String, Vector> data = new LinkedHashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader(filepath), ',')) {
            List<String[]> rows = reader.readAll();
            double[][] faces = new double[rows.size()][128];
            for (int i = 0; i < rows.size(); i++) {
                for (int j = 0; j < 128; j++) {
                    faces[i][j] = Double.parseDouble(rows.get(i)[j]);
                }
                // we need to convert the format Adrien_Brody_0007.jpg to Adrien_Brody_7
                data.put(rows.get(i)[128].replace(".jpg", "").replaceAll("0+(?!$)", ""), new Vector(faces[i]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public int evaluateMatchedFaces(List<String> matched, LinkedHashMap<String, Vector> data) {
        int error = 0;
        for (String line : matched) {
            String[] datas = line.split("\t");
            Vector v1 = data.get(datas[0] + "_" + datas[1]);
            Vector v2 = data.get(datas[0] + "_" + datas[2]);
            if (null != v1 && null != v2) {
                double rs = v1.distanceTo(v2);
                if (rs > 0.6) {
                    error++;
                }
            }

        }

        return error;
    }

    public int evaluateMisMatchedFaces(List<String> mismatched, LinkedHashMap<String, Vector> data) {
        int error = 0;
        for (String line : mismatched) {
            String[] datas = line.split("\t");
            Vector v1 = data.get(datas[0] + "_" + datas[1]);
            Vector v2 = data.get(datas[2] + "_" + datas[3]);
            if (null != v1 && null != v2) {
                double rs = v1.distanceTo(v2);
                if (rs < 0.6) {
                    error++;
                }
            }
        }
        //System.out.println(error);

        return error;
    }

    public static void main(String[] args) {
        DlibEvaluation eval = new DlibEvaluation();
        PairFileParser file = new PairFileParser(PAIRS_FILE_PATH);
        LinkedHashMap<String, Vector> data = eval.loadFacesData(DATA_FILE_PATH);

        List<String> lines = file.readLines();
        List<String> matched = file.getMatchedLines(lines);
        List<String> mismatched = file.getMisMatchedLines(lines);
        
        int matchederror = eval.evaluateMatchedFaces(matched, data);
        int mismatchederror = eval.evaluateMisMatchedFaces(mismatched, data);
        
        System.out.println("Number of faces: " + data.size());
        System.out.println("Number of Tests: " + lines.size());
        System.out.println("Accurecy: " + (100.0 - ((matchederror + mismatchederror) * 100.0) / lines.size()));

    }

}
