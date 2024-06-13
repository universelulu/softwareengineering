pipeline {
    agent any

    tools {
        git 'Git'   // Jenkins에서 설정한 Git Tool을 사용
        maven 'Maven'  // Jenkins에서 설정한 Maven Tool을 사용
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout([$class: 'GitSCM', 
                          branches: [[name: 'main']], 
                          userRemoteConfigs: [[credentialsId: 'Hongik-Test', 
                                                url: 'https://github.com/guraudrk/softwareengineering.git']]])
            }
        }
        
        stage('Build') {
            steps {
                // withMaven 블록 내부에서 bat 또는 sh 스텝을 사용하지 않고,
                // withMaven 블록 안에서 Maven 플러그인을 통해 명령을 실행하는 방식으로 수정
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    sh "${mvnHome}/bin/mvn clean install"
                }
            }
        }
        
        stage('Test') {
            steps {
                // withMaven 블록 내부에서 bat 또는 sh 스텝을 사용하지 않고,
                // withMaven 블록 안에서 Maven 플러그인을 통해 명령을 실행하는 방식으로 수정
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    sh "${mvnHome}/bin/mvn test"
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Performance Test') {
            steps {
                // withMaven 블록 내부에서 bat 또는 sh 스텝을 사용하지 않고,
                // withMaven 블록 안에서 Maven 플러그인을 통해 명령을 실행하는 방식으로 수정
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    sh "${mvnHome}/bin/mvn exec:java -Dexec.mainClass=\"com.example.PerformanceTest\""
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/performance-reports/**', allowEmptyArchive: true
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
