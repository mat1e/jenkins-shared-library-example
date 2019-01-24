package groovy
import org.utils.Foo

import com.lesfurets.jenkins.unit.global.lib.Library

@Library('jenkins-shared-library-example@master')_
def execute() {
	node() {
		stage("First") {
			echo "Something"
			sayHello "Traveller"
		}
		stage("Middle") { echo Foo.firstMethod() }
		stage("Last") { echo "We're done" }
	}
}

return this