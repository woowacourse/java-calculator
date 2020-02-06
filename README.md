# java-calculator
문자열 계산기 미션 저장소

## 기능구현
1. value에 계산할 수식을 입력받는다.
    - 숫자와 연사자 사이를 공백으로 구분한다. ex) 2 + 3 * 5 / 2
2. 공백을 구분자로 하여 value를 split한 후, 숫자는 nums, 연산자는 opers 리스트에 저장한다.
3. 누적값과 연산자를 operation 함수에 전달하여 answer에 저장한다.

### 예외사항
#### 연산 이전
- [ ] 입력된 숫자가 숫자로만 이루어졌는지 확인한다.
- [ ] 숫자가 연속으로 입력된 경우 예외처리한다.
- [ ] 연산자가 연속으로 입력된 경우 예외처리한다.
- [ ] 0으로 나누었을 경우 예외처리한다.
- [ ] 소수가 입력된 경우 예외처리한다.
- [ ] 사칙연산 외의 다른 문자가 들어온 경우 예외처리한다.
#### 연산 이후
- [ ] 사용자가 입력한 숫자가 타입의 범위를 초과한 경우 예외처리한다.
- [ ] 계산 도중 누적값이 타입의 범위를 초과한 경우 예외처리한다.

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)