# Debug
This is a small package to remove the boiler plate code for debugging an android application. 

# Implementation
####Gradle: 

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.FernandoCCNunes:debug-android:1.0'
	}

####Maven: 
    
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    
    <dependency>
        <groupId>com.github.FernandoCCNunes</groupId>
        <artifactId>debug-android</artifactId>
        <version>1.0</version>
    </dependency>