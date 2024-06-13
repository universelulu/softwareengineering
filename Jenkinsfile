pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Git 저장소를 클론합니다. 이 저장소는 소프트웨어공학 2024년 1학기의 과제에 쓰인 저장소입니다.
                git url: 'https://github.com/guraudrk/softwareengineering.git', branch: 'main', credentialsId: 'softwareengineering'
            }
        }
        stage('Build') {
            steps {
                // MAVEN을 통해 프로젝트를 빌드합니다..
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // JUnit 테스트를 실행합니다.
                sh 'mvn test'
            }
            post {
                always {
                    // JUnit의 테스트 결과를 보고합니다.
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Performance Test') {
            steps {
        script {
            // 성능 테스트를 실행합니다. nohup 대신 PowerShell의 Start-Process를 사용합니다.
            bat 'start /B mvn exec:java -Dexec.mainClass="com.example.PerformanceTest"'
        }
    }
    post {
        always {
            // 성능 테스트 결과를 저장합니다.
            archiveArtifacts artifacts: '**/performance-reports/**', allowEmptyArchive: true
        }
    }
    }

    post {
        always {
            // 파이프라인이 끝난 후 항상 실행할 작업을 설정합니다.
            cleanWs()
        }
    }
}
