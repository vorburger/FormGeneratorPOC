package com.temenos.ds.ng.nuipoc.tests;

import static org.junit.Assert.*;

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
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.inject.Inject;
import com.temenos.ds.ng.nuipoc.FormHTMLGenerator;

@RunWith(XtextRunner.class)
@InjectWith(EFactoryInjectorProvider.class)
public class GeneratorTest {

	@Inject ParseHelper<EObject> parseHelper;
	@Inject ValidationTestHelper validationTestHelper;
	
	@Test public void testGeneratingHTML() throws Exception {
		Form form = loadESON("input-contact-form.eson", Form.class);
		FormHTMLGenerator routesGenerator = new FormHTMLGenerator();
		String gen = routesGenerator.html(form).toString();
		String expected = getResourceAsString("output-expected-form.html");
		assertEquals(expected, gen);
		// TODO assert its valid HTML by running it through a Java HTML parser such as http://jsoup.org
	}

	private <T> T loadESON(String modelResourceName, Class<T> modelClass) throws IOException, Exception {
		NuiPackage.eINSTANCE.toString();
		String eson = getResourceAsString(modelResourceName);
		EObject model = parseHelper.parse(eson);
		validationTestHelper.assertNoErrors(model);
		return EFactoryResource.getEFactoryEObject(model.eResource(), modelClass);
	}
	
	private String getResourceAsString(String resourceName) throws IOException {
		URL url = Resources.getResource(GeneratorTest.class, resourceName);
		return Resources.toString(url, Charsets.UTF_8);
	}
}
