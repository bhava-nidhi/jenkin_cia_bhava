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

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t jenkin_cia_bhava .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat '''
                docker stop jenkin_app || true
                docker rm jenkin_app || true
                docker run -d -p 8081:8080 --name jenkin_app jenkin_cia_bhava
                '''
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
