#!/bin/bash
#Purpose: This script is for system analysis
#Author: Group5
echo "Check disc free space: "
df -m
sleep 4
echo "Check memory free space: "
free
sleep 4
echo "For realtime memory usage: "
#top
sleep 4
echo "Check cpu statistics: "
lscpu
sleep 4
echo "Check uptime: "
uptime
echo "End of project"
