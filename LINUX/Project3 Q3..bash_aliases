#!/bin/bash
#script to mount extra volume to ec2 instance
echo  "Welcome to Etech Consulting!!!"
echo "step1: creating a mount point at /mnt"
sleep 5
read -p "Please enter your directory name for the mount point: " dir 
sudo mkdir /mnt/$dir
lsblk
sudo mkfs -t ext4 /dev/xvdf
sudo mount /dev/xvdf /mnt/$dir
lsblk #to check and verify that the extra disk has been mounted
echo "/dev/xvdf /mnt/$dir ext4  defaults  0 1" | sudo tee /etc/fstab
sudo cat /etc/fstab | grep $dir  #to see if the mount was recorded
