pipeline {
    agent any

    tools {
        // Global Tool Configuration에서 설정한 Git 툴의 이름을 여기에 입력하세요.
        git 'Git'
        // Maven의 경우에도 필요한 경우 추가할 수 있습니다.
        // maven 'Maven'
    }

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
                              userRemoteConfigs: [[credentialsId: 'Hongik-Test', 
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
                    
                    bat 'mvn test'
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
                    // 성능 테스트 실행 (Windows에서는 'bat' 사용)
                    bat 'mvn exec:java -Dexec.mainClass="com.example.PerformanceTest"'
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
