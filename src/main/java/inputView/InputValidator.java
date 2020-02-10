package inputView;

public class InputValidator {

	public boolean isNotValid(String input) {
		if (InputValidatorUtil.isNotValidWithinRegex(input) || InputValidatorUtil.validateAfterSplit(input)) {
			askAgain();
			return true;
		}
		return false;
	}

	private void askAgain() {
		System.out.println("잘못된 형식을 입력하셨습니다. 다시 입력해주세요.");
	}
}
