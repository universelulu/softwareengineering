pipeline {
    agent any // 에이전트 설정

    stages {
        stage('Checkout') { // 체크아웃 스테이지
            steps {
                checkout scm // 소스 코드 체크아웃
            }
        }
        stage('Build') { // 빌드 스테이지
            steps {
                bat 'javac -encoding UTF-8 -d classes b635310/src/b635310/*.java' // Java 파일 컴파일
            }
        }
        stage('Test') {
 steps {
 // JUnit 5 테스트 실행을 위한 classpath 설정
 def classpath = "classes;lib/; 
path/to/eclipse/plugins/junit-platform-console-standalone1.7.1.jar" 
// JUnit 5 테스트 실행
 bat 'java -cp classes;lib/; path/to/eclipse/plugins/junitplatform-console-standalone-1.7.1.jar 
org.junit.platform.console.ConsoleLauncher --scan-classpath > 
test_results.txt' 
}
 }
 } 
post {
 always {
 // 테스트 결과 파일을 저장하기 위해 아카이브
 archiveArtifacts 'test_results.txt'
 }
 failure {
 echo ‘Build or test failed'
 }
 success {
 echo ‘Build and test succeeded'
 }
 }
}
