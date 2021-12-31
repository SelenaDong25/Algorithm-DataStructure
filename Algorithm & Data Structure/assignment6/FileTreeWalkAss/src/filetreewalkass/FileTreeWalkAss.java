/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 6
 * XIN DONG ON June 1, 2020.
 */
package filetreewalkass;


public class FileTreeWalkAss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileTreeWalk test = new FileTreeWalk("C:\\LWTECH\\CSD335_ALGORITHM AND DATA STRUCTURE");
        
        System.out.println("Folder hierarchy list: ");
        System.out.println("========================");
        test.listAllFiles();
        System.out.println("========================END");
        
        String name = "project.xml";
        System.out.print("Searched files location: \n");
        System.out.println(test.findFiles(name));


        
        
    }
    
}
