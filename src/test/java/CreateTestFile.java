import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by pjai60 on 10/5/2017.
 */
public class CreateTestFile {
    public static void main(String[] args) throws IOException {
        CreateTestFile fp = new CreateTestFile();
        String newline = "\n";
        Random rand = new Random();
        long setSize = 1024 * 1024 * 1024;
        // Create file
        Writer output = null;
        File file = new File("src\\main\\resources\\samplefile.txt");
        output = new BufferedWriter(new FileWriter(file, true));
        output.write("");
        output.write(newline);

        long size = fp.getFileSize("src\\main\\resources\\samplefile.txt");

        while(size < setSize){
            output.write(RandomStringUtils.randomAlphanumeric(rand.nextInt(32)));
            output.write(" " + RandomStringUtils.randomAlphanumeric(rand.nextInt(32)));
            output.write(" " + RandomStringUtils.randomAlphanumeric(rand.nextInt(32)));
            output.write(newline);
            //flush for the file to get updated on size and content
            output.flush();
            size = fp.getFileSize("src\\main\\resources\\samplefile.txt");
            System.out.println(size + " bytes");
        }
    }

    public long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist");
            return -1;
        }
        return file.length();
    }
}
