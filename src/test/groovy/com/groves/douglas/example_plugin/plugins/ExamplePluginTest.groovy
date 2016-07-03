package com.groves.douglas.example_plugin.plugins
/*
 * This Spock specification was auto generated by running the Gradle 'init' task
 * by 'dougg' at '01/07/16 14:52' with Gradle 2.13
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
        setup:
            def project = ProjectBuilder.builder().build()
            project.ext.example = [name: user, greeting: greeting]
            def conOutput = ''
            def interceptor = new SystemOutputInterceptor({ conOutput += it; false })
        when:
            interceptor.start()
            project.pluginManager.apply ExamplePlugin
            interceptor.stop()
        then:
            project.tasks.example instanceof Task
        and:
            conOutput == output
        where:
            user    | greeting | output
            'Homer' | 'Hello'  | 'Hello Homer'
            'Bart'  | 'Hello'  | 'Hello Bart'
            ''      | 'Hello'  | 'Hello'
            'Marge' | ''       | 'Hi Marge'
    }
}