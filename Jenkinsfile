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
            steps{
                    dir('tdo_lab12_demo') {
                    sh 'mvn test'
                    junit 'target/surefire-reports/*.xml'
                    }
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true
            }
        }
    }
}
