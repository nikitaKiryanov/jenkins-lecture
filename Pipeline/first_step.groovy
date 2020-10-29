properties([disableConcurrentBuilds()])

try {

    err = null
    currentBuild.result = "SUCCESS"
    notifyBuild('STARTED')

    stage("Print") {
        parallel(
                hello: {
                    build job: "../hello",
                            parameters: [booleanParam(name: 'isUpper', value: true)]
                },
                person: {
                    build job: "../person",
                            parameters: [string(name: 'person', value: 'Nikita'),
                                         booleanParam(name: 'isUpper', value: true)]
                }
        )
    }


} catch (err) {
    currentBuild.result = "FAILED"
    throw err
} finally {
    if (currentBuild.result != 'ABORTED') {
        notifyBuild(currentBuild.result)
    }
}


def notifyBuild(String buildStatus = 'STARTED') {
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "*${buildStatus}*\n"
    def summary = "${subject} (${env.BUILD_URL}) by ${env.BUILD_USER}"

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
    } else if (currentBuild.result == 'SUCCESS') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }
    echo "${summary}";
    //slackSend(color: colorCode, message: summary, teamDomain: env.SLACK_TEAM, tokenCredentialId: env.SLACK_CREDS_ID, channel: env.SLACK_CHANNEL)
}
