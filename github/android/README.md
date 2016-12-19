[TOC]

# GitHub android 使用指南

## gradle 使用Github仓库

要求

* `classpath 'com.android.tools.build:gradle:1.3.0'` 以上
* distributionUrl=https\://services.gradle.org/distributions/gradle-2.8-all.zip 2.8以上

### 设置Github仓库

在Android Studio 工程的`根目录`的 `build.gradle`文件中配置

```
allprojects {
    repositories {
        maven {
            url 'https://raw.githubusercontent.com/MDL-Sinlov/MDL-Android-Repo/master/mvn-repo/'
        }
        jcenter()
    }
}
```

或者在需要使用的`module`的`build.gradle`中配置

```gradle
    repositories {
        maven {
            url 'https://raw.githubusercontent.com/MDL-Sinlov/MDL-Android-Repo/master/mvn-repo/'
        }
    }
```

**具体见自己的依赖管理设置**

### module 使用依赖

在module的 `build.gradle` 文件中使用

```gradle
dependencies {
    // jar at taget version
    compile group: 'com.your.package', name: 'pacakge', version: '1.0.0'
    // aar at taget version
    compile group: 'com.your.package', name: 'pacakge', version: '1.0.1@aar'
    // last version with aar
    compile group: 'com.your.package', name: 'pacakge', version: 'latest.integration@aar'
}
```

# 发布推送

[使用详情请点击](githubAndroid.md)

## 发布插件地址

```gradle
// uploadArchives without javadoc
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-no-javadoc.gradle"

// uploadArchives without javadoc and Sources
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-no-doc-sources.gradle"

// uploadArchives all
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-all.gradle"

// uploadArchives aar
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-aar.gradle"

// uploadArchive only arr
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-only-arr.gradle"

// uploadArchive only arr and eclipse
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/github/android/github-archives-only-arr-eclipse.gradle"
