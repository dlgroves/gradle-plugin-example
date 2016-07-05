package com.groves.douglas.example_plugin.plugins

/**
 * Integration tests for ExamplePlugin.
 *
 * @author dougg, @date 01/07/16 14:52
 */

import groovy.ui.SystemOutputInterceptor
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.*

class ExamplePluginTest extends Specification {
    @Unroll
    def "example plugin greets user '#user' with #output"(user, greeting, output) {
        given: 'a gradle project'
            def project = ProjectBuilder.builder().build()
        and: 'the plugin has been configured with extra properties'
            project.ext.example = [name: user, greeting: greeting]
        and: 'a standard output interceptor has been attached to the console'
            def conOutput = ''
            def interceptor = new SystemOutputInterceptor({ conOutput += it; false })
        when: 'the plugin is applied to the project and the included task is executed'
            project.pluginManager.apply ExamplePlugin
            interceptor.start()
            project.tasks.example.execute() //TODO: find a better way of achieving this
            interceptor.stop()
        then: 'the task should be accessible from the project'
            project.tasks.example instanceof Task
        and: 'the output from the task action should match expectations'
            conOutput == output
        where:
            user    | greeting | output
            'Homer' | 'Hello'  | 'Hello Homer'
            'Bart'  | 'Hello'  | 'Hello Bart'
            ''      | 'Hello'  | 'Hello'
            'Marge' | ''       | 'Hi Marge'
    }
}
