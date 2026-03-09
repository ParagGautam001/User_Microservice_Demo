pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                echo "Building application"
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests"
                sh './mvnw test'
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application"
                sh './mvnw package'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

    }
}
