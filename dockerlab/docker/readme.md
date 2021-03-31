##执行下面命令构建基础镜像
# docker build -t oracle-server-jre:8u202 .

##测试基础镜像
#docker run -it --rm oracle-server-jre:8u202 sh
# java -version
# javac -version

##查找镜像ID
#docker images | grep oracle-server-jre
##保存镜像
#docker save [imageID] > oracle-server-jre.tar

##copy 镜像到宿主机后 load 并且打标签
#docker load -i oracle-server-jre.tar
#docker images|grep none
#docker tag 4f951de2d925 oracle-server-jre:8u202