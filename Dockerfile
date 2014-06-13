# Use a trusted java base
FROM dockerfile/java

MAINTAINER Aiming Nie <aimingnie@gmail.com>

# we need this because the workdir is modified in dockerfile/java
WORKDIR /

# run the (java) server as the daemon user
USER daemon

# add spray server package
ADD lib/ /lib
ADD NLP/ /NLP
ADD project/build.properties /project/build.properties
ADD project/plugins.sbt	/project/plugins.sbt
ADD src/	/src
ADD views/	/views
ADD build.sbt /build.sbt

# run spray server command

# the server binds to 8080 - expose that port
EXPOSE 8080