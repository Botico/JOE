# JOE

# About
Joe is a home assistant written in Java.

# Dependencies

    • Maven
    
    • Bash/Shell
    
    • Java

# Install:
## Bash
To install JOE, please make sure you have bash. MacOSX and Debain/Ubuntu/Fedora/RedHat should already have bash. To do this run:
```
bash
```
To get bash if you do not have it, please visit https://github.com/bminor/bash and clone. Then run:
```
./configure
make
make test <OPTIONAL>
make install
```
For more information, please go to the INSTALL or README file of the bash mirror.
## Java
To run JOE, you will need to have Java installed. To do this, please visit https://www.java.com/. You can then install. If you want to installer Java via command prompt/terminal, please follow the following instructions:
For MacOSX:
```
curl -v -j -k -L -H "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-macosx-x64.dmg > jdk-8u121-macosx-x64.dmg
hdiutil attach jdk-8u121-macosx-x64.dmg
sudo installer -pkg /Volumes/JDK\ 8\ Update\ 121/JDK\ 8\ Update\ 121.pkg -target /
diskutil umount /Volumes/JDK\ 8\ Update\ 121
rm jdk-8u121-macosx-x64.dmg
```
For Ubuntu:
```
sudo apt-get update
sudo apt-get install default-jre
sudo apt-get install default-jdk
```
For Windows:
```
echo "please install the installer or quit windows."
```
## Maven
If you want to run Joe, please make sure you have Maven (mvn). To install, please run
For MacOSX:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew install maven
```
For Ubuntu:
```
sudp apt-get update
sudo apt-get install maven
```
For Windows (install maven first: https://bit.ly/2MmJLcE):
```
tar xzvf apache-maven-3.5.4-bin.tar.gz
cd apache-maven-3.5.4-bin
setx path "%path%;./bin"
```
# Trouble Shooting:
    When running the install, it could raise some errors. One of these is a error while building. It complains about not           finding a library, or having it discontinued. This could be because you JAVA_HOME env variable is not set to 1.8. To fix       this, set your JAVA_HOME to the 1.8 Java Virtual Machine.
    
    If you run into other problems, feel free to contact me.
