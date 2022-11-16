import java.util.HashMap;
import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/16/2022 - 3:02 PM
 * Description: class to store slang words
 */
public class SlangWordList {
    private HashMap<String, List<String>> listSlang;

    /**
     * default constructor
     */
    public SlangWordList(){
        this.listSlang = new HashMap<>();
    }

    /**
     * set list slang
     * @param listSlang: list slang
     */
    public void setListSlang(HashMap<String, List<String>> listSlang) {
        this.listSlang = listSlang;
    }

    /**
     * add slang word to list
     * @param slangWord: slang word
     */
    public void addSlangWord(SlangWord slangWord){
        this.listSlang.put(slangWord.getSlang(), slangWord.getDefinition());
    }

    /**
     * update slang word
     * @param slangWord: slang word
     * @param newDefinition: new definition
     */
    public void updateSlangWord(SlangWord slangWord, List<String> newDefinition){
        this.listSlang.replace(slangWord.getSlang(), newDefinition);
    }

    /**
     * delete slang word
     * @param slangWord: slang word
     */
    public void deleteSlangWord(SlangWord slangWord){
        this.listSlang.remove(slangWord.getSlang());
    }

    /**
     * search slang word
     * @param slangWord
     * @return definition of slang word
     */
    public List<String> searchSlangWord(String slangWord){
        return this.listSlang.get(slangWord);
    }


    public void printSlangWordList(){
        for (String key : this.listSlang.keySet()) {
            System.out.println(key + ": " + this.listSlang.get(key));
        }
    }
}
