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
        
}
}
