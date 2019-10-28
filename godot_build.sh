#!/bin/bash
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
if [ -z $JAVA_HOME ]; then
	echo "*** Cannot find/set java 1.8 path"
	exit 1
fi
export PATH=${JAVA_HOME}/bin:$PATH

mvn clean package
