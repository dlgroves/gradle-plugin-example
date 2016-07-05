package com.groves.douglas.example_plugin.plugins

import com.groves.douglas.example_plugin.config.ExamplePluginExtension
import com.groves.douglas.example_plugin.tasks.ExamplePluginTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * The main plugin class; responsible for defining the configuration extension and actions that will
 * be performed during execution.
 *
 * Usage:
 *
 * example {
 *     greeting = 'hello'
 *     name = 'world'
 * }
 *
 * Created by dougg on 01/07/2016.
 */
class ExamplePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("example", ExamplePluginExtension)
        project.task([type: ExamplePluginTask], "example")
    }
}
