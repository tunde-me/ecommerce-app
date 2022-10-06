#!/bin/bash
# Author: Engineer Chima
# This script is for bank account computations
echo " "
atm="22334455"
pin="2255"
groupname="HealthApp"
bankname="Cfinance"
echo " "
read -p "Welcome to Cfinance, Please enter your ATM number: " atmno
echo " " && sleep 1
if [[ "$atmno" -eq "$atm" ]];
        then echo "Welcome back $groupname, Your money is safe and sound"
else
        echo "Sorry my friend, this is not your bank"
fi
echo " " && sleep 4
echo -n "Please enter your ATM pin: "
read -s atmpin
if [[ "$atmpin" -ne "$pin" ]]; then 
                echo "Sorry, wrong pin! Please re-enter your pin: "
        if [[ "$atmpin" -ne "$pin" ]]; then
                echo "Wrong pin! Please contact your financial institution. Exiting ..."
                exit
        else
                echo "validating pin....."     
                echo "Access Granted"
        fi



fi 
if [ $TEMP -gt 5 ]; then
        if [ $TEMP -lt 15 ]; then
                echo "The weather is cold."
        elif [ $TEMP -lt 25 ]; then
                echo "The weather is nice."
        else
                echo "The weather is hot."
        fi
else
        echo "It's freezing outside ..."
fi





else
  echo "Wrong pin!"
fi
echo " "
echo -n "Please re-enter your ATM pin: "
read -s atmpin
if [[ "$atmpin" -eq "$pin" ]]
then
  echo "Access Granted"
else
  echo "Wrong pin! Please contact your financial institution. Exiting ..."
fi

exit

echo " " && sleep 1
echo "Welcome $groupname to your Account Portal"
echo " " && sleep 4
bal="2000"
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