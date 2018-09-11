# JOE
Joe is a home assistant written in Java.

# Install:
To install JOE, please make sure you have bash. MacOSX and Debain/Ubuntu/Fedora/RedHat should already have bash. To do this run:
```
bash
```
If you do not have bash on windows, please use the following resource: https://bit.ly/2O8nIIa

If you do not have bash on mac, please run this:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew install bash
```
This will install homebrew (a great package manager), and then install bash.

To find the latest version of bash, go to http://ftp.gnu.org/gnu/bash/. If you do not have bash on Debain/Ubuntu, please run this:
```
sudo apt-get install build-essential
wget http://ftp.gnu.org/gnu/bash/bash-[insert version here].tar.gz
tar xf bash-[insert version here].tar.gz
cd bash-[insert version here]
./configure
make
sudo make install
```

To find the latest version of bash, go to http://ftp.gnu.org/gnu/bash/. If you do not have bash on Fedora/RedHat, please run:
```
sudo yum groupinstall “Development Tools” “Legacy Software Development”
wget http://ftp.gnu.org/gnu/bash/bash-[insert version here].tar.gz
tar xf bash-[insert version here].tar.gz
cd bash-[insert version here]
./configure
make
sudo make install
```

After installing bash (if needed), go ahead and run the JOE installer script.
