package listfiles;
import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("X:\\Winter2020\\csd436\\week3");
        ListFiles listFiles = new ListFiles();

        System.out.println("reading files before Java8 - Using listFiles() method");
        listFiles.listAllFiles(folder);
    }

    public void listAllFiles(File folder) {
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            System.out.println(file);
            if (file.isDirectory()) {
                listAllFiles(file);
            }
        }
    }
}
