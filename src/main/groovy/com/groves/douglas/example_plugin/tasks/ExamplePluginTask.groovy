package com.groves.douglas.example_plugin.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Actions that will be performed by ExamplePlugin.
 *
 * Usage (after imports):
 *
 * project.task([type: ExamplePluginTask], "example")
 *
 * Created by Douglas Groves on 05/07/2016.
 */
class ExamplePluginTask extends DefaultTask {

    @TaskAction
    def greetUser() {
        print "${project.example.greeting ?: 'Hi'} ${project.example.name}".trim()
    }
}
