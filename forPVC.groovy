pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                Checkout SCM
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t aripranchi/2023bcs0051 .'
            }
        }

        stage('Login Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                }
            }
        }

        stage('Push Image') {
            steps {
                sh 'docker push aripranchi/2023bcs0051'
            }
        }
    }
}