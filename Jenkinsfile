pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw -B -q clean compile'
            }
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
