#!/usr/bin/env groovy

import com.lesfurets.jenkins.unit.global.lib.Library

import utils.Foo

@Library('jenkins-shared-library-example@master')_
def execute() {
	node() {
		withCredentials([
			string( credentialsId: 'compte', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )
		]) {
		}
		stage("First") {
			echo "Something"
			sayHello "Traveller"
		}
		stage("Middle") { echo Foo.firstMethod() }
		stage("Last") { echo "We're done" }
	}
}

return this