pipeline {
    agent {
        docker { image 'stanoz03/custom-jenkins-agent:1.0.1'; 
        args '-u root -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""' }
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
            sh 'mvn test'
            junit '**/target/reports/*.xml'
        }
    }
}
