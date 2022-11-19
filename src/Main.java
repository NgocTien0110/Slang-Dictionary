import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create by Đặng Ngọc Tiến
 * Date 11/15/2022 - 12:34 AM
 * Description: Main class
 */
public class Main {
    private static SlangWordList slangWordList;
    private static ArrayList<HistorySearch> historySearchList;
    public static void main(String[] args) {
        slangWordList = FileManagemer.readFile();
        historySearchList = new ArrayList<>();

//        slangWordList.printSlangWordList();

        // menu
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Search slang word");
            System.out.println("2. Search definition");
            System.out.println("3. Add new slang word");
            System.out.println("4. Delete slang word");
            System.out.println("5. Edit slang word");
            System.out.println("6. History search");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Search slang word");
                    System.out.print("Enter slang word: ");
                    scanner.nextLine();
                    String slangSearch = scanner.nextLine();
                    DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String time = (dft.format(now)).toString();
                    System.out.println(time);
                    HistorySearch history = new HistorySearch(" ", slangWordList.printSearch(slangSearch), time, slangSearch);
                    historySearchList.add(history);
                    System.out.println(slangWordList.printSearch(slangSearch));

                    break;
                case 2:
                    System.out.println("Search definition");
                    System.out.print("Enter definition: ");
                    scanner.nextLine();
                    String definitionSearch = scanner.nextLine();
                    ArrayList<String> listKey = slangWordList.searchDefinition(definitionSearch);
                    String result = "";
                    if(listKey.size() == 0){
                        result = "Not found";
                    }
                    else{
                        for(String s : listKey){
                            result += s + ", ";
                        }
                    }

                    dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    now = LocalDateTime.now();
                    time = (dft.format(now)).toString();
                    System.out.println(time);
                    HistorySearch history1 = new HistorySearch(" ", result, time, definitionSearch);
                    historySearchList.add(history1);
                    if(listKey != null){
                        for(String key : listKey){
                            System.out.println(slangWordList.printSearch(key));
                        }
                    }
                    else{
                        System.out.println("Not found");
                    }
                    break;
                case 3:
                    System.out.println("Add new slang word");
                    System.out.print("Enter slang word: ");
                    scanner.nextLine();
                    String slangWord = scanner.nextLine();
                    System.out.print("Enter definition: ");
                    String definition = scanner.nextLine();
                    ArrayList<String> listDefinition = new ArrayList<>();
                    listDefinition.add(definition);
                    if(slangWordList.printSearch(slangWord) != "Not found"){
                        System.out.println("Slang word already exists. \n ban muon overwrite hay duplicate ra 1 definition moi");
                        System.out.println("1. Overwrite");
                        System.out.println("2. Duplicate");
                        System.out.print("Enter your choice: ");
                        int choice1 = scanner.nextInt();
                        if(choice1 == 1){
                            slangWordList.overwriteSlangWord(slangWord, definition);
                        }
                        else{
                            slangWordList.addDefinition(slangWord, definition);
                        }
                    }
                    else{
                        slangWordList.addSlangWord(new SlangWord(slangWord, listDefinition));
                        System.out.println("Add successfully");
                    }
                    break;
                case 4:
                    System.out.println("Delete slang word");
                    System.out.print("Enter slang word: ");
                    scanner.nextLine();
                    String slangDelete = scanner.nextLine();
                    System.out.println("Are you sure you want to delete this slang word? (Y/N)");
                    String choiceDelete = scanner.nextLine();
                    if(choiceDelete.equals("Y")){
                        slangWordList.deleteSlangWord(slangDelete);
                        System.out.println("Delete successfully");
                    }
                    else{
                        System.out.println("Delete failed");
                    }
                    break;
                case 5:
                    System.out.println("Edit slang word");
                    System.out.print("Enter slang word: ");
                    scanner.nextLine();
                    String slangEdit = scanner.nextLine();
                    System.out.print("Enter definition: ");
                    String definitionEdit = scanner.nextLine();
                    slangWordList.editSlangWord(slangEdit, definitionEdit);

                    break;
                case 6:
                    System.out.println("History search");
                    for(HistorySearch h : historySearchList){
                        h.showHistorySearch();
                    }

                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 7);
            System.out.println("Hello world!");

    }

    public static void setHistorySearchList(ArrayList<HistorySearch> historySearchList) {
        Main.historySearchList = historySearchList;
    }
}