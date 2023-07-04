1. Application 에서 실행
2. Game 클래스로 게임 실행 
   1. execution 실행
   2. 아래를 (playGame==1)이면 반복
      1. play 실행
      2. input 함수로 입력
      3. 입력 값을 judge 클래스를 이용해 채점
      4. 채점 결과 출력
         1. 정답 이면 게임 재시작 여부 입력(재시작 : 1, 종료 : 2)
         2. 오답이면 ii.b 부터 다시 실행



- Constants : 출력 메시지내용과 각 상수값을 저장
- ExceptionHandler : 예외처리 클래스
- Game : 게임 플레이를 위한 클래스 
  - execution() : 게임종료키 2를 누르기 전까지 반복
  - play() : 사용자의 입력을 받고 이를 채점, 채점 결과 출력
  - input() : 사용자의 입력을 받음
- Judge : 사용자의 입력을 채점하는 클래스
  - 생성자 : target 클래스를 생성
  - scoring() : 입력의 채점결과 저장
  - countStrike() : 스트라이크 점수 계산
  - countBall() : 볼 점수 계산
  - printScore() : 점수출력
- Target : 사용자가 맞춰야할 랜덤숫자 생성