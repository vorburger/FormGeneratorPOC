package com.temenos.ds.ng.nuipoc

import nui2.Form

class FormHTMLGenerator {

	def html(Form form) '''
<!doctype html>
<!-- GENERATED FILE - do NOT edit by hand (instead adapt the template in the Generator) -->
<head>
	« /* This is a comment in the Template (only) */ »
	« /* TODO HTML head section */ »
</head>
<body>
		<h1>«form.name»</h1>

<ul>    «FOR field : form.fields»
	<li>«field.label»: 
        «ENDFOR»
</ul>

</body>
</html>'''

}
