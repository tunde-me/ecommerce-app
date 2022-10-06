#!/bin/bash
#script to mount and unmount extra volume to ec2 instance
echo  "Welcome to Etech Consulting!!!"
echo "step1: creating a mount point at /mnt"
echo " "
read -p "Please enter your directory name for the mount point: " Team3.Group5:HealthApp
sudo mkdir /mnt/$dir
lsblk
echo " "
echo “step2: format the new drive”
sudo mkfs -t ext4 /dev/xvdf
echo " "
echo “step2: mount the new volume”
sudo mount /dev/xvdf /mnt/Team3.Group5:HealthApp
echo " "
echo “step4: check and verify that the extra disk has been mounted
lsblk
echo “check new data free space in new mount”
df -h /mnt/Team3.Group5:HealthApp
echo " "
echo “step5: add entry for new drive in 	/etc/fstab file”
 "/dev/xvdf /mnt/ Team3.Group5:HealthApp ext4  defaults  0 1" | sudo tee /etc/fstab
echo “to see if the mount was recorded:”
sudo vi /etc/fstab Team3.Group5:HealthApp
sudo cat /etc/fstab | grep $ Team3.Group5:HealthApp  

echo "Unmounting"
echo " "
sudo unmount /dev/xvfg mnt/Team3.Group5:HealthApp  







#!/bin/bash
#script to mount extra volume to ec2 instance
echo  "Welcome to Etech Consulting!!!"
echo "step1: creating a mount point at /mnt"
sleep 5
read -p "Please enter your directory name for the mount point: " /mnt/Team3.Group5:HealthApp 
sudo mkdir /mnt/<xvd..>
lsblk
sudo mkfs -t ext4 /dev/xvdf
sudo mount /dev/xvdf /mnt/Team3.Group5:HealthApp
lsblk #to check and verify that the extra disk has been mounted
echo "/dev/xvdf /mnt/Team3.Group5:HealthApp ext4  defaults  0 1" | sudo tee /etc/fstab
sudo cat /etc/fstab | grep $Team3.Group5:HealthApp  #to see if the mount was recorded




#original:
ebs volume script:
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
