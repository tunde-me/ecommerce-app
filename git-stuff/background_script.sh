#!/bin/bash
#Author: Tunde
#Purpose: Code to run script in background mode
echo "Use bash -x <scriptname.sh> to run a script in debugging mode"
echo "This script will automate execution of a script in background mode."
echo "Use <fg(1)> or <fgPID> to recall a script from background to foreground"
echo "...PID: Process ID"
echo "nohup ./<scriptname.sh> to run a srcipt in network instability"
read -p "Please enter script name: " name
./$name&