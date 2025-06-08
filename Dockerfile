FROM dragonwell-registry.cn-hangzhou.cr.aliyuncs.com/dragonwell/dragonwell:17
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
ADD ./target/direct-debits-services.jar direct-debits-services.jar
ENTRYPOINT ["java","-jar","/direct-debits-services.jar"]
