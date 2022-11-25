import java.io.*;
import java.util.*;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/16/2022 - 4:12 PM
 * Description: ...
 */
public class FileManager {
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



    public static void saveHistory(HistorySearch historySearch){
        File file = new File("history.txt");
        BufferedWriter bw = null;
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(historySearch.getTime() + "`" + historySearch.getKeyword() + "`" + historySearch.getSlang() + "`" + historySearch.getDefinition());
            bw.newLine();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            try{
                bw.close();
            }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void loadHistory(){
        File file = new File("history.txt");
        BufferedReader br = null;
        Main.historySearchList = new ArrayList<>();
        try{
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = br.readLine()) != null){
                String[] history = line.split("`");
                HistorySearch historySearch = new HistorySearch(history[0], history[1], history[2], history[3]);
                Main.historySearchList.add(historySearch);
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }





}
