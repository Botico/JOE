#!/usr/bin/env bash

# Behold the hodge-podge installer!

set -e

RED="\033[1;91m"         # Red
BLUE="\033[1;34m"        # Blue
YELLOW="\033[1;33m"      # Yellow
NC="\033[0m"             # No Color

printf "[${BLUE}INFO${NC}] Welcome to the JOE installer script! Please answer a few of these questions to ensure that we install JOE correctly.\n"

printf "[${BLUE}INFO${NC}]${YELLOW} "
seq -s'-' 0 72 | tr -d '[:digit:]'
printf "${NC}\n"

printf "[${BLUE}INFO${NC}] What OS are you running?\n[${BLUE}INFO${NC}] MacOSX: 1\n[${BLUE}INFO${NC}] Windows: 2\n[${BLUE}INFO${NC}] Linux Based: 3\n"

printf "[${BLUE}INFO${NC}]${YELLOW} "
seq -s'-' 0 72 | tr -d '[:digit:]'
printf "${NC}\n"

printf "[${BLUE}INFO${NC}] "
read -p "Choice: " systemOS
printf "[${BLUE}INFO${NC}] To install JOE, please press enter."
read -p ""
printf "[${BLUE}INFO${NC}] We will now detect which programs you have installed.\n"

if ! [ -x "$(command -v java)" ]; then
	printf "${RED}[ERROR]${YELLOW} Java is not installed. Please install java. It is quite easy to install.\n        This is a great resource (It's called google): https://google.com\n${NC}"
	exit 1
elif ! [ -x "$(command -v mvn)" ]; then
    printf "${RED}[ERROR]${YELLOW} Maven is not installed. Please install maven. It is quite easy to install.\n        This is a great resource (It's called google): https://google.com\n${NC}"
    exit 2
fi

printf "[${BLUE}INFO${NC}] Updating CLASSPATH...\n"
export CLASSPATH=${CLASSPATH}:.
export CLASSPATH=${CLASSPATH}:./

printf "[${BLUE}INFO${NC}] Cleaning...\n"
mvn clean
printf "[${BLUE}INFO${NC}] Clean Installing...\n"
mvn clean install
printf "[${BLUE}INFO${NC}] Compiling project...\n"
mvn compile
printf "[${BLUE}INFO${NC}] Packing project...\n"
mvn package

printf "\n\n[${BLUE}INFO${NC}] Done! All the dependencies are now installed. You may run the file './target/classes/Core.class'.\n\n       Remember that you have to run from the JOE directory.\n\n"