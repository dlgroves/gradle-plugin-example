# Issues

## Unable to apply plugin with id: 'xyz'

Ensure that your plugin IDs are consistant across both your plugin implementation class and your plugin properties file inside META-INF/gradle-plugins.

## Cannot get property 'example' on extra properties extension as it does not exist

The configuration closure must be identical to the plugin id.

## My integration tests fail if I specify a task type in the plugin class

Under investigation