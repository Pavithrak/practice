#!/bin/sh
sudo rm -rf /var/lib/tomcat6/webapps/recruit
echo "deleting the already deployed file"
sudo cp /home/pavithra/Documents/kavitha/RS/dest/recruit.war /var/lib/tomcat6/webapps/
echo "deployed recruit.war in tomcat"
sudo /etc/init.d/tomcat6 stop
echo "stopping tomcat"
sudo /etc/init.d/tomcat6 start
echo "starting tomcat"
