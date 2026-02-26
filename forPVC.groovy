pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "No build step needed for static frontend"
            }
        }

        stage('Test') {
            steps {
                echo "Add tests here if needed"
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy step goes here (Netlify, server, etc.)"
            }
        }
    }
}