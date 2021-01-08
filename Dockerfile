FROM maven:3.6.3-openjdk-11
#ADD src/main/docker /medusa_study
ADD src/main/docker /nvclouds_offical_dir
#容器中工作目录
WORKDIR /nvclouds_offical_dir
#root用户进入容器
USER root
#将本地jar包copy到容器根目录下
ADD target/nvclouds-official.jar /nvclouds-official.jar
#将本地启动脚本copy到容器中
ADD src/main/docker/run.sh /bin/run.sh
#授权脚本，否则无法执行
RUN chmod +x /bin/run.sh
EXPOSE 80
CMD ["/bin/run.sh"]