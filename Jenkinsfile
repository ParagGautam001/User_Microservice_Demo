pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    environment {
        DOCKER_IMAGE = "paraggautam1/user-service:1.0"
    }

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/ParagGautam001/User_Microservice_Demo.git'
            }
        }

        stage('Build JAR') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD'
                )]) {
                    bat """
                    docker login -u %USERNAME% -p %PASSWORD%
                    docker push %DOCKER_IMAGE%
                    """
                }
            }
        }
    }
}
