package pattern.flyweight.sign;

public class SignInfo4Pool extends SignInfo {
    /** 外部状态  */
    private String key;
    
    public SignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
