package com.temenos.ds.ng.nuipoc

import nui.Form

class FormHTMLGenerator {

	def html(Form form) '''
		<html>« /* Comment in Template (only) */ »
		<!-- GENERATED FILE - do NOT edit by hand (instead adapt the template in the Generator) -->

		<h1>«form.name»</h1>
		
	    «FOR field : form.fields»
* «field.name»
	    «ENDFOR»
	'''

}
