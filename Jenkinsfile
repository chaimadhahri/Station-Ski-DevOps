pipeline {
    agent any

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
                sh 'mvn sonar:sonar  -Dsonar.login=admin -Dsonar.password=sonar'
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
