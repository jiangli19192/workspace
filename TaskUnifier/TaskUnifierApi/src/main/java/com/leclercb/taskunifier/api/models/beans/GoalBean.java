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
package com.leclercb.taskunifier.api.models.beans;

import com.leclercb.taskunifier.api.models.ModelId;
import com.leclercb.taskunifier.api.models.ModelType;
import com.leclercb.taskunifier.api.models.enums.GoalLevel;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GoalBean extends AbstractModelParentBean {
	
	@XStreamAlias("level")
	private GoalLevel level;
	
	@XStreamAlias("contributes")
	private ModelId contributes;
	
	@XStreamAlias("archived")
	private boolean archived;
	
	public GoalBean() {
		this((ModelId) null);
	}
	
	public GoalBean(ModelId modelId) {
		super(modelId);
		
		this.setLevel(GoalLevel.LIFE_TIME);
		this.setContributes(null);
		this.setArchived(false);
	}
	
	public GoalBean(GoalBean bean) {
		super(bean);
		
		this.setLevel(bean.getLevel());
		this.setContributes(bean.getContributes());
		this.setArchived(bean.isArchived());
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.GOAL;
	}
	
	public GoalLevel getLevel() {
		return this.level;
	}
	
	public void setLevel(GoalLevel level) {
		this.level = level;
	}
	
	public ModelId getContributes() {
		return this.contributes;
	}
	
	public void setContributes(ModelId contributes) {
		this.contributes = contributes;
	}
	
	public boolean isArchived() {
		return this.archived;
	}
	
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
}
