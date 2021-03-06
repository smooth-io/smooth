version = LibraryAndroidCoordinates.LIBRARY_VERSION

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
    `maven-publish`
}

android {
    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        versionCode = LibraryAndroidCoordinates.LIBRARY_VERSION_CODE
        versionName = LibraryAndroidCoordinates.LIBRARY_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }

}

defaultDependencies {
    coroutine()
    startup()
    implementation(SupportLibs.ANDROIDX_APPCOMPAT)
}

//val sourcesJar by tasks.registering(Jar::class) {
//    classifier = "sources"
//    from(sourceSets.main.get().allSource)
//}

publishing {
//    repositories {
//        maven {
//             change to point to your repo, e.g. http://my.org/repo
//            url = uri("$buildDir/repo")
//        }
//    }
//    publications {
//        register("mavenJava", MavenPublication::class) {
//            from(components["java"])
////            artifact(sourcesJar.get())
//        }
//    }
}