package com.temenos.ds.ng.nuipoc.tests;

import java.io.IOException;
import java.net.URL;

import nui.Form;
import nui.NuiPackage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eson.resource.EFactoryResource;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.inject.Inject;
import com.temenos.ds.ng.nuipoc.Generator;

@RunWith(XtextRunner.class)
@InjectWith(EFactoryInjectorProvider.class)
public class GeneratorTest {

	@Inject ParseHelper<EObject> parseHelper;
	@Inject ValidationTestHelper validationTestHelper;
	
	@Test public void testGeneratingHTML() throws Exception {
		NuiPackage.eINSTANCE.toString();
		CharSequence eson = getResourceAsString("router-states.eson");
		EObject root = parseHelper.parse(eson);
		validationTestHelper.assertNoErrors(root);
		Form form = EFactoryResource.getEFactoryEObject(root.eResource(), Form.class);
		Generator routesGenerator = new Generator();
		CharSequence genJS = routesGenerator.html(form);
		CharSequence expectedJS = getResourceAsString("routes.js");
		assertEquals(expectedJS, genJS);
		// TODO assert its valid HTML by running it through a Java HTML parser such as http://jsoup.org
	}
	
	/**
	 * @see https://github.com/junit-team/junit/pull/949/
	 */
	protected void assertEquals(CharSequence expected, CharSequence actual) {
		// TODO trim() each line..
		Assert.assertEquals(expected.toString().trim(), actual.toString().trim());
	}
	
	private String getResourceAsString(String resourceName) throws IOException {
		URL url = Resources.getResource(GeneratorTest.class, resourceName);
		return Resources.toString(url, Charsets.UTF_8);
	}
}
