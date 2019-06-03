node {
    stage('clone') {
        echo 'clone start'
        sh 'ssh -T git@github.com'
    }
    dir('project') {
        state('start') {
            echo 'build start'
        }
    }
}
