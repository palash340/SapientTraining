package com.assignment.filereadwrite;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Palash on 10/9/17.
 */
public class SortFiles {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\main\\resources";
        String splitfilePattern = "split";
        final String fileName = "samplefile.txt";
        long maxFileSizeInMB = 1024 * 1024 * 100 ;
        SplitFiles splitFiles = new SplitFiles();
        long part =  splitFiles.findNumberOfParts(filePath, fileName , maxFileSizeInMB);
        splitFiles.splitFile(filePath , fileName, part);

        SortFiles sf = new SortFiles();
        DirectoryStream<Path> splitedFileList = sf.listSplitedFiles(filePath, splitfilePattern);
        sf.sortFile(splitedFileList);
        DirectoryStream<Path> sortedFileList = sf.listSortedFiles(filePath, splitfilePattern);
        sf.mergeSortedFiles(filePath , sortedFileList);
        //Delete unsorted files

    }

    public void sortFile(DirectoryStream<Path> fileList){
        fileList.forEach(filePath -> {
            try{
                // Read file and sort in-memory
                List<String> wordList = new ArrayList<String>();
                Files.lines(Paths.get(filePath.toUri())).forEach(inputLine -> {
                    String[] words = inputLine.split("\\s+");
                    for(String word : words)
                        wordList.add(word);
                });
                // Sort list
                Collections.sort(wordList);
                // Write to a temp file sorted file
                Path path = Paths.get(filePath.toAbsolutePath() + ".sorted");
                try(BufferedWriter writer = Files.newBufferedWriter(path)){
                    for(String word : wordList){
                        writer.write(word);
                        writer.newLine();
                    }
                    writer.flush();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        });
    }

    public void mergeSortedFiles(String filePath , DirectoryStream<Path> sortedFileList){
        Path path = Paths.get(filePath + File.separator + "SortedResult");
        // Read all files and store in Map
        TreeMap <String, BufferedReader> map = new TreeMap<>();

        sortedFileList.forEach(sortedFilePath -> {
            BufferedReader bufferedReader;
            try {
                bufferedReader = Files.newBufferedReader(Paths.get(sortedFilePath.toUri()));
                map.put(bufferedReader.readLine().trim(), bufferedReader);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        });
        System.out.println("map.size() = " + map.size());
        // Write to file
        BufferedReader br;
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            boolean flag = map.size() != 0;
            while(flag){
                Map.Entry<String, BufferedReader> firstKey = map.firstEntry();
                writer.write(firstKey.getKey());
                writer.newLine();
                writer.flush();
                // Update the key
                br = map.get(firstKey.getKey());
                String line = br.readLine();
                System.out.println("line = " + line);
                if(line != null){
                    map.put(line.trim(), br);
                }else{
                    System.out.println("-------------->" + firstKey.getKey());
                    br.close();
                }
                if(line == null || (line != null && !(line.trim().equals(firstKey.getKey()))))
                    map.remove(firstKey.getKey());
                if(map.size() == 0){
                    flag = false;
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }



    public DirectoryStream<Path> listSplitedFiles(String filePath, String filePattern) throws IOException {
        return Files.newDirectoryStream(Paths.get(filePath), path -> path.toString().startsWith(filePath + File.separator +  filePattern) && !(path.toString().endsWith(".sorted")));
    }

    public DirectoryStream<Path> listSortedFiles(String filePath, String filePattern) throws IOException {
        return Files.newDirectoryStream(Paths.get(filePath), path -> path.toString().startsWith(filePath + File.separator +  filePattern) && path.toString().endsWith(".sorted"));
    }
}
