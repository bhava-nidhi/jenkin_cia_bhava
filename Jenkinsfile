pipeline {
    agent any

    tools {
        maven 'Maven'  // The name you gave in Jenkins > Global Tool Configuration
        jdk 'JDK17'    // Adjust if your JDK is named differently
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bhava-nidhi/jenkin_cia_bhava.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('jenkin_cia_bhava_app')
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    sh 'docker run -d -p 8080:8080 jenkin_cia_bhava_app'
                }
            }
        }
    }
}
