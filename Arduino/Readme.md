### Arduino

## 아두이노 관련해서 개발한 사항들을 적는곳 입니다 

11월/ 01일 아두이노 개발시작.

향후 개발 사항
<br>

| 회차 | 졸업작품 | 과제 | 내용 |
| ------ | -- | -- |----------- |
| 1회차 | ☑️ | ☑️ | 기본적인 사항 개발  |
| 2회차 | ☑️ | ☑️ | 하드웨어 설계 |
| 3회차 | ☑️ | ☑️ | 하드웨어 조립 및 테스트 |
| 4회차 | ☑️ | ☑️ | 코드 수정 및 유지보수 |
| 4회차 |  |  | 졸업작품 최종발표 |
<br>

## 1회차
<br>
아두이노 LED 회로도 및 하드웨어 제작
<img whith="30%" height="30%" src="https://user-images.githubusercontent.com/73435598/201585003-3809f414-b1eb-4be5-acfb-26a6d8a2b020.PNG"/><br>
아두이노 코드 작성<br>

```c
#define LED1  9 //LED핀 번호
#define LED2 10 

void setup(){
 pinMode(LED2, OUTPUT);
 pinMode(LED1, OUTPUT);
}
void loop(){
if(data == 'a'){  
      digitalWrite(LED2, HIGH);  //LED 켜기
      digitalWrite(LED1, HIGH);  //LED 켜기
  }
  
  else if(data == 'b'){  
      digitalWrite(LED2, LOW);  //LED 끄기
      digitalWrite(LED1, LOW);  //LED 끄기
      
  }
}
```
## 2회차
<br>
<img whith="30%" height="30%" src="https://user-images.githubusercontent.com/73435598/201587779-a33ac171-b384-4067-939c-c5c22049e490.PNG"/><br>
아두이노 코드 작성<br>

```c
#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd(0x27, 16, 2);
void setup()
{
Serial.begin(9600);  //하드웨어 시리얼 통신 준비
 lcd.init(); 		// initialize the lcd 
  lcd.backlight();
  lcd.setCursor(2,0);
  delay(5000);
  lcd.clear();
}
void loop()
{
float h = dht.readHumidity();
  float t = dht.readTemperature();

  if(isnan(h) || isnan(t)){
    Serial.println(F("Failed to read from DHT sensor!"));
    return;
  }

  Serial.print((int)t); Serial.print("*C ");
  Serial.print((int)h); Serial.println("%");

  //delay(1000);

  lcd.setCursor(0,0); // LCD Cursor 원점
  lcd.print("TEMP: "); // LCD에 "temp" 표시
  
  lcd.print(t,1); // 온도값 LCD로 출력
  lcd.print(" C"); // 온도 단위 표시
  lcd.setCursor(0,1); //LCD 커서 줄바꿈
  lcd.print("HUMI: "); //LCD 2번째 줄에 "humidity:" 출력

  lcd.print(h); //습도값 LCD에 출력
  lcd.print(" %"); //습도 단위 출력
}
```
## 3회차
<br>
<img whith="30%" height="30%" src="https://user-images.githubusercontent.com/73435598/201589008-98085a64-c654-4530-8b51-89d28231c13b.PNG"/><br>
아두이노 코드 작성<br>


## 기여 방법

1. 제 졸업작품 저장소를 포크합니다.
2. 명령어로 커밋하세요.
3. 명령어로 브랜치에 푸시하세요. 
4. 풀리퀘스트를 보내주세요.
