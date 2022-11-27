import java.util.HashMap;
import java.util.*;

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

//    /**
//     * update slang word
//     * @param slangWord: slang word
//     * @param newDefinition: new definition
//     */
//    public void updateSlangWord(SlangWord slangWord, List<String> newDefinition){
//        this.listSlang.replace(slangWord.getSlang(), newDefinition);
//    }

    /**
     * delete slang word
     * @param slangWord: slang word
     */
    public void deleteSlangWord(String slangWord){
        this.listSlang.remove(slangWord);
    }

    /**
     * search slang word
     * @param slangWord
     * @return definition of slang word
     */
    public List<String> searchSlangWord(String slangWord){
        return this.listSlang.get(slangWord);
    }

    // test
    public String printSearch(String slangWord){
        String result = "";
        List<String> definition = this.listSlang.get(slangWord);
        if (definition != null){
            result = slangWord + " : " + definition.toString();
        }
        else {
            result = "Not found";
        }
        return result;
    }

    public ArrayList<String> searchDefinition(String slang){
        ArrayList<String> result = new ArrayList<>();
        slang = slang.toLowerCase();
        for(Map.Entry<String, List<String>> entry: listSlang.entrySet()){
            List<String> def = entry.getValue();
            for(String item : def){
                item = item.toLowerCase();
                if(item.contains(slang)){
                    result.add(entry.getKey());
                }
            }
        }
        if(result.size() != 0) return result;
        else return null;
    }

    public String getDefinitionString(String slang){
        String result = "";
        List<String> definition = this.listSlang.get(slang);
        if (definition != null){
            for(String item : definition) {
                result += item + ", ";
            }
        }
        else {
            result = "Not found";
        }
        return result;
    }

    public void printSlangWordList(){
        for(String key : this.listSlang.keySet()){
            String definition = "";
            for(String def : this.listSlang.get(key)){
                definition += def + ", ";
            }
            System.out.println(key + " : " + definition);
        }
    }

    public HashMap<String, List<String>> getListHashMap() {
        return listSlang;
    }

    public void setListHashMap(HashMap<String, List<String>> listHashMap) {
        this.listSlang = listHashMap;
    }
    public int getLength() {return listSlang.size();}

    public void addSlangWord(String slang, List<String> definition){
        this.listSlang.put(slang, definition);
    }

    public void overwriteSlangWord(String slang, List<String> definition){
        this.listSlang.replace(slang, definition);
    }

    public void duplicateSlangWord(String slang, List<String> definition){
        List<String> def = this.listSlang.get(slang);
        System.out.println(def);
        if(def != null){
            def.addAll(definition);
            this.listSlang.replace(slang, def);
        }
        else{
            this.listSlang.put(slang, definition);
        }
    }

//    public void overwriteSlangWord(String slangWord, String definition) {
//        List<String> def = new ArrayList<>();
//        def.add(definition);
//        this.listSlang.replace(slangWord, def);
//    }


    public void addDefinition(String slangWord, String definition) {
        List<String> def = this.listSlang.get(slangWord);
        def.add(definition);
        this.listSlang.replace(slangWord, def);
    }

//    public void editSlangWord(String slangEdit, String definitionEdit) {
//        List<String> def = new ArrayList<>();
//        def.add(definitionEdit);
//        this.listSlang.replace(slangEdit, def);
//    }

    public void editSlangWord(String slangEdit, List<String> definitionEdit) {
        this.listSlang.replace(slangEdit, definitionEdit);
    }

    public void randomSlangWord() {
        Random random = new Random();
        int index = random.nextInt(this.listSlang.size());
        int i = 0;
        for(String key : this.listSlang.keySet()){
            if(i == index){
                System.out.println(key + " : " + this.listSlang.get(key));
                break;
            }
            i++;
        }
    }


    public Map<String, List<String>> getListSlang() {
        return listSlang;
    }


}
