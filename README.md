# java-calculator
문자열 계산기 저장소 + 우아한 테크코스 Level1 - 첫 주 학습내용입니다.

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## Level 1 ) 학습 테스트

### String 클래스에 대한 학습 테스트

#### 요구사항 1

- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.

- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다

#### 요구사항 2

- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

#### 요구사항 3

- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.

- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.

- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

### Set Collection에 대한 학습 테스트

#### 요구사항 1

- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

#### 요구사항 2 

- [x] set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- [x] 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다. JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
  
#### 요구사항 3

- [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.

## Level 2 ) 단위 테스트 (계산기)

### 요구사항

- 다음 요구사항을 Junit을 활용해 단위 테스트 코드를 추가해 구현한다.
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 목록

- [x] 게임이 실행되는 메인메서드를 기준으로 (Application.java)
    - [x] 메인 메서드의 기본적인 예외처리만
- 게임을 담당하는 모델객체에서 전반의 과정을 담당한다. (GameModel.java) - 게임 모델은 각 클래스들에게 역할을 위임하기만 한다.
    - [x] 모델 클래스가 호출되면 입력클래스를 통해 사용자 입력을 받는다. (GameModel -> UserInput.java)
    - [x] 사용자 입력은 문자열을 통해 전체 문장으로 받는다.
        - 형식에 잘못된 입력
            - [x] 처음이 연산자거나, 연산자로 끝나거나 연산자가 이어서 나오거나
            - [x] 숫자나 연산자가 아닌 다른 문자가 있거나
            - [x] 공백을 두지 않았거나
        - 개발 순서
            - [x] 전체 문장으로 받고 (getNumberAndOperator)
            - [x] 스플릿으로 스트링 배열에 넣어준다 (checkInputError())
            - [x] 그 배열 각각이 숫자나 연산자 인지 확인한다. 
            - [x] 배열의 홀수번째가 연산자인지 테스트한다.
            - [x] 배열의 첫번째와 마지막이 숫자인지 확인한다.
    - [x] 사용자는 공백을 기준으로 문자열을 입력한다고 가정한다. ////
- 문자열 형태로 입력된 값을 값과 연산자를 분리하여야 한다. (Operator.java)
    - 입력받는 부분을 클래스로 분리하고, 
    - 연산자 처리하는 부분
        - Enum 
        - if else (지양해보자)
        - 담당 클래스를 따로 두는 것이 좋을까?
    - 입력값에서 연산자를 찾아내고, 찾아낸 연산자 및 수를 GameResult.java 로 위임
- 전체 결과값을 처리하는 일급컬렉션을 구현한다. (GameResult.java)
    - GameResult 클래스
    - plus
    - minus
    - multiply
    - divide
    - result return 