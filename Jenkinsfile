pipeline {
    agent {
        docker { image 'stanoz03/custom-jenkins-build-agent:1.0.1'; 
        args '-u root -v /var/run/docker.sock:/var/run/docker.sock --entrypoint=""' }
    }
    stages {
        stage('test') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
