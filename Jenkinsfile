pipeline {
    agent any

    stages {
        stage("Checkout") {
            steps {
                // 소스코드 체크아웃
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Java 소스 파일 목록을 나열
                bat 'dir /s /b b635310\\src\\b635310\\*.java > sources.txt'

                // 각 Java 소스 파일을 javac에 전달
                bat 'javac -encoding UTF-8 -d classes @sources.txt'
            }
        }
    }
}
