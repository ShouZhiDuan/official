FROM openjdk-11

#定义变量
ENV project_port 80
ENV project_name nvclouds-offical
ENV work_dir nvclouds_offical_dir

ADD src/main/docker /$work_dir
#容器中工作目录
WORKDIR /$work_dir
#root用户进入容器
USER root
#将本地jar包copy到容器根目录下
ADD  /target/$project_name.jar /$project_name.jar
#将本地启动脚本copy到容器中
ADD src/main/docker/run.sh /bin/run.sh
#授权脚本，否则无法执行
RUN chmod +x /bin/run.sh
#引用外部.env变量
#EXPOSE ${NVCLOUDS_OFFICAL_PORT}
#引用当前文件定义的变量
EXPOSE $project_port
CMD ["/bin/run.sh"]
