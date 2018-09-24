import java.util.*;

/**
 * this class represents a file object
 */

public class File extends FileSystemMember{

    /**
     * data memebers
     */
    private String name;
    private long size;
    private Date date;


    /**
     * constructor
     * @param name - name of file
     * @param size - size of file
     */
    public File(String name, long size){
        super(name,size);
        this.name = name;
        this.size = size;
        this.date = new Date();
    }


    // -------------------------- //
    // --- setters & getters --- //
    // -------------------------//

    /**
     * set name of file
     * @param name - to set to file
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * set size of file
     * @param size - to set
     */
    public void setSize(long size){
        this.size = size;
    }

    /**
     * set date
     * @param date - date of the creation of file
     */
    public void setDate(Date date){
        this.date = date;
    }


    /**
     * get name of file
     * @return - name of file
     */
    public String getName(){
        return this.name;
    }

    /**
     * return size of the file
     * @return - size of file
     */
    public long getSize(){
        return this.size;
    }

    /**
     * return the date the dir created
     * @return - Date type of date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * string representation for show system
     * @param depthSpace - how many spaces from left print will start
     */
    public void represent(int depthSpace){
        System.out.format("%"+depthSpace+"s|_ %s - \tsize: %d,\tcreated: %s;\n","",this.name, this.size,this.date);
    }
}
