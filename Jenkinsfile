pipeline {
    agent any
    environment {
        SONARQUBE_URL = 'http://192.168.33.10:9000'
        SONARQUBE_LOGIN = credentials('38414e8c-737e-459e-ad56-2024f4963f16')
    }

    stages {
        stage('GIT') {
            steps {
		echo "Getting Project from Git"
                git 'https://github.com/chaimadhahri/Station-Ski-DevOps.git'
            }
        }
        stage('Maven clean') {
            steps {
                sh 'mvn clean'
            }
        }
	 stage('Maven compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Maven sonar:sonar') {
            steps {
                sh "mvn sonar:sonar -Dsonar.host.url=${SONARQUBE_URL} -Dsonar.login=${SONARQUBE_LOGIN}"
            }
        }
        stage('date système') {
            steps {
                script {
                    def currentDate = sh(script: 'date', returnStdout: true).trim()
                    echo "Date système : ${currentDate}"
                }
            }
        }
    }
}
