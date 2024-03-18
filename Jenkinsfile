pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage('build maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ajeet-lab/jenkins-springboot-app.git']])
                sh 'mvn clean install'
            }
        }
        stage('build docker image'){
            steps {
                sh 'docker build -t ajeet9415/javaappjdk17:01 .'
            }
        }
        stage('push image to docker hub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwds', variable: 'dockerhubpwd')]) {
                sh 'docker login -u ajeet9415k@gmail.com -p ${dockerhubpwd}'
                }
                sh 'docker push ajeet9415/javaappjdk17:01'
            }
        }
        stage('deploy to k8s') {
            steps {
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yml', kubeconfigId: 'kube8configpwd')
                }
            }
        }
    }

}