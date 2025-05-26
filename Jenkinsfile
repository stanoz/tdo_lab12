pipeline {
    agent {
        docker { image 'stanoz03/custom-jenkins-build-agent:1.0.1' args '-u root' }
    }
    stage('test') {
        step('msg') {
            echo 'Hello World'
        }
    }
}