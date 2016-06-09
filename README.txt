#==============================================================================
# Java VM System Property 설정
#==============================================================================
# Spring Profile Active 설정
-Dspring.profiles.active="dev,jdbc,mybatis,jpa"

# src/main/resources 폴더에 있는 application.properties,application-dev.properties,application-production.properties 참조

# 개발서버
-Dspring.profiles.active="dev,jdbc,mybatis,jpa" -Dapp.name="webapp" -Dapserver.type="local"

-Dspring.profiles.active=dev,jdbc,mybatis,jpa -Dapp.name=webapp -Dapserver.type=local

# 운영서버 : JBoss AS 7.1.1 Server Tested.
-Dspring.profiles.active=production,jdbc,mybatis,jpa -Dapp.name=webapp -DapServer.type=op

