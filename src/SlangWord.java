import java.util.List;

/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/16/2022 - 2:47 PM
 * Description: class to store slang words
 */
public class SlangWord {
    private String slang;
    private List<String> definition;

    /**
     * default constructor
     */
    public SlangWord(){
        this.slang = "";
        this.definition = null;
    }

    /**
     * constructor with parameters
     * @param slang: slang word
     * @param definition: definition of slang word
     */
    public SlangWord(String slang, List<String> definition) {
        this.slang = slang;
        this.definition = definition;
    }

    /**
     * copy constructor
     * @param slangDictionary: slangDictionary object
     */
    public SlangWord(SlangWord slangDictionary){
        this.slang = slangDictionary.slang;
        this.definition = slangDictionary.definition;
    }

    /**
     * get slang word
     * @return slang word
     */
    public String getSlang() {
        return slang;
    }

    /**
     * set slang word
     * @param slang: slang word
     */
    public void setSlang(String slang) {
        this.slang = slang;
    }

    /**
     * get definition of slang word
     * @return definition of slang word
     */
    public List<String> getDefinition() {
        return definition;
    }

    /**
     * set definition of slang word
     * @param definition: definition of slang word
     */
    public void setDefinition(List<String> definition) {
        this.definition = definition;
    }
}
