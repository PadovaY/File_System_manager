import java.util.*;

/**
 * this class represents a directory object
 */

public class Directory extends FileSystemMember {

    // data members
    private String name;
    private Date date;
    private HashSet<Directory> subDirs;
    private HashSet<File> filesInDir;         //using HashSets because every file/dir is unique
    private String parent;

    /**
     *  constructor
     * @param name
     */
    public Directory(String name, String parent) {
        super(name);
        this.name = name;
        this.date = new Date();
        this.filesInDir = new HashSet<File>();
        this.subDirs = new HashSet<Directory>();
        this.parent = parent;
    }
    ////////////////////////
    // --- functions --- //
    //////////////////////

    /**
     * add file to directory
     * @param file - added to directory
     */
    public void addFile(File file) {
        this.filesInDir.add(file);
    }

    /**
     * add sub dir to a directory
     * @param dir - directory to add to parent
     */
    public void addSubDir(Directory dir) {
        this.subDirs.add(dir);
    }


    // -------------------------- //
    // --- setters & getters --- //
    // -------------------------//

    /**
     * set name of dir
     * @param name - name to set for dir
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return date of creation of dir
     * @param date - date type
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * get name of dir
     * @return - string name of dir
     */
    public String getName() {
        return this.name;
    }

    /**
     * return the date the dir created
     * @return - Date type of date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * string representation for show system
     * @param depthSpace - how many spaces from left print will start
     */
    public void represent(int depthSpace){
        System.out.format("%"+depthSpace+"s|_ %s - \tcreated: %s;\n","",this.name, this.date);
    }



    /**
     *  get the sub directories
     * @return - the set of sub directory
     */
    public HashSet<Directory> getSubDirectories() {
        return subDirs;
    }

    /**
     *  get the files in directories
     * @return - the set of files in directory
     */
    public HashSet<File> getFilesInDir() {
        return filesInDir;
    }

    @Override
    public String getParent() {
        return this.parent;
    }
}




