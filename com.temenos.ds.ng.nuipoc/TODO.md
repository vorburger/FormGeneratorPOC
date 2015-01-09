
* Generator.xtend for real

* multi generator ext. point registered



* ESON, major: read metamodel from workspace!

*  Try abandoning DS NG SDK, and switch to a standard Xtext IDE, plus ESON, from eclipse.org p2 site, because:
	1. DS NG SDK keeps rebuilding, even with only 1 micro small project - Xtext bug?
	2. Caused by: java.lang.LinkageError: loader constraint violation: loader (instance of org/eclipse/osgi/internal/loader/EquinoxClassLoader) previously initiated loading for a different type with name "org/apache/log4j/Logger"
		WORK AROUND / FIX: Close ESON Editor, Exit, restart. It's some loading order issue, if Editor is opened later, it works.


* ESON, minor: should publish test bundle as part of the SDK feature, so that we can depend on it here, instead of copy/pasting
 
* ESON, minor: gen. package not nui but com.temenos.ds.ng.nui.model (incl. Export-Package in MANIFEST)


