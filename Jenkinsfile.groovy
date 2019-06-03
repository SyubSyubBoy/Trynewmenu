node {
    stage('clone') {
        echo 'clone start'
        git url: 'git@github.com:SyubSyubBoy/Trynewmenu.git', branch: 'master', credentialsId: 'github-auth'
    }
    dir('project') {
        stage('start') {
            echo 'build start'
        }
    }
}
