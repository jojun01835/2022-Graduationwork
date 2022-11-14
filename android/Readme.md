### android 

## 안드로이드 관련해서 개발한 사항들을 적는곳 입니다 

9/18일 안드로이드 개발 55% 완료.

향후 개발 사항
<br>

| Week | 졸업작품 | 과제 | 내용 |
| ------ | -- | -- |----------- |
| 1주차 | ☑️ | ☑️ | 기본적인 사항 개발  |
| 2주차 | ☑️ | ☑️ | 세부 오류 수정 |
| 3주차 | ☑️ | ☑️ | 안드로이드 res 파일 추가 |
| 4주차 | ☑️ | ☑️ | 아두이노 코딩 |
| 5주차 | ☑️ | ☑️ | 안드로이드 추가사항 점검 |
| 6주차 | ☑️ | ☑️ | 안드로이드 개발 종료 및 아두이노 제작회의  |
| 7주차 | ☑️ | ☑️ | 아두이노 제품 제작 |
| 8주차 |  |  | 최종발표  |

<br>

## 10/1일 안드로이드 개발 경과

```c
/*btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add.class);
                startActivity(intent);
                finish();
            }
        });*/
```
오류발생 부분 주석처리함

## 10/7일 안드로이드 개발경과 

<img width = "30%" height = "30%" src="https://user-images.githubusercontent.com/73435598/201168606-704962c7-000e-4b40-bf00-c65e2866d5fb.PNG"/><img width = "30%" height = "30%" src="https://user-images.githubusercontent.com/73435598/201168649-bbe0009c-402e-4139-a7df-4cdd5af83b4c.png"/> 수정 후
 


## 10/15일

~~디자인 수정 이후 개인정보 수정이 안되는 문제발생 확인바람.~~
<br>10/16일 문제부분 수정했습니다 

## 10/21

게시판 조회수 기능 정상작동 및 코드 수정
```c
public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map<String, String> map = (Map) dataSnapshot.getValue();
                mainListView.setAdapter(listAdapter);

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Board board = snapshot.getValue(Board.class);

                    arr_uid.add(board.getUid());
                    arr_board_key.add(snapshot.getKey());

                    listAdapter.addItem(board.getTitle(), board.getDate(), board.getName(), board.getClick());

                }
            }
```
이 부분 수정했습니다

## 11/11

풀업하다가 잘못올려서 저장소를 실수로 지웠습니다 이전에 작성한 Readme파일로 다시 복구하긴 했으나 몇몇 기록은 손실되었습니다 죄송합니다...
<br> -조장 조준영-


## 11/12
<br>
11월 12일 변경사항
<img width = "30%" height = "30%" src="https://user-images.githubusercontent.com/73435598/201590883-467b5433-bd06-4095-a931-7eb346a7dcef.png"/><img width = "30%" height = "30%" src="https://user-images.githubusercontent.com/73435598/201590993-1fa0b305-fcae-42b3-814f-32f41d842aca.png"/><img width = "30%" height = "30%" src="https://user-images.githubusercontent.com/73435598/201591201-aec04a2d-c37b-414e-8195-4fe2efe7510d.png"/>
<br>
안드로이드 게시판 수정,삭제 버튼추가, 게시판 댓글기능 추가



## 기여 방법

1. 제 졸업작품 저장소를 포크합니다.
2. 명령어로 새 브랜치를 만드세요.
3. 명령어로 커밋하세요.
4. 명령어로 브랜치에 푸시하세요. 
5. 풀리퀘스트를 보내주세요.
