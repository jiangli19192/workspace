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
package com.leclercb.taskunifier.gui.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.SortOrder;

import com.leclercb.taskunifier.api.models.enums.TaskPriority;
import com.leclercb.taskunifier.gui.api.searchers.TaskSearcher;
import com.leclercb.taskunifier.gui.api.searchers.TaskSearcherFactory;
import com.leclercb.taskunifier.gui.api.searchers.TaskSearcherType;
import com.leclercb.taskunifier.gui.api.searchers.filters.TaskFilter;
import com.leclercb.taskunifier.gui.api.searchers.filters.TaskFilterElement;
import com.leclercb.taskunifier.gui.api.searchers.filters.conditions.DaysCondition;
import com.leclercb.taskunifier.gui.api.searchers.filters.conditions.EnumCondition;
import com.leclercb.taskunifier.gui.api.searchers.filters.conditions.StringCondition;
import com.leclercb.taskunifier.gui.api.searchers.groupers.TaskGrouper;
import com.leclercb.taskunifier.gui.api.searchers.sorters.TaskSorter;
import com.leclercb.taskunifier.gui.api.searchers.sorters.TaskSorterElement;
import com.leclercb.taskunifier.gui.components.tasks.TaskColumnList;
import com.leclercb.taskunifier.gui.translations.Translations;
import com.leclercb.taskunifier.gui.utils.ImageUtils;

public class ActionResetGeneralSearchers extends AbstractViewAction {
	
	public ActionResetGeneralSearchers(int width, int height) {
		super(
				Translations.getString("action.reset_general_searchers"),
				ImageUtils.getResourceImage("undo.png", width, height));
		
		this.putValue(
				SHORT_DESCRIPTION,
				Translations.getString("action.reset_general_searchers"));
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		ActionResetGeneralSearchers.resetGeneralSearchers();
	}
	
	public static void resetGeneralSearchers() {
		List<TaskSearcher> oldSearchers = TaskSearcherFactory.getInstance().getList();
		
		TaskFilter filter;
		TaskSorter sorter;
		TaskGrouper grouper;
		
		sorter = new TaskSorter();
		
		sorter.addElement(new TaskSorterElement(
				TaskColumnList.getInstance().get(TaskColumnList.DUE_DATE),
				SortOrder.ASCENDING));
		sorter.addElement(new TaskSorterElement(
				TaskColumnList.getInstance().get(TaskColumnList.PRIORITY),
				SortOrder.DESCENDING));
		sorter.addElement(new TaskSorterElement(
				TaskColumnList.getInstance().get(TaskColumnList.TITLE),
				SortOrder.ASCENDING));
		
		grouper = new TaskGrouper();
		
		// Not Completed
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.COMPLETED),
				StringCondition.EQUALS,
				"false",
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				1,
				Translations.getString("searcherlist.general.not_completed"),
				ImageUtils.getResourceFile("check.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Due Today
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.DUE_DATE),
				DaysCondition.EQUALS,
				0,
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				2,
				Translations.getString("searcherlist.general.due_today"),
				ImageUtils.getResourceFile("calendar.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Overdue
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.DUE_DATE),
				DaysCondition.LESS_THAN_USING_TIME,
				0,
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				3,
				Translations.getString("searcherlist.general.overdue"),
				ImageUtils.getResourceFile("warning.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Hot List
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.DUE_DATE),
				DaysCondition.LESS_THAN_OR_EQUALS,
				3,
				false));
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.PRIORITY),
				EnumCondition.GREATER_THAN_OR_EQUALS,
				TaskPriority.HIGH,
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				4,
				Translations.getString("searcherlist.general.hot_list"),
				ImageUtils.getResourceFile("hot_pepper.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Importance
		filter = new TaskFilter();
		
		TaskSorter importanceSorter = new TaskSorter();
		
		importanceSorter.addElement(new TaskSorterElement(
				TaskColumnList.getInstance().get(TaskColumnList.IMPORTANCE),
				SortOrder.DESCENDING));
		importanceSorter.addElement(new TaskSorterElement(
				TaskColumnList.getInstance().get(TaskColumnList.TITLE),
				SortOrder.ASCENDING));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				5,
				Translations.getString("searcherlist.general.importance"),
				ImageUtils.getResourceFile("importance.png"),
				filter,
				importanceSorter,
				grouper.clone());
		
		// Starred
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.STAR),
				StringCondition.EQUALS,
				"true",
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				6,
				Translations.getString("searcherlist.general.starred"),
				ImageUtils.getResourceFile("star.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Next Action
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.STATUS),
				StringCondition.EQUALS,
				"Next Action",
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				7,
				Translations.getString("searcherlist.general.next_action"),
				ImageUtils.getResourceFile("next.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		// Completed
		filter = new TaskFilter();
		filter.addElement(new TaskFilterElement(
				TaskColumnList.getInstance().get(TaskColumnList.COMPLETED),
				StringCondition.EQUALS,
				"true",
				false));
		
		TaskSearcherFactory.getInstance().create(
				TaskSearcherType.GENERAL,
				null,
				8,
				Translations.getString("searcherlist.general.completed"),
				ImageUtils.getResourceFile("check.png"),
				filter,
				sorter.clone(),
				grouper.clone());
		
		for (TaskSearcher searcher : oldSearchers) {
			if (searcher.getType().equals(TaskSearcherType.GENERAL))
				TaskSearcherFactory.getInstance().delete(searcher);
		}
	}
	
}
