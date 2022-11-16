/**
 * PACKAGE_NAME
 * Create by Đặng Ngọc Tiến
 * Date 11/16/2022 - 5:54 PM
 * Description: class to store history search
 */
public class HistorySearch {
    private String slang;
    private String definition;
    private String time;
    private String keyword;

    /**
     * constructor with parameters
     * @param slang: slang word
     * @param definition: definition of slang word
     * @param time: time search
     * @param keyword: keyword search
     */
    HistorySearch(String slang, String definition, String time, String keyword){
        this.slang = slang;
        this.definition = definition;
        this.time = time;
        this.keyword = keyword;
    }

    /**
     * get slang word
     * @return slang word
     */
    public String getSlang() {
        return slang;
    }

    /**
     * get definition of slang word
     * @return definition of slang word
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * get time search
     * @return time search
     */
    public String getTime() {
        return time;
    }

    /**
     * get keyword search
     * @return keyword search
     */
    public String getKeyword() {
        return keyword;
    }

}
