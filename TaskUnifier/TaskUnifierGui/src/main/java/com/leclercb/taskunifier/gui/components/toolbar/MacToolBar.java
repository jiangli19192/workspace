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
package com.leclercb.taskunifier.gui.components.toolbar;

import com.explodingpixels.macwidgets.MacWidgetFactory;
import com.explodingpixels.macwidgets.UnifiedToolBar;
import com.leclercb.commons.api.event.propertychange.WeakPropertyChangeListener;
import com.leclercb.commons.api.properties.events.SavePropertiesListener;
import com.leclercb.commons.api.properties.events.WeakSavePropertiesListener;
import com.leclercb.commons.gui.logger.GuiLogger;
import com.leclercb.taskunifier.gui.actions.*;
import com.leclercb.taskunifier.gui.actions.synchronize.ActionSynchronizeAndPublish;
import com.leclercb.taskunifier.gui.components.configuration.api.ConfigurationTab;
import com.leclercb.taskunifier.gui.main.Main;
import com.leclercb.taskunifier.gui.utils.SynchronizerUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MacToolBar extends UnifiedToolBar implements SavePropertiesListener, PropertyChangeListener {
	
	private JLabel accountLabel;
	
	public MacToolBar() {
		this.initialize();
	}
	
	private void initialize() {
        this.initializeActions();
		
		final JPopupMenu toolbarMenu = new JPopupMenu();
		toolbarMenu.add(new ActionConfiguration(
				16,
				16,
				ConfigurationTab.TOOLBAR));
		
		this.getComponent().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.isPopupTrigger()
						|| event.getButton() == MouseEvent.BUTTON3) {
					toolbarMenu.show(
							MacToolBar.this.getComponent(),
							event.getX(),
							event.getY());
				}
			}
			
		});
		
		final ActionSwitchToUserMenu userMenu = new ActionSwitchToUserMenu(
				16,
				16);
		
		this.accountLabel = MacWidgetFactory.createEmphasizedLabel("");
		this.accountLabel.setText(this.getAccountLabelText());
		
		this.accountLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.isPopupTrigger()
						|| event.getButton() == MouseEvent.BUTTON3) {
					userMenu.showPopupMenu(MacToolBar.this.accountLabel);
				}
				
				if (event.getButton() == MouseEvent.BUTTON1
						&& event.getClickCount() == 2) {
					ActionManageUsers.manageUsers();
				}
			}
			
		});
		
		Main.getUserSettings().addSavePropertiesListener(
				new WeakSavePropertiesListener(Main.getUserSettings(), this));
		
		Main.getUserSettings().addPropertyChangeListener(
				"general.user.name",
				new WeakPropertyChangeListener(Main.getUserSettings(), this));
		
		Main.getUserSettings().addPropertyChangeListener(
				"plugin.synchronizer.id",
				new WeakPropertyChangeListener(Main.getUserSettings(), this));
		
		this.addComponentToRight(this.accountLabel);
	}
	
	private String getAccountLabelText() {
		String user = Main.getUserSettings().getStringProperty(
				"general.user.name");
		String account = SynchronizerUtils.getSynchronizerPlugin().getAccountLabel();
		
		if (user == null)
			user = "";
		
		if (account == null)
			account = "";
		
		if (user.length() == 0 && account.length() == 0)
			return "";
		
		if (user.length() == 0)
			return account;
		
		if (account.length() == 0)
			return user;
		
		return user + " - " + account;
	}
	
	private void initializeActions() {
		try {
			boolean added = false;
			String value = Main.getSettings().getStringProperty(
					"general.toolbar");
			
			if (value == null)
				throw new Exception();
			
			String[] actions = StringUtils.split(value, ';');
			for (String action : actions) {
				action = action.trim();
				
				try {
					ActionList l = ActionList.valueOf(action);
					
					if (!l.isFitToolBar())
						continue;
					
					if (l == ActionList.SEPARATOR) {
						this.addComponentToLeft(new JSeparator());
						continue;
					}
					
					Action a = l.newInstance(20, 20);
					
					if (a == null)
						continue;
					
					this.addComponentToLeft(this.createButton(a));
					added = true;
				} catch (Throwable t) {
					GuiLogger.getLogger().warning(
							"Cannot add action \"" + action + "\" to toolbar");
				}
			}
			
			if (!added)
				throw new Exception();
		} catch (Throwable t) {
			this.addComponentToLeft(this.createButton(new ActionChangeView(
					24,
					24)));
			this.addComponentToLeft(new JSeparator());
			this.addComponentToLeft(this.createButton(new ActionAddNote(24, 24)));
			this.addComponentToLeft(this.createButton(new ActionAddTask(24, 24)));
			this.addComponentToLeft(this.createButton(new ActionAddSubTask(
					24,
					24)));
			this.addComponentToLeft(this.createButton(new ActionAddTemplateTaskMenu(
					24,
					24,
					ActionAddTemplateTask.ADD_TASK_LISTENER)));
			this.addComponentToLeft(this.createButton(new ActionDelete(24, 24)));
			this.addComponentToLeft(new JSeparator());
			this.addComponentToLeft(this.createButton(new ActionSynchronizeAndPublish(
					24,
					24,
					false)));
			this.addComponentToLeft(this.createButton(new ActionScheduledSync(
					24,
					24)));
			this.addComponentToLeft(new JSeparator());
			this.addComponentToLeft(this.createButton(new ActionConfiguration(
					24,
					24)));
		}
	}
	
	private JButton createButton(Action action) {
		JButton button = new JButton(action);
		this.formatButton(button);
		return button;
	}
	
	private void formatButton(JButton button) {
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setText("");
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		this.accountLabel.setText(MacToolBar.this.getAccountLabelText());
	}
	
	@Override
	public void saveProperties() {
		this.accountLabel.setText(MacToolBar.this.getAccountLabelText());
	}
	
}
