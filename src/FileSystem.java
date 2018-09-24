import java.util.*;

/**
 * this class represents a File system object
 */

public class FileSystem {

    String FILE = "File";
    String DIRECTORY = "Directory";

    //data members
    //the "main" directory that contains whole files and directories.
    private Directory root;

    // the directories and files in the file system
    private HashMap<String, FileSystemMember> membersHashMap = new HashMap<>();


    /**
     * constructor
     */
    public FileSystem() {
        this.root = new Directory("root", null);
        this.membersHashMap.put(root.getName(), root);
    }


    ////////////////////////
    // --- functions --- //
    ///////////////////////

    /**
     * add file to certain directory
     *
     * @param parentDirName - directory of the file
     * @param fileName      - file name
     * @param fileSize      - file size
     */
    public boolean addFile(String parentDirName, String fileName, int fileSize){
        Directory parent = (Directory)membersHashMap.get(parentDirName);
        if (parent == null) {
            return false; // no such directory
        }
        File newFile = createFile(fileName, fileSize);
        //add file to dir
        parent.addFile(newFile);
        newFile.setParent(parentDirName);
        membersHashMap.put(fileName, newFile);
        return true;
    }


    /**
     * add directory to an exists one
     * @param parentDirName - directory name of parent
     * @param dirName       - new directory name
     */
    public boolean addDir(String parentDirName, String dirName) {
        Directory parent = (Directory)membersHashMap.get(parentDirName);
        if (parent == null) {
            return false; // no such directory
        }

        Directory dirObj = createDir(dirName, parentDirName);
        parent.addSubDir(dirObj);
        membersHashMap.put(dirName, dirObj);
        return true;
    }


    /**
     * deletes a file or directory based on the name
     * @param name
     */
    public boolean delete(String name) {
        //get the object
        FileSystemMember fileSystemMember = membersHashMap.get(name);
        if (fileSystemMember == null) {   //no such object
            System.err.println("no such file or directory");
            return false;
        }

        //get the type of the member by name
        String typeOf = fileSystemMember.getClass().getName();
        if (typeOf.equals(DIRECTORY)) {      //if directory make recursive deletion
            Directory dir = (Directory) fileSystemMember;
            deleteDir(dir);
            return true;
        }
        deleteFile((File)fileSystemMember);
        return true;
    }

    /**
     * delete directory and its content
     * @param dir - directory to remove
     */
    private void deleteDir(Directory dir) {
        //iterative delete of sub-folders
        while (dir.getSubDirectories().size() != 0) {
            for(Directory subDir: dir.getSubDirectories()){
                delete(subDir.getName());
            }
        }
        for(File file: dir.getFilesInDir()){    //delete files in folder
            deleteFile(file);
        }

        //delete directory from both repositories
        Directory parent = (Directory) membersHashMap.get(dir.getParent());
        parent.getSubDirectories().remove(dir);
        membersHashMap.remove(dir.getName());
        }

    /**
     * deletes a file
     * @param file - file to delte
     */
    private void deleteFile(File file){
        //get parent of file
        Directory parent = (Directory)membersHashMap.get(file.getParent());
        //remove from both repositories
        parent.getFilesInDir().remove(file);
        for(File file1 : parent.getFilesInDir()){
            System.out.println(file1.getName());
        }
        membersHashMap.remove(file.getName());
    }


    /**
     * print the file system with hierarchy and details
     */
    public void showFileSystem() {
        System.out.println("___");
        printSystem(this.root, 1);
        System.out.println("---//end");
    }




    /**
     * print each level of the system
     * @param dir - directory level to print
     */
    public void printSystem(Directory dir, int i) {
        dir.represent(i);
        for(File file : dir.getFilesInDir()){
            file.represent(i+3);
        }
        for(Directory subDir: dir.getSubDirectories()){
            printSystem(subDir, i+3);
        }

    }


    /**
     * create new file object
     * @param name - file name
     * @param size - size name
     * @return the new file object
     */
    public File createFile(String name, long size) {
        File newFile = new File(name, size);
        return newFile;
    }


    /**
     * create new file object
     *
     * @param name - file name
     * @param parent - parent name
     * @return the new file object
     */
    public Directory createDir(String name, String parent) {
        Directory newDir = new Directory(name, parent);
        return newDir;
    }

}

