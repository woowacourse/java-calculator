# java-calculator
문자열 계산기 미션 저장소

# 기능 목록
1. 숫자와 연산자로 이루어진 문자열 입력
2. 입력받은 식을 공백으로 분리해서 String 배열로 변환
     * [예외처리] 공백이 입력될 경우
     * [예외처리] 맨앞이나 맨뒤가 연산자 일 경우
     * [예외처리] 숫자 또는 연산자가 연속으로 나올 경우
     * [예외처리] 연산자가 ("+", "-", "*", "/") 외에 다른 기호가 입력되는 경우
     * [예외처리] 식 중간에 공백이 두칸 이상 입력되는 경우
3. String 배열에서 숫자와 연산자를 각각 다른 리스트로 분리
   * isInteger(val) == true : List<Ineger> numbers 에 저장
   * isInteger(val) == false : List<Operator> operators 에 저장
     * Operator enum 활용
4. operators 리스트를 순회하면서 각각의 연산자와 숫자의 연산을 수행
   * result 변수에 결과 누적하고 최종 출력

# 클래스 및 메서드 목록
1. [Class] InputView
    * [Method] input()  
    
2. [Class] OutputView
    * [Method] printInputMessage()
    * [Method] printOutputMessage()
    * [Method] printInputExceptionMessage(Exception e)  
    
3. [Class] InputException
    * [Method] checkException()
    * [Method] validateSpace(String[] inputs)
    * [Method] validateFirstAndLast(String[] inputs)
    * [Method] validateRepeat(String[] inputs)
    * [Method] validateOperators(String[] inputs)
    * [Method] isInteger(String value)  
    
4. [Class] StringCalculator
    * [Method] run()
    * [Method] initializeInputs()
    * [Method] calculate()  
    
5. [Enum] Operator
    * [Method] compute(double result, int number)
    * [Method] getEnumFromString(String sign)

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
