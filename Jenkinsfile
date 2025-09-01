pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull code from Git
                git url: 'https://github.com/JanAlbar/Inventory.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Something failed...'
        }
    }
}