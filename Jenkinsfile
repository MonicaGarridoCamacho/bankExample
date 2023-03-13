pipeline {
  agent {
         node {
           label 'maven'
         }
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    container(name: 'sonarqube-cli', shell: '/bin/bash') {
            stage('Sonar scan') {
                sh '''#!/bin/bash

                if ! command -v sonar-scanner &> /dev/null
                then
                    echo "Skipping SonarQube step, no task defined"
                    exit 0
                fi

                if [ -n "${SONARQUBE_URL}" ]; then
                  sonar-scanner \
                    -Dsonar.login=${SONARQUBE_USER} \
                    -Dsonar.password=${SONARQUBE_PASSWORD} \
                    -Dsonar.host.url=${SONARQUBE_URL} 
                else 
                    echo "Skipping Sonar Qube step"
                fi
                '''
            }
        }
  }
}