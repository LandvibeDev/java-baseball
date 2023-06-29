package baseball;

import java.util.List;

public class ThreeDigitNumber {
	private int threeDigitNumber = 0;

	public ThreeDigitNumber(List<Integer> digitList) {
		int weight = 100;
		for (int digit : digitList) {
			threeDigitNumber += digit * weight;
			weight /= 10;
		}
	}

	public ThreeDigitNumber(int number) {
		threeDigitNumber = number;
	}

	public int getThreeDigitNumber() {
		return threeDigitNumber;
	}

	public boolean equals(ThreeDigitNumber threeDigitNumber) {
		if (this.threeDigitNumber == threeDigitNumber.getThreeDigitNumber()) {
			return true;
		}
		return false;
	}
}
