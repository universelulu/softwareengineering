pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    // Git repository 클론
                    checkout([$class: 'GitSCM', 
                              branches: [[name: '*/main']], 
                              doGenerateSubmoduleConfigurations: false, 
                              extensions: [], 
                              submoduleCfg: [], 
                              userRemoteConfigs: [[credentialsId: 'softwareengineering', 
                                                    url: 'https://github.com/guraudrk/softwareengineering.git']]]) 
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    // Maven을 이용한 clean install
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Maven을 이용한 테스트 실행
                    sh 'mvn test'
                }
            }
            post {
                always {
                    // JUnit 테스트 결과 저장
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Performance Test') {
            steps {
                script {
                    // 성능 테스트 실행
                    bat 'start /B mvn exec:java -Dexec.mainClass="com.example.PerformanceTest"'
                }
            }
            post {
                always {
                    // 성능 테스트 결과 아카이브
                    archiveArtifacts artifacts: '**/performance-reports/**', allowEmptyArchive: true
                }
            }
        }
    }

    post {
        always {
            // 워크스페이스 정리
            cleanWs()
        }
    }
}
