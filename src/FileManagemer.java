import java.io.*;
import java.util.*;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/16/2022 - 4:12 PM
 * Description: ...
 */
public class FileManagemer {
    private static SlangWordList slangWordList;
    public static SlangWordList readFile(){
        File file = new File("slang.txt");
        BufferedReader br = null;
        boolean checkFile = file.exists();

        if(checkFile){
            SlangWordList slangWordList = new SlangWordList();
            try{
                br = new BufferedReader(new FileReader(file));
                String line = "";
                while((line = br.readLine()) != null){
                    String[] slang = line.split("`");
                    String[] listDefinition = slang[1].split("\\|");
                    List<String> definition = new ArrayList<>();
                    for(String s : listDefinition){
                        definition.add(s);
                    }
                    slangWordList.addSlangWord(new SlangWord(slang[0], definition));
                }
            }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("File exists");
            return slangWordList;
        }
        else{
            System.out.println("File not exists");
            return null;
        }
    }


    public static void main(String[] args) {
//        slangWordList = readFile();
//        slangWordList.printSlangWordList();
        System.out.println("Hello world!");
    }
}
