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
                bat 'javac -d classes b635310/src/b635310/*.java' // Java 파일 컴파일
            }
        }
        stage('Test') { // 테스트 스테이지
            steps {
                bat 'java -cp classes YourTestClass' // 테스트 실행
            }
        }
        stage('Deploy') { // 배포 스테이지
            steps {
                bat 'scp -r classes user@server:/path/to/destination' // 배포 명령어 실행
            }
        }
    }
}
