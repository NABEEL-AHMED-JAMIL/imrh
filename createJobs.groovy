pipelineJob('imrh-master-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/NABEEL-AHMED-JAMIL/imrh.git'
                    }
                    branch 'master'
                }
            }
        }
    }
}