pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                echo "Building application"
                sh 'chmod +x mvnw'
                sh './mvnw -B -q -DskipTests clean package'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

    }
}
