[TOC]

# 介绍

这里放置的是一些通用的gradle插件

# IDE setting

## JMV setting

如果你希望自己的项目使用 java 1.8 特性，引入 IDE-JVM-1.8 setting等实用工具，查看
[IDE-JVM-1.8-setting.gradle](IDE-JVM-1.8-setting.gradle)

## Findbugs

如果你希望使用Findbugs来查找java项目中的静态错误，并且配置Findbugs，参见

[Findbugs.gradle](Findbugs.gradle)

```sh
./gradlew moduleName:
```

## Jenkins Utils

- for perform JenkinsBuild

add `gradle.properties`

```sh
JENKINS_HOST=http://localhost:8088
JENKINS_JOB_NAME=AS_Demo
```

add `build.gradle`

```gradle
// :module:performJenkinsBuild
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/gradleUtils/jenkins_utils.gradle"
```

then run

```sh
./gradlew :module:performJenkinsBuild
```
