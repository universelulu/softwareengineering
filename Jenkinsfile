pipeline{
    agent any

    stages{
        stage("Checkout"){
            steps{
                // 소스코드 체크아웃
                checkout scm
            }
        }
        stage('Build'){
            steps{
                bat 'javac -encoding UTF-8 -d classes b635310/src/b635310/**/*.java'
            }
        }
    }
}
