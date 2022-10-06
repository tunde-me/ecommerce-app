#!/bin/bash
#Purpose: This script is for system analysis
#Author: Group5
echo "Check disc free space: "
df -m
echo "Check memory free space: "
free
echo "For realtime memory usage: "
#top
echo "Check cpu statistics: "
lscpu
echo "Check uptime: "
uptime
echo "End of System Analysis"
