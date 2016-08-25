[TOC]

# 使用配置

* 添加内容到modules的 `build.gradle`脚本`最后`

```gradle
// uploadArchives without javadoc
apply from: "https://coding.net/u/sinlovppt/p/Gradle_Zoo/git/raw/master/github/android/github-archives-all.gradle"
```

https://coding.net/u/sinlovppt/p/Gradle_Zoo/git/raw/master/github/android/github-archives-all.gradle
这个地址是使用git的源数据的地址，请自行查找后替换掉


* 请复制本仓库`对应服务器`的文件 [gradle.properties](gradle.properties)到需要提交的`项目根目录`中,再在需要提交的`module`中复制[module_gradle.properties](module_gradle.properties)内容到对应`module的gradle.properties`中

* 配置`各自层级的gradle.properties`内容
* 点击右侧 Gradle
* 找到对应Modules的Task列表，展开列表
* 双击 `\upload\uploadArchives`


或者在工程的根目录运行命令

```sh
./gradlew uploadArchives
```

# 内网配置注意

如果无法正常获取RAW资源，请在 `build.gradle` 脚本后添加的内容修改如下

```gradle
//uploadArchives
apply from: "github-archives-all.gradle"
```

同时将

https://coding.net/u/sinlovppt/p/Gradle_Zoo/git/raw/master/github/android/github-archives-all.gradle

这个文件复制到需要上传moudles根目录


# gradle.properties 配置详解

## 发布配置

*项目根配置*

|字段|用途|备注|
|---|---|---|
|GROUP|发布组ID|写包结构 com.game.package|
|VERSION_NAME|版本号|一般填写0.0.1，用于区分版本|
|POM_URL|POM URL|指定到你的github仓库根目录|
|POM_SCM_URL|POM SCM URL|指定到你的github仓库根目录|
|POM_SCM_CONNECTION|POM SCM CONNECTION 地址|格式一般为scm:+ git协议路径|
|POM_SCM_DEV_CONNECTION|POM SCM DEV CONNECTION 地址|格式一般为scm:+ git协议路径|
|POM_LICENCE_NAME|代码授权协议名称|比如The Apache Software License, Version 2.0|
|POM_LICENCE_URL|代码授权协议URL|协议链接|
|POM_LICENCE_DIST|dist路径|一般填写repo|
|POM_DEVELOPER_ID|作者ID|自定|
|POM_DEVELOPER_NAME|作者Name|自定|
|SNAPSHOT_REPOSITORY_URL|快照仓库配置|一般注释不填写|
|RELEASE_REPOSITORY_URL|发布仓库配置|一般注释不填写|
|POM_DESCRIPTION|仓库描述|一般不写|

*module配置*

|字段|用途|备注|
|---|---|---|
|POM_NAME|库名称|一般用XXX Library|
|POM_ARTIFACT_ID|标识ID|一般用包结构名最后一段 package|
|POM_PACKAGING|打包方式|aar jar 等|

### 快照发布

GROUP=SNAPSHOT

### 正式发布

GROUP=包结构

# 错误解决

## 如果出现无法编译 javadoc

一般出现在windows编译环境

请使用下面的地址，使用无javadoc编译推送

```gradle
//uploadArchives
apply from: "https://coding.net/u/sinlovppt/p/Gradle_Zoo/git/raw/master/github/android/github-archives-no-javadoc.gradle"
```
