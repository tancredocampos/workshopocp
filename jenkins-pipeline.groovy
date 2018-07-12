 node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'workshopocp', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'workshopocp')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}
