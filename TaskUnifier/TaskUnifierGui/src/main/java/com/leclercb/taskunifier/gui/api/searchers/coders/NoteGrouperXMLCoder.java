/*
 * TaskUnifier
 * Copyright (c) 2013, Benjamin Leclerc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 *   - Neither the name of TaskUnifier or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.leclercb.taskunifier.gui.api.searchers.coders;

import javax.swing.SortOrder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.leclercb.commons.api.coder.AbstractXMLCoder;
import com.leclercb.commons.api.coder.exc.FactoryCoderException;
import com.leclercb.taskunifier.api.models.Note;
import com.leclercb.taskunifier.gui.api.accessor.PropertyAccessor;
import com.leclercb.taskunifier.gui.api.searchers.groupers.NoteGrouper;
import com.leclercb.taskunifier.gui.api.searchers.groupers.NoteGrouperElement;
import com.leclercb.taskunifier.gui.components.notes.NoteColumnList;

public class NoteGrouperXMLCoder extends AbstractXMLCoder<NoteGrouper> {
	
	public NoteGrouperXMLCoder() {
		super("grouper");
	}
	
	@Override
	protected NoteGrouper decode(Node node) throws FactoryCoderException {
		try {
			NodeList nGrouper = node.getChildNodes();
			NoteGrouper grouper = new NoteGrouper();
			
			for (int i = 0; i < nGrouper.getLength(); i++) {
				if (nGrouper.item(i).getNodeName().equals("element")) {
					NodeList nElement = nGrouper.item(i).getChildNodes();
					
					PropertyAccessor<Note> column = null;
					SortOrder sortOrder = SortOrder.ASCENDING;
					
					for (int j = 0; j < nElement.getLength(); j++) {
						if (nElement.item(j).getNodeName().equals("column")) {
							column = NoteColumnList.getInstance().get(
									nElement.item(j).getTextContent());
						}
						
						if (nElement.item(j).getNodeName().equals("sortorder")) {
							sortOrder = SortOrder.valueOf(nElement.item(j).getTextContent());
						}
					}
					
					grouper.addElement(new NoteGrouperElement(column, sortOrder));
				}
			}
			
			return grouper;
		} catch (Exception e) {
			throw new FactoryCoderException(e.getMessage(), e);
		}
	}
	
	@Override
	protected void encode(Document document, Element root, NoteGrouper grouper) {
		for (NoteGrouperElement e : grouper.getElements()) {
			Element element = document.createElement("element");
			root.appendChild(element);
			
			Element column = document.createElement("column");
			column.setTextContent(e.getProperty().getId());
			element.appendChild(column);
			
			Element sortOrder = document.createElement("sortorder");
			sortOrder.setTextContent(e.getSortOrder().name());
			element.appendChild(sortOrder);
		}
	}
	
}
