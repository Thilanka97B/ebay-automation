pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    // Run Maven build
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run Selenium tests
                    sh 'mvn test'
                }
            }
        }
        stage('Allure Report') {
            steps {
                script {
                    // Generate Allure report
                    sh 'mvn allure:report'
                }
            }
        }
    }
    post {
        always {
            // Publish Allure report
            allure([
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}