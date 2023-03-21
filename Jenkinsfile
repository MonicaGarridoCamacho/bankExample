pipeline {
  agent {
         node {
           label 'maven'
         }
  }
  stages {
    stage ('Code repo & code review') {
      steps {
        echo 'Code repo & code review'
      }
    }
    stage("Checkout") {
      steps {
        checkout scm
      }
    }
    stage ('Static code analysis') {
      steps {
        sh 'mvn clean verify sonar:sonar \
            -Dsonar.projectKey=maven-jenkins-pipeline \
            -Dsonar.host.url=https://sonar-devops.apps.cluster-kl7bv.kl7bv.sandbox3032.opentlc.com \
            -Dsonar.login=sqp_8e3b5f4a21055e4118632f1264cf5d0cd3076222'
      }
    }
    stage ('Build') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
  }
}
