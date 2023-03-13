pipeline {
  agent any
  tools {
    maven 'maven-3.7' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
}