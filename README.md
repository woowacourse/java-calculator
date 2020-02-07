# java-calculator
문자열 계산기 미션 저장소



## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


#### 구현 기능 목록

**pack : view**

+ InputView.java

  + 사용자의 입력을 받는 메소드
    + 입력을 받을 때 공백 제거 필요

+ OutputView.java

  + 입력 안내 메시지, 입력 오류 안내 메시지, 결과 출력 메시지
  + 


**main**

+ Main.java

**pack : Controller**: 

+ InputException.java

 + 예외처리를 해야 하는 부분
   + 맨 앞뒤가 연산자
   + 숫자나 연산자가 연속으로 나오는 경우
   + 4개 연산자 외 다른 연산자가 나오는 경우
 + 숫자인지 숫자가 아닌지 판단하는 기능


+ StringCalculator.java
  + 사용자의 입력을 받고, 입력이 정상적인 경우 숫자부분과 연산자부분을 구분해서 각 리스트에 저장
  + 계산하는 기능

+ Operand.java  <= enum	 
