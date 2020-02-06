### 클래스

* Calculator.java - 연산을 수행하는 Calculator 클래스
* InputView.java
* OutputView.java 
* Operator.java - 연산자 처리 Enum type 클래스
* Number.java - 숫자 처리 Enum type 클래스
* CalculatorInputString.java - Calculator 어플리케이션에서 입력받는 모든 문자열 타입
* CalculatorApplication.java - main method


### 기능 리스트

[] [기능] 문자열 입력 요구문 출력
[] [기능] 문자열을 입력받는다.
[] [예외] 공백만 입력되었을 경우
[] [기능] 입력 문자의 공백을 기준으로 분리한다.
[] [예외] 분리된 입력 문자에서 불필요한 공백을 제거한다.
[] [기능] enum type의 연산자로 입력 연산자를 검증한다.
[] [기능] enum type의 숫자로 입력 숫자의 범위를 검증한다.
[] [예외] 입력 문자열 중 연산자와 숫자의 순서가 올바르지 않은 경우
[] [기능] 입력된 문자 중 숫자를 정수형태로 변경한다.
[] [예외] 변경 중 발생하는 타입 에러 발생 시 재입력 메세지 출력
[] [기능] 연산을 수행한다.
[] [기능] 결과값을 출력한다.
[] [예외] 결과값의 범위가 상정한 출력 범위를 넘어설 경우

### 요구사항

```
사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
```

# java-calculator
문자열 계산기 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)