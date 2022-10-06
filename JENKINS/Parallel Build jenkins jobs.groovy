Monday,06-06-2022:
=================
Jenkins Advanced topics:

1. Parallel Build jenkins jobs:
  The 'parallel' directive allows running multiple stages in parallel by virtue of wrapping the stages you want to run in parallel with it.
  syntax: make sure you install blue ocean plugins
  pipeline {
    agent any
    stages {
        stage('Compile & Build Binary') {
            parallel {
                stage('Build X') {
                     steps{
                      sh ' action build x'
                     }
                }
                stage('Build Y') {
                	steps{
                		sh 'action build y'
                	}
                      
                	}
                }
            }
        }
    }
}

pipeline{
  agent any
  stages{
    stage('actions1 and actions2'){
      parallel{
        stage('actions1'){
          steps{
            sh 'actions1'
          }
        }
        stage('actions2'){
          steps{
            sh 'actions2'
          }
        }
      }
    }
    stage('codebuild'){
    	steps{
    		sh 'echo codebuild stage'
    	}
    }
  }
}

2. Multibranch jenkins pipeline:

fundamentals:
What is Jenkins Multibranch pipeline ?
ans: multibranch pipeline job type lets you define a job where from a single git repository Jenkins will detect multiple branches and create nested jobs when it finds a Jenkinsfile.
- With a multibranch configurations , jenkins scan a single repository and when ever it finds a Jenkinsfile
it will automatically run a job for you.

Note: see the diagram for multibranch configurations

Jenkins Pipeline Vs. Multibranch Pipeline:

- Jenkins pipeline is a job configuration system that allows you to configure a pipeline of jobs which will be executed automatically on your behalf.
- A Jenkins pipeline can have multiple stages and each stage will be executed by a single agent, all running on a single machine or multiple machines.
- Multibranch pipeline allows you to split tasks out into branches and merge them together later.
- A multibranch pipeline is a pipeline that has multiple branches.
- Having a multibranch pipeline also allows you to have different environments for different branches.

Steps To Create A Jenkins Multibranch Pipeline:
  repo: https://github.com/etechDevops/multibranch-build.git

  step1: Open Jenkins home page (http://publicip:8080)

  step2: Enter Jenkins job name and choose the style as multibranch pipeline and click OK.

  step3: In the configure page, we need to configure only one thing – The Git Repo source. 
  note: Choose GitHub as Source as our Sample GitHub repo is hosted there.('click validate')

  step4: Analyse your jenkins jobs and identify any misconfigurations to avoid build failures

  Jenkinsfile1:
pipeline {
   agent any
   stages {
       stage('Build Code') {
           steps {
               sh "echo "Building Artifact"
           }
       }
      stage('Deploy Code') {
          steps {
               sh "echo "Deploying Code"
          }
      }
   }
}


Jenkinsfile2:
pipeline {
    agent any
    stages {
        stage('Main Branch Deploy Code') {
            when {
                branch 'main'
            }
            steps {
                sh 'echo "Building Artifact from Main branch"'
 
                sh 'echo "Deploying Code from Main branch"'
            }
        }
        stage('Develop Branch Deploy Code') {
            when {
                branch 'develop'
            }
            steps {
                sh 'echo "Building Artifact from Develop branch"'
                sh 'echo "Deploying Code from Develop branch"'
           }
        }
    }
}


pipeline {
    agent any
    tools {
        maven 'MAVEN_PATH'
        jdk 'jdk8'
    }
    stages {
        stage("Tools initialization") {
            steps {
                sh "mvn --version"
                sh "java -version"
            }
        }
        stage("Checkout Code") {
            steps {
                checkout scm
            }
        }
        stage("Check Code Health") {
            when {
                not {
                    anyOf {
                        branch 'master';
                        branch 'develop'
                    }
                }
           }
           steps {
               sh "mvn clean compile"
            }
        }
        stage("Run Test cases") {
            when {
                branch 'develop';
            }
           steps {
               sh "mvn clean test"
            }
        }
        stage("Check Code coverage") {
            when {
                branch 'develop'
            }
            steps {
               jacoco(
                    execPattern: '**/target/**.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src',
                    inclusionPattern: 'com/iamvickyav/**',
                    changeBuildStatus: true,
                    minimumInstructionCoverage: '30',
                    maximumInstructionCoverage: '80')
           }
        }
        stage("Build & Deploy Code") {
            when {
                branch 'master'
            }
            steps {
                sh "mvn tomcat7:deploy"
            }
        }
    }
 }
=============================================================================================================

pipeline{
  agent any
  stages{
  	stage('version-control'){
  		steps{
  			git checkout
  		}
  	}
    stage('parallel-job'){
      parallel{
        stage('sub-job1'){
          steps{
            echo 'action1'
          }
        }
        stage('sub-job2'){
          steps{
            echo 'action2'
          }
        }
      }
    }
    stage('codebuild'){
    	steps{
    		sh 'cat /etc/passwd'
    	}
    }
  }
}

techops-3050

pipeline{
	agent { 'master1'}
	tools { maven 'maven'
            Ansible 'ansible'
}
stages{
	agent node1
	stage('git-clone'){
		steps{
			action1
		}
	}
	agent node2
	stage('code-build'){
		steps{
			action2
		}
	}
}
}
=================================================================================================

pipeline{
	agent any 
	stages{
		stage('1-codecheckout'){
			steps{
				git clone
			}
		}
		stage('2-codebuild'){
			when {
				branch 'main'
			}
			steps{
				sh 'git version'
			}

		}
		stage('3-deployment'){
			when {
				branch 'develop'
			}
			steps{
				sh 'mvn deploy'
			}
		}
	}
}