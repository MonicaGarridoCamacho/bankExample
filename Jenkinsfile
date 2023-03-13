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
    stage ('Test') {
      steps {
        echo 'Test'
      }
    }
    stage ('Sonar') {
      steps {
        withSonarQubeEnv('SonarQube')
        sh 'mvn clean verify sonar:sonar \
            -Dsonar.projectKey=maven-jenkins-pipeline \
            -Dsonar.host.url=https://sonar-alpha.apps.cluster-rxzc9.rxzc9.sandbox3065.opentlc.com \
            -Dsonar.login=sqp_b25140813e891fb5d2021aa2fe04dc6eddfef58e'
      }
    }
  }
}