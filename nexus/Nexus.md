[TOC]

# 使用配置

* 添加内容到modules的 `build.gradle`脚本`最后`

```gradle
//uploadArchives
apply from: "http://yourgit/name/Gradle_zoo/raw/master/nexus/xx/nexus-publish.gradle"
```

> http://yourgit/name/Gradle_zoo/raw/master/nexus/xx/nexus-publish.gradle 这个地址是使用git的源数据的地址，请自行查找后替换掉


* 请复制本仓库`对应服务器`的文件 [gradle.properties](gradle.properties)到需要提交的 Modules 根目录中
* 配置内容
* 点击右侧 Gradle
* 找到对应Modules的Task列表，展开列表
* 双击 `\upload\uploadArchives`


或者在工程的根目录运行命令

```sh
gradlew uploadArchives
```

# 内网配置注意

如果无法正常获取RAW资源，请在 `build.gradle` 脚本后添加的内容修改如下

```gradle
//uploadArchives
apply from: "nexus-publish.gradle"
```

同时将

http://yourgit/name/Gradle_zoo/raw/master/nexus/nexus-publish.gradle

这个文件复制到需要上传moudles根目录


# gradle.properties 配置详解

工程根目录 gradle.properties 配置样例 [nexus-publish.propertese](nexus-publish.propertese)
根目录用于设置nexus的基础

对于需要推送的模块，配置见 [module_gradle.properties](module_gradle.properties)

## 发布配置

|字段|用途|备注|
|---|---|---|
|GROUP|发布组ID|写包结构 com.game.package|
|VERSION_NAME|版本号|一般填写0.0.1，用于区分版本|
|POM_ARTIFACT_ID|标识ID|一般用包结构名最后一段 package|
|NEXUS_USERNAME|用户名|Nexus管理员分配|
|NEXUS_PASSWORD|密码|登陆后可自行修改|
|SNAPSHOT_REPOSITORY_URL|快照仓库配置|一般注释不填写|
|RELEASE_REPOSITORY_URL|发布仓库配置|一般注释不填写

> if VERSION_NAME contans SNAPSHOT this project will archive to snapshots which archive to releases not chants

### 这些设置连动到工程可以这么使用

```gradle
android {
    compileSdkVersion ANDROID_COMPILE_SDK_VERSION as int
    buildToolsVersion ANDROID_BUILD_TOOLS_VERSION

    defaultConfig {
        minSdkVersion ANDROID_MIN_SDK_VERSION as int
        targetSdkVersion ANDORID_TARGET_SDK_VERSION as int
        versionCode VERSION_CODE as int
        versionName VERSION_NAME
    }
}
```

这样就只需要修改一个地方进行发版

### 快照发布

VERSION_NAME=1.1.1-SNAPSHOT

只要版本号包含SNAPSHOT 就是快照版本

### 正式发布

GROUP=包结构

# 错误解决

## 如果出现无法编译 javadoc

一般出现在windows编译环境，或者没法让java-doc正常过编导致

请使用下面的地址，使用无javadoc编译推送

```gradle
//uploadArchives
apply from: "http://yourgit/name/Gradle_zoo/raw/master/nexus/90_251/nexus-publish-no-javadoc.gradle"
```
