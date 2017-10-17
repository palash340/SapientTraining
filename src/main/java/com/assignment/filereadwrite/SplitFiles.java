package com.assignment.filereadwrite;

/**
 * Created by pjai60 on 10/10/2017.
 */
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Palash on 10/6/2017.
 */
public class SplitFiles {
    public void splitFileBySize(String filePath, long fileSizeInMB) throws IOException {

    }

    public List<String> splitFile(String filePath, String fileName, long splitNumber) throws IOException {
        List<String> splitList = new ArrayList<>();
        if(splitNumber == 0 ){
            Files.copy(Paths.get(filePath + File.separator + fileName), Paths.get(filePath + File.separator + "split"+ 1));
            splitList.add(filePath + File.separator + "split"+ 1);
            return splitList;
        }

        RandomAccessFile raf = new RandomAccessFile(filePath + File.separator + fileName, "r");
        long numSplits = splitNumber; //from user input, extract it from args
        long sourceSize = raf.length();
        long bytesPerSplit = sourceSize/numSplits ;
        long remainingBytes = sourceSize % numSplits;

        int maxReadBufferSize = 8 * 1024; //8KB
        for(int destIx=1; destIx <= numSplits; destIx++) {
            try(BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream( filePath + File.separator + "split."+destIx))) {
                splitList.add(filePath + File.separator + "split."+destIx);
                if (bytesPerSplit > maxReadBufferSize) {
                    long numReads = bytesPerSplit / maxReadBufferSize;
                    long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                    for (int i = 0; i < numReads; i++) {
                        readWrite(raf, bw, maxReadBufferSize);
                    }
                    if (numRemainingRead > 0) {
                        readWrite(raf, bw, numRemainingRead);
                    }
                } else {
                    readWrite(raf, bw, bytesPerSplit);
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        if(remainingBytes > 0) {
            try(BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(filePath + File.separator + "split."+(numSplits+1)))){
                readWrite(raf, bw, remainingBytes);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
            splitList.add(filePath + File.separator + "split."+numSplits+1);
        }
        raf.close();
        return splitList;
    }

    public void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if(val != -1) {
            bw.write(buf);
        }
    }

    public long findNumberOfParts(String filePath, String fileName, long requiredFileSizeInBytes){
        System.out.println("requiredFileSizeInBytes = " + requiredFileSizeInBytes);
        File f = new File(filePath + File.separator + fileName);
        long fileSize = f.length();
        System.out.println("fileSize = " + fileSize);
        long i = fileSize / requiredFileSizeInBytes;
        return i;
    }
}

