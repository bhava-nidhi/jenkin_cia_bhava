pipeline {
    agent any

    tools {
        maven 'Maven_3.9.11'
        jdk 'jdk-17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bhava-nidhi/jenkin_cia_bhava.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t jenkin_cia_bhava_app .'
                }
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8080:8080 jenkin_cia_bhava_app'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
