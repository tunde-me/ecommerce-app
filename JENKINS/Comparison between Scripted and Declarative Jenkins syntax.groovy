scripted pipeline:
syntax:

node {
	stage("This is a scripted pipeline") {
		echo "Scripted pipelines have 2 basic structures"
		sh "create a jenkins pipeline"
	}
	stage("Structural components") {
		echo "They consist of Nodes and Stages"
		sh "we need a Jenkinsfile"
	}
	stage("Build") {
		echo "Build scripted pipeline"
	}
}


declarative pipeline:
syntax:

pipeline {
	agent any 
	stages{
		stage('This is a declarative pipeline'){
			steps{
				echo "Modern syntax model for Jenkins"
				}
		}
		stage("Structurally different from scripted pipelines"){
			steps{
				echo "Scripted pipelines include steps and directives"
			}
		}
		stage("Build"){
			steps{
				echo "Build declarative pipeline"
			}
		}
	}
}