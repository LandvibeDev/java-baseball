package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static String generateRandomNumber() {
		StringBuilder randomNumber = new StringBuilder();

		while (randomNumber.length() < 3) {
			String randomDigit = String.valueOf(Randoms.pickNumberInRange(1, 9));

			if (randomNumber.indexOf(randomDigit) == -1) {
				randomNumber.append(randomDigit);
			}
		}

		return randomNumber.toString();
	}

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
	}
}
