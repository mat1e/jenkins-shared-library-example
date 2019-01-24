#!/usr/bin/env groovy
import org.utils.Foo

def call(String name = 'human') {
	echo "Hello, ${name}."
	echo Foo.firstMethod(this.getClass().name)
}