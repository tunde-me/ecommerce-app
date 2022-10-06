#!/bin/bash
#
#Purpose: This script will backup all the contents of /var/log/auth.log into a monitor.log file and move the new file into a remote server. 
#Author: Team3Group5

echo "Create backup file"

cat /var/log/auth.log > group5monitor.log
ls
scp -i scp.pem group5monitor.log ubuntu@172.31.95.185:/home/ubuntu
