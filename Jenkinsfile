pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven'
    }

    environment {
        SPRING_PROFILES_ACTIVE = 'test'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/FIRASING/prjfoyer.git'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests with Spring profile = test (H2 database)'
                sh 'mvn clean test'
            }
        }

        stage('Build') {
            steps {
                echo 'Building Spring Boot application'
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'CI pipeline SUCCESS ✅'
        }
        failure {
            echo 'CI pipeline FAILED ❌'
        }
    }
}
