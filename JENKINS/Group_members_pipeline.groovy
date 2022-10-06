Group members pipeline:
syntax:

pipeline {
	agent any
		stages{
			stage('1-Team3-Group5'){
				steps{
					echo "Group members"
				}
			}
			stage('2-Christiana Gabriels'){
				steps{
					echo "member"
				}
			}
			stage('3-Wasiu Lawal'){
				steps{
					echo "member"
				}
			}
			stage('4-Maxwell Chinedu'){
				steps{
					echo "Lead"
				}
			}
			stage('5-Chima Ikemelu'){
				steps{
					echo "member"
				}
			}
			stage('6-Tunde Onafowokan'){
				steps{
					echo "member"
				}
			}
			stage('7-Gregory Rotilli'){
				steps{
					echo "member"
				}
			}
			stage('8-Chizoba'){
				steps{
					echo "member"
				}
			}
			stage('9-Valentine Erondu'){
				steps{
					echo "member"
				}
			}
		}
	}