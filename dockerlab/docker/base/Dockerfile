FROM  docker.io/jeanblanchard/alpine-glibc

ADD jre8.tar.gz /usr/local/
ENV JAVA_HOME=/usr/local/jdk1.8.0_202
ENV CLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH=$PATH:$JAVA_HOME/bin