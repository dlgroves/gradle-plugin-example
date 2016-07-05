# Example plugin

A simple Gradle plugin with integration tests against console output.

## Usage

* Install gradle-plugin-example to your local maven repository (gradlew install) and apply the plugin to your own project using the following snippets:
```gradle
buildscript {
   repositories {
       mavenLocal()
   }
   dependencies {
       classpath 'com.groves.douglas:gradle-plugin-example:0.1-SNAPSHOT'
   }
}

apply plugin: 'example'

example {
   greeting = 'Hello'
   name = 'World'
}
```
## Issues experienced during development

### Unable to apply plugin with id: 'xyz'

Ensure that your plugin scheme is consistent - the extension name defined in the plugin implementation class must be identical to the name of the properties file defined inside META-INF/gradle-plugins.

### Cannot get property 'example' on extra properties extension as it does not exist

The configuration closure must be named identically to the plugin scheme.

### My integration tests fail if I specify a task type in the plugin class or if my task is defined as an action

Tasks' configuration blocks will be invoked during integration tests, but the task's actions will not be executed. Refer to https://docs.gradle.org/current/userguide/more_about_tasks.html for more information.