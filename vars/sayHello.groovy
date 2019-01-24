#!/usr/bin/env groovy
import utils.Foo

def call(String name = 'human') {
	echo "Hello, ${name}."
	echo Foo.firstMethod(this.getClass().name)
}