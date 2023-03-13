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
  }
}