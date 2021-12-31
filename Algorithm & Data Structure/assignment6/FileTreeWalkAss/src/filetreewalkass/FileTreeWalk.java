/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 6
 * XIN DONG ON June 1, 2020.
 */
package filetreewalkass;

import java.io.File;

public class FileTreeWalk {
    private String pathStart;
    private File dir;
    
    /**
     * Constructor
     * @param pathname is a line of string represent the traverse folder location.
     */
    public FileTreeWalk(String pathname){
        pathStart = pathname;
        dir = new File(pathname);
    }
    /**
     * The method call private method and list all the files.
     */
    public void listAllFiles (){
        System.out.println(pathStart);
        StringBuilder sb = new StringBuilder();
        listFiles(pathStart, 1, sb);
        System.out.println(sb);
    }
    /**
     * The method recursively list all files in the folders and sub folders.
     * @param dirPath is folder path to start traverse.
     * @param level represent folder tree hierarchy level 
     * @param result store string object created during recursion
     */
    
    private void listFiles(String dirPath, int level, StringBuilder result) {
        dir = new File(dirPath);
        File[] firstLevelFiles = dir.listFiles();
        
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile : firstLevelFiles) {
                for (int i = 0; i < level; i++) {
                   result.append("\t");                    
                }
                
                if (aFile.isDirectory()) {
                    result.append("[").append(aFile.getName()).append("]").append("\n");
                    listFiles(aFile.getAbsolutePath(), level + 1, result);
                    
                } else {
                   result.append(aFile.getName()).append("\n"); 
                }
            }  
        }
    }

    /**
     * The method call private method and search if a file is in the folder. 
     * If yes,list the file with absolute location; if no, print "Not Found!" 
     * @param filename define the file name which will be searched.
     * @return the file with absolute location if it's found, otherwise return "Not Found!".
     */
    public String findFiles (String filename){
        dir = new File(pathStart);
        if (searchAllFiles(dir, filename) != null && searchAllFiles(dir, filename).length() > 0)
            return searchAllFiles(dir, filename);
        else
            return "Not Found!";
        }
    /**
     * The private method recursively traverse folder and search for a file name.
     * @param folder is the folder to be searched.
     * @param filename define the file name which will be searched.
     * @return searched result
     */
    private String searchAllFiles(File folder, String filename) {

        File[] fileNames = folder.listFiles();
        StringBuilder result = new StringBuilder();

        for (File file : fileNames) {
            if (file.isDirectory()) {
                String recursion = searchAllFiles(file, filename);
                
                if (recursion != null) {
                    result.append(recursion);                  
                }
            }
            if (file.getName().equalsIgnoreCase(filename)) {
                result.append(file.toString()).append("\n");
                        
            }
        }
        return result.toString();
    }

}
