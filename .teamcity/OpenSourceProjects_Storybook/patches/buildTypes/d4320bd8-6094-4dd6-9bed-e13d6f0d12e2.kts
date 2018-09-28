package OpenSourceProjects_Storybook.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = 'd4320bd8-6094-4dd6-9bed-e13d6f0d12e2' (id = 'OpenSourceProjects_Storybook_CliTestLatestCra')
accordingly, and delete the patch script.
*/
changeBuildType("d4320bd8-6094-4dd6-9bed-e13d6f0d12e2") {
    expectSteps {
        script {
            name = "Bootstrap"
            scriptContent = """
                yarn
                yarn bootstrap --core
            """.trimIndent()
            dockerImage = "andthensome/docker-node-rsync"
        }
        script {
            name = "Test"
            scriptContent = "yarn test-latest-cra"
            dockerImage = "andthensome/docker-node-rsync"
        }
    }
    steps {
        update<ScriptBuildStep>(1) {
            scriptContent = """
                #!/bin/bash
                set -e -x
                
                yarn test-latest-cra
            """.trimIndent()
        }
    }
}
