pipeline {
    agent any

    tools {
        git 'Git'
        maven 'Maven'
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
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    bat "${mvnHome}\\bin\\mvn clean install"
                }
            }
        }
        
        stage('Test') {
            steps {
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    bat "${mvnHome}\\bin\\mvn test"
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
                script {
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    bat "${mvnHome}\\bin\\mvn exec:java -Dexec.mainClass=\"com.example.PerformanceTest\""
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
