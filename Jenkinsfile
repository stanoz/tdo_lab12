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
                dir('tdo_lab12_demo'){
                    archiveArtifacts artifacts: 'target/surefire-reports/*.xml', fingerprint: true
                }
            }
        }
         stage('Build Docker Image') {
            steps {
                script {
                    def imageName = 'stanoz03/tdo_lab12_demo'
                    def image = docker.build("${imageName}:${env.BUILD_NUMBER}")
                    image.tag('latest')
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "docker push stanoz03/tdo_lab12_demo:${env.BUILD_NUMBER}"
                sh "docker push stanoz03/tdo_lab12_demo:latest"
            }
        }
    }
    post {
            always {
                script {
                    sh "docker rmi -f ${IMAGE_NAME}:${IMAGE_TAG} || true"
                    sh "docker rmi -f ${IMAGE_NAME}:latest || true"

                    sh "docker ps -a -q -f status=exited | xargs --no-run-if-empty docker rm"

                    sh "docker images -f dangling=true -q | xargs --no-run-if-empty docker rmi"
                }
            }
        }
}
