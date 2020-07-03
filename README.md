# Debug
This is a small package to remove the boiler plate code for debugging an android application. 

# Implementation
#### Gradle: 

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.FernandoCCNunes:debug-android:1.0'
	}

#### Maven: 
    
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
    
# Compatability: 

- **Minimum SDK:** 14

# Documentation: 

#### Simple Initialization:

    class Application: Application() {
    
        override fun onCreate() {
            super.onCreate()
            DebugManager.init(DebuggerSettings(this, BuildConfig.DEBUG))
        }
    }
    
**Note:** If you can't access BuildConfig class, then that is because it is not yet generated, run your project and this class will be generated for you

#### Complex Initialization:

    class Application: Application() {
    
        override fun onCreate() {
            super.onCreate()
            DebugManager.init(
                DebuggerSettings.Builder(this, BuildConfig.DEBUG)
                    .setDefaultTag("DebugExample")
                    .setUseSingleTag(bUseSingleTag = true, bDisplayCustomTags = false)
                    .build()
            )
        }
    }
    
#### Usage:
    
    class MainActivity : AppCompatActivity() {
        
        private val TAG = "MainActivity"
        
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            Debug(this, "Hello World with class name as TAG").debug()
            Debug(TAG, "Hello World with custom TAG").debug()
            Debug("Hello World with no custom TAG").debug()
        }
    }
    
# Extra Documentation

| Class/Function | Params | Description | Default |
| -------------- | ------ | ----------- | ---------------- |
| DebugManager.init() | DebuggerSettings | Initializes the DebugManager with custom settings | N/A
| DebuggerSettings() | Context, Boolean | Takes in a Context and a Boolean that handles whether to display or skip the logs | N/A
| DebuggerSettings.Builder() | Context, Boolean | Same as the primary constructor, but allows for more configuration | N/A
| DebuggerSettings.Builder().setDefaultTag()| String | The default tag to be used if **bUseSingleTag** is set to **true** or no tag is defined in the debug functions. | AppName  |
| DebuggerSettings.Builder().setUseSingleTag()| Boolean | Whether to use only one tag for all the logs or allow for custom tags <br/> **true** = Only default tag is used <br/> **false** = Custom tags are used if defined, otherwise default tag is used | false
| DebuggerSettings.Builder().setDisplayCustomTags()| Boolean | Whether to display or not the custom tags in the log message if **bUseSingleTag** is set to **true**. <br/> **true** = custom tags will be displayed in the message if **bUseSingleTag** is true <br/> **false** = custom tags will not be displayed in the message if **bUseSingleTag** is true | false
| DebuggerSettings.Builder().build() | N/A | Returns an instance of **DebuggerSettings** with the configurations from the **Builder** | N/A

# Author 
- **Name:** Fernando Nunes
- **Github** FernandoCCNunes
- **Email:** -empty-

# License
- Apache License 2.0


