package com.temenos.ds.ng.nuipoc

import java.util.Iterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

class GenUtils {
	
	// TODO Does this already exist anywhere else like this (using Iterable streaming, not List) ?
	def <T extends EObject> Iterable<T> allContained(EObject root, Class<T> type) {
		// TODO TDD if (type.isAssignableFrom(root.getClass())) - union
		
		// TODO vs. EcoreUtil2.eAll(EObject) vs. root.eAllContents() - what's the difference??
		val iterator = EcoreUtil.getAllProperContents(root, true)
		val iterable = toIterable(iterator)
		return iterable.filter[ type.isAssignableFrom(it.getClass) ]
	}

	def <T> Iterable<T> toIterable(Iterator<T> iterator) {
		return new Iterable<T>() {
			override iterator() {
				iterator
			}
		}
	}
}