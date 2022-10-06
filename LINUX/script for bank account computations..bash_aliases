#!/bin/bash
# Author: Engineer Chima
# This script is for bank account computations (to automate bank account balance after every withdrawal (starting with an initail balance of $20000)
echo " "
#Variables
atm="22334455"
pin="2255"
groupname="HealthApp"
bankname="Cfinance"
bal="20000"
echo " "
read -p "Welcome to Cfinance, Please enter your ATM number: " atmno
echo " " && sleep 1
if [[ "$atmno" -eq "$atm" ]];
        then echo "Welcome back $groupname, Your money is safe and sound"
else
        echo "Sorry my friend, this is not your bank" && exit 0
fi
echo " " && sleep 4
echo -n "Please enter your ATM pin: "
read -s atmpin
if [[ "$atmpin" -eq "$pin" ]];
        then echo "Access Granted"
else
        echo " "
        echo "my friend, thats a wrong pin, you have been kicked out?" && exit 0
        #"Wrong pin! Please remove your ATM card and consult your financial institution"
fi
echo " " && sleep 1
echo "Welcome $groupname to your Account Portal"
echo " " && sleep 4
bal="2000"
#"20000"
echo "your account balance is \$$bal"
echo " " && sleep 4
read -p "enter the amount you want to withdraw: \$" wdraw
echo " " && sleep 4
nbal="$[$bal-$wdraw]"
echo "you have successfully withdrawn \$$wdraw, on `date`"
echo "your new account balance is now \$$nbal"
sleep 4 && echo " "
echo "Here is a receipt of your transaction"
echo " " && sleep 4
echo "Hear ye, Hear ye, let it be known that"
echo "today `date`"
echo "The Account owner $groupname withdrew \$$wdraw"
echo "from the account with atm no. $atm"
echo "$groupname's begining balance was \$$bal"
echo "and now $groupname is left with the balance of \$$nbal"
sleep 2 && echo " "
echo "Thank you  for using $bankname, see you next time"