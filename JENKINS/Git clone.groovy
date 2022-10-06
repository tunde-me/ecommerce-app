pipeline {
	agent any
	stages{
		stage('1-clone-Tunde'){
			steps{
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'b4cfb7ad-29c5-425e-93b1-81d2b86e355b', url: 'https://github.com/tunde-me/gp5-hook.git']]])
			}
		}
	}
}