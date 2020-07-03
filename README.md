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
        implementation 'com.github.FernandoCCNunes:debug-android:1.2.0'
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
                    .setUseSingleTag(true)
                    .setDisplayCustomTags(true)
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

### DebugManager:

| Function | Params | Description |
| -------- | ------ | ----------- |
| init() | DebuggerSettings | This function initializes the DebugManager with a instance of **DebuggerSettings** to handle the behavior of the debug functionality.

### DebuggerSettings:

| Constructor | Description |
| ----------- | ----------- |
| (context: Context, bInDebugMode: Boolean) | Initializes an instance of **DebuggerSettings** with the context of your app and a variable to control whether the logs should be displayed or skipped <br/> **true** = Logs will be displayed <br/> **false** = Logs will not be displayed.

### DebuggerSettings.Builder:

| Constructor | Description |
| ----------- | ----------- |
| (context: Context, bInDebugMode: Boolean) | Initializes an instance of **DebuggerSettings** with the context of your app and a variable to control whether the logs should be displayed or skipped <br/> **true** = Logs will be displayed <br/> **false** = Logs will not be displayed.

| Function | Params | Description | Default |
| -------- | ------ | ----------- | ------- |
| setDefaultTag() | String | Default value for the **tag**, this value will be used if no tags are defined when calling the **Debug** functions or if the property **bUseSingleTag** is set to **true** | property 'android:label' inside the Manifest file.
| setUseSingleTag() | Boolean | Default value for the **bUseSingleTag**. <br/> **true -> tag** will be used in all logs. <br/> **false -> tag** will only be used if custom tags are not defined when calling the **Debug** functions | false.
| setDisplayCustomTags() | Boolean | Default value for the **bDisplayCustomTags**. <br/> **true ->** custom tags defined in **Debug** functions will be displayed before the log message but not as the log's TAG if **bUseSingleTag** is set to **false**. <br/> **false ->** custom tags will never be displayed before the message if **bUseSingleTag** is set to **true** | true.
| build() | NONE | Returns an instance of **DebuggerSettings** with with the property values from the **Builder** | N/A.

### Debug:

| Constructor | Description |
| ----------- | ----------- |
| (message: String) | The log will contain this message and it's TAG will be the default value of the property **tag** in the **DebuggerSettings**.
| (tag: Any, message: String) | The log will contain this message and it's TAG will be the name of the class passed in by the **tag** parameter if **bUseSingleTag** is set to **false**.
| (tag: String, message: String) | The log's message will be the value from the **message** parameter and it's TAG will be the value from the **tag** parameter if **bUseSingleTag** is set to **false**.

| Function | Params | Description |
| -------- | ------ | ----------- |
| error() | NONE | Displays a log of type error.
| warning() | NONE | Displays a log of type error.
| information() | NONE | Displays a log of type information.
| debug() | NONE | Displays a log of type debug.
| verbose() | NONE | Displays a log of type verbose.

# Author 
- **Name:** Fernando Nunes
- **Github** FernandoCCNunes
- **Email:** -empty-

# License
- Apache License 2.0


