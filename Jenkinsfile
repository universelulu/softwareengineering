pipeline {
    agent any

    tools {
        // Jenkins Global Tool Configuration에서 설정한 Git 툴의 이름을 여기에 입력하세요.
        git 'Git'
        // Maven을 추가할 경우, Global Tool Configuration에서 설정한 Maven 툴의 이름을 입력하세요.
        // maven 'Maven'
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Git repository 클론
                checkout([$class: 'GitSCM', 
                          branches: [[name: 'main']], 
                          userRemoteConfigs: [[credentialsId: 'Hongik-Test', 
                                                url: 'https://github.com/guraudrk/softwareengineering.git']]])
            }
        }
        
        stage('Build') {
            steps {
                // Maven을 이용한 clean install
                withMaven(maven: 'Maven') {
                    bat 'mvn clean install'
                }
            }
        }
        
        stage('Test') {
            steps {
                // Maven을 이용한 테스트 실행
                withMaven(maven: 'Maven') {
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
                // 성능 테스트 실행
                withMaven(maven: 'Maven') {
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
