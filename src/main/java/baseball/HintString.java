package baseball;

public enum HintString {

    STRIKE("스트라이크 "), BALL("볼 "),NOTHING("낫싱 ");
    private final String value;
    HintString(String value){
        this.value = value;
    }
    public String getValue(){
        return value.toString();
    }
}
