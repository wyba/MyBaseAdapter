# base-adapter

努力打造一个ListView、GirdView通用的adapter,同时也在为RecycleView更好使用的adapter

* [1.APK](#1apk)
* [2.Usage](#2usage)
    * [工程依赖 build.gradle](#工程依赖-buildgradle)
        * [(1).project](#1project)
        * [(2).app](#2app)
    * [Use it](#use-it)
        * [(1).普通的ListView]()
        * [(2).多类型Item ListView]()
        * [(3).普通的RecycleView]()
        * [(4).多类型Item RecycleView]()

 ## 1.APK
 
 [Demo DownLoad](/app/release/app-release.apk)
        
## 2.Usage

### 工程依赖 build.gradle

#### (1).project

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

#### (2).app

	dependencies {
	        compile 'com.github.wyba:base-adapter:V1.3.0'
	}

### Use it

#### (1).普通的ListView

#### (2).多类型Item ListView

#### (3).普通的RecycleView

#### (4).多类型Item RecycleView

