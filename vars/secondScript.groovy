#!/usr/bin/env groovy
import org.utils.Foo

def call(String step = 'uknown') {
	echo "Called by " + step
	echo Foo.firstMethod(this.getClass().name)
}