node {
    stage('clone') {
        echo 'clone start'
        git 'git@github.com:SyubSyubBoy/Trynewmenu.git'
    }
    dir('project') {
        state('start') {
            echo 'build start'
        }
    }
}
