Monday,06-13-2022:
Jenkins-Master-Slave Configurations:
====================================
key points/features:
- It is use to configure distributed workload for jenkins cicd pipelines
- The master node direct the slave to runs different stages of the pipelines
- Master node uses ssh connection to reach the slave nodes
- Slave node can run a different operating system kernel from the master eg windows agent
- Jenkins slaves connect to the Jenkins master using the 'Java Network Launch Protocol'

Steps to configure Jenkins-Master-Slave:

step1: spin up two additional linux boxes in aws (can be ubuntu 0r redhat)

step2: On each of the two ec2 instances, do the following
- $ sudo apt update -y
- $ sudo apt install default-jre
- $ sudo adduser jenkins #make sure you assign a password same on both servers
- $ echo "jenkins  ALL=(ALL) NOPASSWD:ALL" | sudo tee /etc/sudoers.d/jenkins
- $ sudo vi /etc/ssh/sshd_config , Then enable password authentication for both servers

step3: Follow the video configurations to setup your Jenkins-Master-Slave
flow: manage-jenkins-->manage-node-->New-node

step4: On step3 above, record your server public ips and configure service account for Jenkins user 

step5: write a distributed jenkins pipeline codes for both agents as follows
syntax: to point a specific stage to an agent

agent {
  label {
    label '$label' #remember to record this during your jenkins UI settings
  }
} 

example:

pipeline{
  agent {
    label {
      label 'slave1'
    }
  }
  stages{
    stage('version-control'){
      steps{
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-id', url: 'https://github.com/etechDevops/jenkins-parallel-job.git']]])
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
        stage('sub-job3'){
            steps{
                echo 'action3'
            }
        }
      }
    }
    stage('codebuild'){
      agent {
        label {
          label 'slave2'
        }
      }
      steps{
        sh 'cat /etc/passwd'
      }
    }
  }
}

Important Jenkins plugins:
  1. job import plugin: used to import jenkins jobs from one jenkins server to another
  watch the video for practical part:

  2. thinBackup plugin: used to configure backup of a jenkins server to recover critical
   configurations files in case the jenkins server crashes
   note: this configs can be extended with nfs server for strong backups
   Follow the video for  the demo:

How can you copy a jenkins job from one server to another?
ans: from remote jenkins server do; 
  $ sudo chmod 777 /var/lib/jenkins/jobs
     from source jenkins server do;
  $ scp -i -r key $job $user@remote_jenkins_ip:/var/lib/jenkins/jobs


Jenkins Parametized pipeline jobs:
=================================
what is a parametized jenkins job?6t5frfrfrfrfr


  
