# batch-demo
실행방법
1. BatchApplication 소스파일 내 # TEST # 부분 주석 해제 후 테스터 데이터를 args로 넘겨서 테스트 가능 
   - main함수 run 시켜서 실행
2. intellij 내 Terminal 창에서 아래 명령어를 실행하여 jar packaging 하기 
   - C:\workspace\batch-demo>mvnw install
3. target 폴더로 들어가서 아래 명령어 실행하여 jar 파일로 실행 가능
   - C:\workspace\batch-demo\target>java -jar batch-0.0.1-SNAPSHOT.jar ExampleBatchService 2

   

