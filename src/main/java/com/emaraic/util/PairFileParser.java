package com.emaraic.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taha Emara 
 * Website: http://www.emaraic.com 
 * Email : taha@emaraic.com
 * Created on: Oct 2, 2017
 */
public class PairFileParser {

    private String PATH;
    private BufferedReader buffreader;
    private FileReader filereader;

    public PairFileParser(String PATH) {
        this.PATH = PATH;
    }

    public List<String> getMatchedLines(List<String> lines) {
        List<String> matched = new ArrayList<>();

        for (int i = 0; i < lines.size(); i += 600) {
            matched.addAll(lines.subList(i, i + 300));
        }

        return matched;
    }

    public List<String> getMisMatchedLines(List<String> lines) {
        List<String> matched = new ArrayList<>();

        for (int i = 300; i < lines.size(); i += 600) {
            matched.addAll(lines.subList(i, i + 300));
        }

        return matched;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try {
            filereader = new FileReader(PATH);
            buffreader = new BufferedReader(filereader);

            String sCurrentLine;

            while ((sCurrentLine = buffreader.readLine()) != null) {
                lines.add(sCurrentLine);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (buffreader != null) {
                    buffreader.close();
                }
                if (filereader != null) {
                    filereader.close();
                }
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
        lines.remove(0);
        return lines;
    }

    public static void main(String[] args) {
        PairFileParser p = new PairFileParser("pairs.txt");
        p.getMisMatchedLines(p.readLines());
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    

}
