/**
 * tester class to test FileSystem
 */
public class Tester {

    FileSystem fileSystem;

    public Tester(){
        this.fileSystem = new FileSystem();
    }


    public void pyramid(FileSystem fileSystem){
        fileSystem.addDir("root","dir0");
        for(int i =0; i<100; i++){
            fileSystem.addDir("dir"+i,"dir"+(i+1));

        }
    }

    public void add1000dirAndFiles(FileSystem fileSystem){
        for(int i=0; i<1000;i++){
            fileSystem.addDir("root","dir"+i);
            if(i%4 ==0){
                fileSystem.addFile("dir"+(i-1), "file"+i, i*i+i);
            }
        }

    }
    public void deleteAll (FileSystem fileSystem){
        for(int i=0; i<1000; i++) {
            fileSystem.delete("dir"+i);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); //start run time check

        Tester tester = new Tester();
        FileSystem fileSystem = tester.fileSystem;

        tester.add1000dirAndFiles(fileSystem);  //adds files and dirs
//        tester.pyramid(fileSystem);           //add sub dir to every dir
        tester.fileSystem.showFileSystem();
        tester.deleteAll(fileSystem);           //deletes every file member apart from root
        tester.fileSystem.showFileSystem();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;   //total run time
        System.out.println( "process took " + totalTime/Math.pow(10,9) + " sec ");
    }
}
