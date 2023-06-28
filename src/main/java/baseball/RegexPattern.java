package baseball;

public enum RegexPattern {

	IS_NUMBER("[+-]?\\d*(\\.\\d+)?");

	private final String regexPattern;

	RegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}

	public String getRegexPattern() {
		return regexPattern;
	}
}
