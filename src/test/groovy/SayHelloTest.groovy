#!/usr/bin/env groovy

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.LocalSource.localSource

import org.junit.Before
import org.junit.Test

import com.lesfurets.jenkins.unit.BasePipelineTest

class SayHelloTest extends BasePipelineTest {

	@Override
	@Before
	void setUp() throws Exception {

		String sharedLibs = this.class.getResource('./').getFile()

		def library = library()
				.name('jenkins-shared-library-example')
				.allowOverride(false)
				.retriever(localSource(sharedLibs))
				.targetPath(sharedLibs)
				.defaultVersion("master")
				.implicit(true)
				.build()
		helper.registerSharedLibrary(library)

		setScriptRoots(['src/main/groovy', 'vars', 'src/test/groovy' ] as String[])
		setScriptExtension('groovy')

		super.setUp()
	}

	@Test
	void should_execute_without_errors() throws Exception {
		Script script = loadScript("TestPipeline.groovy")
		script.execute()
		printCallStack()
		assertJobStatusSuccess()
	}
}
