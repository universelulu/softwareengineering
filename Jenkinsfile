pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 소스 코드 체크아웃
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // PowerShell을 사용하여 Java 파일들을 컴파일
                powershell '''
                Get-ChildItem -Path ./b635310/src/b635310 -Recurse -Include *.java | ForEach-Object {
                    $javaFile = $_.FullName
                    $className = $_.BaseName
                    $utf8Path = [System.Text.Encoding]::UTF8.GetString([System.Text.Encoding]::Unicode.GetBytes($javaFile))
                    Write-Host "Compiling $javaFile"
                    javac -d classes "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\hongs\\b635310\\src\\b635310\\Book.java"
                    javac -d classes "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\hongs\\b635310\\src\\b635310\\BookSearch.java"
                    javac -d classes "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\hongs\\b635310\\src\\b635310\\BookSearchTest.java"
                    javac -d classes "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\hongs\\b635310\\src\\b635310\\PerformanceTest.java"


                }
                '''
            }
        }
    }
}
