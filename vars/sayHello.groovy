#!/usr/bin/env groovy
import org.utils.Foo

def call(String name = 'human') {
	echo "Hello, ${name}."
	println("Hello {}", name)
	println(Foo.firstMethod())
}