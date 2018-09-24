import java.util.Date;

/**
 * this abstract class represents a File system member
 */
public abstract class FileSystemMember {

    /**
     * data members
     */
    private String name;
    private Date date;
    private long size;
    private String parent;

    /**
     * constructor of dir type
     * @param name - name of member
     */
    public FileSystemMember(String name){
        this.name = name;
        this.date = new Date();
    }

    /**
     * constructor of file type
     * @param name
     * @param size
     */
    public FileSystemMember(String name, long size){
        this.name = name;
        this.size = size;
        this.date = new Date();
    }

    /**
     * set date
     * @param date - date type
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * set name
     * @param name - String name of member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set parent of member
     * @param parent - String parent of member
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * get data
     * @return - date of create of file
     */
    public Date getDate() {

        return date;
    }

    /**
     * get name of member
     * @return - name of member
     */
    public String getName() {

        return name;
    }

    /**
     * get parent of member
     * @return - parent of member
     */
    public String getParent(){
        return this.parent;
    }

}

