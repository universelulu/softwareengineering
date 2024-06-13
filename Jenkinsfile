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
                bat 'find b635310/src/b635420 -name "*.java" -exec javac -encoding UTF-8 -d classes {} +'
            }
        }
    }
}
