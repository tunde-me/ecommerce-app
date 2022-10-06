shared library name= 'team2-test-library'
shared library repo = 'https://github.com/etechDevops/test-shared-library.git'
git tken= 

pipeline {
       agent any
       tools {
           maven 'maven'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh 'mvn --version'
                   sh 'java -version'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("to-test-maven") {
               steps {
                   sh 'mvn -v'
               }
           }
       }
}
==========================================================================================
def etech(x,y):
  z = x + y 
  return z 

  etech(3,4)

def etech(datatype datavariable){
  echo '$datavariable'
}

=====================================================================================
shared library = 'team2-saturday-library'
github shared repo = 'https://github.com/etechDevops/team2-shared-pipeline.git'

====================================================================================

def adder(x,y):
    z = x + y 
    return z 

    adder(3,4)

def call(datatype datavariable){
    functioncall '$datavariable'
}

def call(String repoUrl){
    echo 'git clone $repoUrl'
}

@library('$libraryname') _
$scriptname '$repoUrl'
=====================================================================================
shared library name = 'team3-shared-library'
shared library repo = 'https://github.com/etechDevops/team3-shared-library.git'
