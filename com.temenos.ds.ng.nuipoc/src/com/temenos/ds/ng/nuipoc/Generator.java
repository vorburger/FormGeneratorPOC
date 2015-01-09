package com.temenos.ds.ng.nuipoc;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public class Generator implements IGenerator {

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		// TODO move this code into a helper in ESON..
		fsa.generateFile("test.txt", "hello");
	}

}
