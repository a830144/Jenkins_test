pipeline {

    //agent { label 'master_for_Epam' }
    agent any

    environment {

        PUBLIC_URL = '/isp'

    }

    parameters {

        string(name: 'BRANCH_GIT', defaultValue: 'develop')

        choice(name: 'ENVIRONMENT', choices: ['DEV', 'INT', 'QA', 'UAT', 'PROD'], description: 'Take ENV variable which will be used for deployment')

        booleanParam(name: 'DEPLOY_TO_FE', defaultValue: true)

        booleanParam(name: 'DEPLOY_TO_NEXUS', defaultValue: false, description: 'Enable deploying artifacts to Nexus artifactory storage')

        booleanParam(name: 'UNIT_TESTS', defaultValue: true, description: 'Enable Unit Tests of IC Front-end')

 

    }

    stages {

        stage('Export variables') {

            steps {

                script{

                    echo 'export variables'

                }                 

            }

        }

        stage('Startup and Build') {

            steps {

                script{
                  echo 'startup and build'

                }

            }

        }

        stage('Unit Tests of IC Front-end') {

            steps {

                script {
                    echo 'unit test'
                }

            }
           

        }

        stage('Deploy Frontend to first node of Apache') {
            steps {

                script{
                      echo 'Apache'
                }

            }

        }

        stage('Frontend deploy Artifacts to Nexus'){

            steps{
                    script{
                         echo 'nexus'
                                    
                    }

            }

        }

    }      

}
