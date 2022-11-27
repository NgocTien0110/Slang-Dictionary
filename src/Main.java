import java.util.ArrayList;

/**
 * Create by Đặng Ngọc Tiến
 * Date 11/15/2022 - 12:34 AM
 * Description: Main class
 */
public class Main {
    public static SlangWordList slangWordList;
    public static ArrayList<HistorySearch> historySearchList;
    public static void main(String[] args) {
        slangWordList = FileManager.loadFile(1);
        new Home();
    }
}