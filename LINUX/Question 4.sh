#!/bin/bash
# Author: Team3.Group5:HealthApp
# This script is for o backup and archive all logs from /var/log/auth.log
echo "step 1: list all logs from the file:"
cat /var/log/auth.log 
echo "step 2: re-direct the output to the new file:"
echo "Group5.07-30-2022.txt"
cat /var/log/auth.log > Group5.07-30-2022.txt
echo "grep the new file from the directory"
ls | grep Group5.07-30-2022.txt
echo "Done!"
echo "step 3: transfer the new file to the remote server with provided credentials:"
Transfer the new file to remote server with the details: scp 
	#file name: Group5.07-30-2022.txt
	#destination IP address: 172.31.12.36 
	#Team3key.pem: ('team3key.pem' - see chat)
	#destination Username: team3
	#Destination Directory: /tmp/monitor
    #Command: scp Group5.07-30-2022.txt team3@172.31.12.36:/tmp/monitor
    