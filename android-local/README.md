[TOC]

# 发布工具使用指南

需要发布的`module`的`build.gradle`中配置

在 `gradle.properties` 中配置参数

|key|value|defautl|
|---|-----|-------|
|COMM_NAME|公司组织前缀|Def|
|OBA_OUT_DIR|输出目录|build/outApk|

>输出工程根目录使用 `file://${project.rootDir}` 自定义目录使用 `file://[YouFullPath]`

```gralde
// OutBuildApk you can annotation this if network bad!
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/OutBuildApk.gradle"
```


如果使用 Android Studio 2.2.+ 或者以上，请使用

```gralde
// OutBuildApk_2.0 you can annotation this if network bad!
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/OutBuildApk_2.0.gradle"
```

>在 OutBuildApk_2.0 中新增 outProductFlavorsReleaseARM32 和 outProductFlavorsReleaseARM 分别只输出 ARM32位的分包，或者 所有 arm 发布，配合splites abi 使用

```gradle
android {
    ...
    splits{
        abi{
            enable true
            reset()
            include 'armeabi', 'armeabi-v7a'
            universalApk false
        }
    }
    ...
}
```


输出的Apk 默认在`build/outApk/` 中，默认开头为 `Def`

可以在`gradle_properties` 中配置 `OBA_OUT_DIR` `COMM_NAME` 来改变

```gralde
// OutBuildAAR you can annotation this if network bad! use at outAARFlavorsRelease or outAARFlavorsReleaseRepo
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/outAAR.gradle"
```

发布使用命令

```sh
# out test at {module}/build/outApk
./gradle :module:outTAD
# out release - unsigned at {module}/build/outApk
./gradle :module:outTAR
# out ProductFlavorsReleaseAll at {module}/build/outApk
./gradle :module:outProductFlavorsReleaseAll
# out test armv7a at {module}/build/outApk
./gradle :module:outTADARMv7a
# out release - unsigned at {module}/build/outApk
./gradle :module:outTARARMv7a
# out release all at {module}/build/outApk
./gradle :module:outProductFlavorsReleaseAll
# out aar FlavorsRelease at {module}/build/outAAR
./gradle :module:outAARFlavorsRelease
# out aar FlavorsRelease at repo ${rootDir}/aar-repo/outAAR
./gradle :module:outAARFlavorsReleaseRepo
```

# android 本地仓库发布使用指南

## gradle 使用本地仓库

要求

* `classpath 'com.android.tools.build:gradle:1.3.0'` 以上
* distributionUrl=https\://services.gradle.org/distributions/gradle-2.8-all.zip 2.8以上

### 设置Github仓库

在Android Studio 工程的`根目录`的 `build.gradle`文件中配置

```
allprojects {
    repositories {
        maven {
            url 'file:///Users/sinlov/Documents/GitHub/MDL_Sinlov/MDL-Android-Repo/mvn-repo/'
        }
        jcenter()
    }
}
```

或者在需要使用的`module`的`build.gradle`中配置

```gradle
repositories {
    maven {
        url 'file:///Users/sinlov/Documents/GitHub/MDL_Sinlov/MDL-Android-Repo/mvn-repo/'
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

[使用详情请点击](localAndroid.md)

## 发布插件地址

```gradle
// uploadArchives without javadoc
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-no-javadoc.gradle"

// uploadArchives without javadoc and Sources
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-no-doc-sources.gradle"

// uploadArchives all
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-all.gradle"

// uploadArchives aar
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-aar.gradle"

// uploadArchive only arr
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-only-arr.gradle"

// uploadArchive only arr and eclipse
apply from: "https://github.com/sinlov/Gradle_Zoo/raw/master/android-local/local-archives-only-arr-eclipse.gradle"
