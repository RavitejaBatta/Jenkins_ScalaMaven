pipeline {
	agent any
	//agent { docker { image 'maven:3.6.3' } }
	environment{
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}

	stages{
		stage('Checkout') {
			steps{
				sh 'mvn --version'
				sh 'docker version'
				echo "Build"
				echo "$PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
			}
		}

		stage('Compile') {
        			steps{
        				sh 'mvn clean compile'
        			}
        		}

		stage('Test') {
			steps{
				sh 'mvn test'
			}
		}

		stage('scoverage') {
			steps{
				sh 'mvn scoverage:report'
			}
		}

		stage('Publish Static Code Analysis') {
                        	steps{
                        	step([$class: 'ScoveragePublisher',
                                     reportDir: 'target', reportFile: 'scoverage.xml'])

                        	step([$class: 'CheckStylePublisher', pattern: 'target/scalastyle-output.xml, target/scoverage-classes/scalastyle_config.xml']
                        	publishHTML([
                                        allowMissing: false,
                                        alwaysLinkToLastBuild: false,
                                        keepAll: true,
                                        reportDir: 'target/site/scoverage',
                                        reportFiles: '*.html',
                                        reportName: 'Scoverage HTML Report'
                                      ])
                        		}
        }
		/*stage('Build Docker Image') {
			steps{
				//docker build -t myjenkins/jenkinsmicroService:$env.BUILD_TAG
				script{
					dockerImage = docker.build("jenkinservice/jenkinsmicroservice:$env.BUILD_TAG")
				}
			}
		}

		stage('Push Docker Image') {
			steps{
				script{
                    docker.withRegistry('','dockerhub'){
					dockerImage.push();
					dockerImage.push('latest');
					}
				}
			}
		}*/
	}
    post{
        always{
			echo 'I run always'
		}
		success{
			echo 'I run when you are success'
		}
		failure{
			echo 'I run when you fail'
		}
		//unstable: When the test failure happens
	}
}
