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
                withMaven(maven: 'Maven') {
                    bat 'mvn clean install'
                }
            }
        }
        
        stage('Test') {
            steps {
                withMaven(maven: 'Maven') {
                    bat 'mvn test'
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
                withMaven(maven: 'Maven') {
                    bat 'mvn exec:java -Dexec.mainClass="com.example.PerformanceTest"'
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
