/*******************************************************************************
 * Bizcal is a component library for calendar widgets written in java using swing.
 * Copyright (C) 2007  Frederik Bertilsson 
 * Contributors:       Martin Heinemann martin.heinemann(at)tudor.lu
 * 
 * http://sourceforge.net/projects/bizcal/
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 * 
 *******************************************************************************/
package bizcal.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import bizcal.common.CalendarModel;
import bizcal.common.CalendarViewConfig;
import bizcal.common.Event;
import bizcal.swing.util.ErrorHandler;
import bizcal.swing.util.FrameArea;
import bizcal.swing.util.GradientArea;
import bizcal.swing.util.LassoArea;
import bizcal.util.BizcalException;
import bizcal.util.DateInterval;
import bizcal.util.DateUtil;
import bizcal.util.TimeOfDay;

/**
 * 11.06.2007 14:47:25
 * 
 * 
 * @version <br>
 *          $Log: CalendarView.java,v $
 *          Revision 1.37 2008/10/30 10:42:52 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.36 2008/10/21 15:08:31 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.35 2008/10/09 12:33:09 heine_
 *          shows now the summary of an event in the header of a FrameArea and
 *          the the description is now in the body.
 * 
 *          Revision 1.34 2008/08/12 12:47:27 heine_
 *          fixed some bugs and made code improvements
 * 
 *          Revision 1.33 2008/06/19 12:20:00 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.32 2008/06/10 13:16:36 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.31 2008/06/09 14:10:09 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.30 2008/05/30 11:36:47 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.29 2008/05/26 08:15:31 heine_
 *          removed MainThread locking by swing worker thread
 * 
 *          Revision 1.28 2008/04/24 14:17:37 heine_
 *          Improved timeslot search when clicking and moving
 * 
 *          Revision 1.27 2008/04/08 13:17:53 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.26 2008/03/28 08:45:12 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.25 2008/03/21 15:02:35 heine_
 *          fixed problem when selecting lasso area in a region that was in the
 *          bottom of the panel.
 * 
 *          Removed all the evil getBounds() statements. Should run fast now and
 *          use lesser heap.
 * 
 *          Revision 1.24 2008/01/21 14:13:26 heine_
 *          *** empty log message ***
 * 
 *          Revision 1.37 2008-01-21 14:06:22 heinemann
 *          code cleanup and java doc
 * 
 *          Revision 1.36 2007-09-11 16:14:41 heinemann
 *          speed up
 * 
 * 
 *          Revision 1.26 2007/06/19 09:01:36 heinemann
 *          exception fixed <br>
 *          Revision 1.24 2007/06/18 11:41:32 heinemann <br>
 *          bug fixes and alpha optimations <br>
 * <br>
 * <br>
 *          Revision 1.20 2007/06/12 13:47:50 heinemann <br>
 *          fixed nullpointer <br>
 * <br>
 * 
 * 
 */
public abstract class CalendarView {
	
	public CalendarModel broker;
	
	protected CalendarListener listener;
	
	protected List<String> bottomCategories = new ArrayList<String>();
	
	protected PopupMenuCallback popupMenuCallback;
	
	private boolean visible = false;
	
	private Map<String, FrameArea> _frameAreaMap = new HashMap<String, FrameArea>();
	
	private Map _eventMap = new HashMap();
	
	private List<Event> _selectedEvents = new ArrayList<Event>();
	
	protected Font font;
	
	private LassoArea _lassoArea;
	
	private FrameArea _newEventArea;
	
	private JComponent _dragArea;
	
	private CalendarViewConfig desc;
	
	private static boolean draggingEnabled = true;
	
	/**
	 * Member to store the original clicked FrameArea in a dragging event.
	 */
	private static FrameArea originalClickedFrameArea = null;
	
	/**
	 * Offset to compute positions next to a vertical line
	 */
	private static final int LINE_OFFSET = 5;
	
	/**
	 * Static member to store if a mouse button was pressed. Used to avoid
	 * cursor checking in mouseMoved method of FrameAreas
	 */
	private static boolean isMousePressed = false;
	
	/**
	 * Member to store the state if a frameArea is resizable
	 */
	private static boolean isResizeable = false;
	
	private List<JLabel> vLines = new ArrayList<JLabel>();
	
	private List<JLabel> hLines = new ArrayList<JLabel>();
	
	Map<Event, FrameArea> frameAreaHash = Collections.synchronizedMap(new HashMap<Event, FrameArea>());
	
	private JComponent calPanel;
	
	private Date selectionDate;
	
	/**
	 * @param desc
	 * @throws Exception
	 */
	public CalendarView(CalendarViewConfig desc) throws Exception {
		this.desc = desc;
		this.font = desc.getFont();
	}
	
	public CalendarListener getCalendarListener() {
		return this.listener;
	}
	
	public Event[] getSelectedEvents() {
		return this._selectedEvents.toArray(new Event[0]);
	}
	
	protected LayoutManager getLayout() {
		return null;
	}
	
	public final void refresh() throws Exception {
		/* ================================================== */
		// SwingUtilities.invokeLater(new Runnable() {
		// public void run() {
		// /* ================================================== */
		this._frameAreaMap.clear();
		this._eventMap.clear();
		try {
			/* --------------------------------------------- */
			this.refresh0();
			/* --------------------------------------------- */
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* ================================================== */
		// }
		// });
		/* ================================================== */
	}
	
	public abstract void refresh0() throws Exception;
	
	/**
	 * @param broker
	 * @throws Exception
	 */
	public void setBroker(CalendarModel broker) throws Exception {
		this.broker = broker;
	}
	
	/**
	 * Same method as setBroker
	 * 
	 * @param model
	 */
	public void setModel(CalendarModel model) {
		this.broker = model;
	}
	
	public void addListener(CalendarListener listener) {
		this.listener = listener;
	}
	
	/**
	 * Adds a category defined as an bottom category. Theese categories will
	 * appear "at the bottom" of the screen.
	 * 
	 * Example: "schema"
	 * 
	 * @param aCategory
	 */
	public void addBottomCategory(String aCategory) {
		this.bottomCategories.add(aCategory);
	}
	
	protected void fireDateChanged(Date date) throws Exception {
		if (this.listener != null)
			this.listener.dateChanged(date);
	}
	
	/**
	 * Increases the given DateInterval by one day.
	 * 
	 * @param day
	 * @return
	 * @throws Exception
	 */
	protected DateInterval incDay(DateInterval day) throws Exception {
		/* ================================================== */
		return new DateInterval(new Date(
				day.getStartDate().getTime() + 24 * 3600 * 1000), new Date(
				day.getEndDate().getTime() + 24 * 3600 * 1000));
		/* ================================================== */
	}
	
	protected void fireDateSelected(Date date) throws Exception {
		if (this.listener != null)
			this.listener.dateSelected(date);
	}
	
	protected FrameArea createFrameArea(Object calId, Event event)
			throws Exception {
		FrameArea area = new FrameArea();
		
		area.setEvent(event);
		
		String summary = event.getSummary();
		if (summary != null)
			area.setDescription(summary);
		
		/* ------------------------------------------------------- */
		// construct the headline of the date and the summary
		/* ------------------------------------------------------- */
		DateFormat formatter = DateFormat.getTimeInstance(
				DateFormat.SHORT,
				Locale.getDefault());
		/* ------------------------------------------------------- */
		StringBuffer headLineBuff = new StringBuffer();
		/* ------------------------------------------------------- */
		// add the date if activated
		/* ------------------------------------------------------- */
		if (event.isShowTime()) {
			/* ------------------------------------------------------- */
			headLineBuff.append(formatter.format(event.getStart())
					+ "-"
					+ formatter.format(event.getEnd())
					+ " ");
			/* ------------------------------------------------------- */
		}
		/* ------------------------------------------------------- */
		// add the summary to the headline
		/* ------------------------------------------------------- */
		if (event.getSummary() != null)
			headLineBuff.append(event.getSummary());
		/* ------------------------------------------------------- */
		area.setHeadLine(headLineBuff.toString());
		/* ------------------------------------------------------- */
		// add the description to the description of the framearea
		/* ------------------------------------------------------- */
		if (event.getDescription() != null)
			area.setDescription(event.getDescription());
		
		// if (event.isShowTime()) {
		// area.setHeadLine(format.format(event.getStart()) + "-"
		// + format.format(event.getEnd()));
		// }
		area.setBackground(event.getColor());
		area.setBorder(event.isFrame());
		area.setRoundedRectangle(event.isRoundedCorner());
		area.showHeader(event.showHeader());
		// area.setAlphaValue(event.isFrame() ? 0.4f : 0.3f);
		// area.setAlphaValue(event.isFrame() ? 0.3f : 0.3f);
		// if (event.isBackground())
		// area.setAlphaValue(0.3f);
		if (event.isEditable()) {
			FrameAreaMouseListener mouseListener = new FrameAreaMouseListener(
					area,
					calId,
					event);
			area.addMouseListener(mouseListener);
			area.addMouseMotionListener(mouseListener);
			area.addKeyListener(new FrameAreaKeyListener(event));
			
			InputMap inputMap = area.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap.put(
					KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, true),
					"delete_action");
			inputMap.put(
					KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, true),
					"delete_action");
			inputMap.put(KeyStroke.getKeyStroke(
					KeyEvent.VK_C,
					InputEvent.ALT_MASK,
					true), "complete_action");
			
			ActionMap actionMap = area.getActionMap();
			actionMap.put("delete_action", new ActionDeleteEvents());
			actionMap.put("complete_action", new ActionCompleteEvents());
		}
		if (event.isEditable()) {
			String tip = event.getToolTip();
			area.setToolTipText(tip);
		}
		/* ------------------------------------------------------- */
		// set icons
		area.setIcon(event.getIcon());
		area.setUpperRightIcon(event.getUpperRightIcon());
		/* ------------------------------------------------------- */
		area.setCursor(new Cursor(Cursor.HAND_CURSOR));
		/* ------------------------------------------------------- */
		// set the line distance
		// if (event.get(Event.LINE_DISTANCE) != null)
		try {
			area.setLineDistance((Integer) event.get(Event.LINE_DISTANCE));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		/* ------------------------------------------------------- */
		area.setSelected(this.isSelected(event));
		this.register(calId, event, area);
		return area;
	}
	
	protected void showEventpopup(MouseEvent e, Object calId, Event event)
			throws Exception {
		if (this.popupMenuCallback == null)
			return;
		JPopupMenu popup = this.popupMenuCallback.getEventPopupMenu(
				calId,
				event);
		popup.show(e.getComponent(), e.getX(), e.getY());
	}
	
	protected void showEmptyPopup(MouseEvent e, Object calId) throws Exception {
		if (this.popupMenuCallback == null)
			return;
		Date date = this.getDate(e.getPoint().x, e.getPoint().y);
		JPopupMenu popup = this.popupMenuCallback.getEmptyPopupMenu(calId, date);
		if (popup != null)
			popup.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void setPopupMenuCallback(PopupMenuCallback popupMenuCallback) {
		this.popupMenuCallback = popupMenuCallback;
	}
	
	/**
	 * Returns the estimated height for a time slot
	 * 
	 * @return
	 */
	public int getTimeSlotHeight() {
		/* ================================================== */
		if (this.hLines != null) {
			// find two lines with a y
			Integer y1 = null;
			Integer y2 = null;
			/* ------------------------------------------------------- */
			for (JLabel l : this.hLines) {
				if (l.getY() > 0) {
					if (y1 == null)
						y1 = l.getY();
					else {
						y2 = l.getY();
						break;
					}
				}
			}
			/* ------------------------------------------------------- */
			// compute gap
			if (y1 != null && y2 != null)
				return (-1) * (y1 - y2);
		}
		return -1;
		
		/* ================================================== */
	}
	
	/**
	 * Get the default column width
	 * 
	 * @return
	 */
	private int getColumnWidth() {
		/* ================================================== */
		if (this.vLines != null) {
			/* ------------------------------------------------------- */
			if (this.vLines.size() > 0)
				return this.vLines.get(0).getX();
			
			return this.calPanel.getWidth();
			/* ------------------------------------------------------- */
		}
		return -1;
		/* ================================================== */
	}
	
	/**
	 * Returns the date that was selected by the lasso. if a framearea is
	 * selcted, the date will be the start of the event. Mostly used for copy
	 * paste.
	 * 
	 * @return
	 */
	public Date getSelectionDate() {
		/* ================================================== */
		return this.selectionDate;
		/* ================================================== */
	}
	
	/**
	 * Computes the selection date according the coordinate values
	 * 
	 * @param x
	 * @param y
	 */
	private void setSelectionDate(int x, int y) {
		/* ================================================== */
		try {
			this.setSelectionDate(this.getDate(x, y));
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* ================================================== */
	}
	
	private void setSelectionDate(Date d) {
		/* ================================================== */
		this.selectionDate = d;
		try {
			this.fireDateSelected(this.selectionDate);
		} catch (Exception e) {}
		/* ================================================== */
	}
	
	private class FrameAreaMouseListener extends MouseAdapter implements MouseMotionListener {
		
		private Point _startDrag;
		
		private FrameArea _frameArea;
		
		private Object _calId;
		
		private Event _event;
		
		private Cursor resizeCursor = new Cursor(Cursor.S_RESIZE_CURSOR);
		
		private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
		
		private FrameArea lastCreatedFrameArea = null;
		
		private Integer mouseXold = -1;
		
		private HashMap<Integer, FrameArea> additionalFrames = new HashMap<Integer, FrameArea>();
		
		private List<FrameArea> deletedFrameAreas = Collections.synchronizedList(new ArrayList<FrameArea>());
		
		private boolean _shiftKey = false;
		
		private boolean dragged;
		
		private long lastEventTime = 0;
		
		private FrameArea baseArea;
		
		private Integer lastCreatedKey;
		
		public FrameAreaMouseListener(
				FrameArea frameArea,
				Object calId,
				Event event) {
			/* ================================================== */
			this._frameArea = frameArea;
			this._calId = calId;
			this._event = event;
			/* ================================================== */
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			/* ================================================== */
			CalendarView.isMousePressed = true;
			this.dragged = false;
			this._shiftKey = (e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) != 0;
			/* ------------------------------------------------------- */
			// store the clicked FrameArea
			/* ------------------------------------------------------- */
			if (originalClickedFrameArea == null)
				originalClickedFrameArea = this._frameArea;
			/* ------------------------------------------------------- */
			try {
				/* ------------------------------------------------------- */
				// select the event
				/* ------------------------------------------------------- */
				if (e.getClickCount() == 1 && this._event.isSelectable()) {
					/* ------------------------------------------------------- */
					// FrameArea area = getFrameArea(_calId, _event);
					FrameArea area = this.getBaseArea();
					
					boolean isSelected = area.isSelected();
					/* ------------------------------------------------------- */
					//
					if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) == 0
							&& !isSelected)
						CalendarView.this.deselect();
					/* ------------------------------------------------------- */
					if (!isSelected) {
						CalendarView.this.select(
								this._calId,
								this._event,
								!isSelected);
						CalendarView.this._lassoArea.setVisible(false);
						this._frameArea.requestFocus();
					}
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.eventClicked(
								this._calId,
								this._event,
								area,
								e);
					/* ------------------------------------------------------- */
				}
				if (e.getClickCount() == 2 && this._event.isSelectable()) {
					/* ------------------------------------------------------- */
					CalendarView.this.select(this._calId, this._event, true);
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.eventDoubleClick(
								this._calId,
								this._event,
								e);
					return;
					/* ------------------------------------------------------- */
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			/* ------------------------------------------------------- */
			this._startDrag = e.getPoint();
			/* ------------------------------------------------------- */
			FrameArea baseFrameArea = this.getBaseArea();
			// if (!_frameArea.equals(baseFrameArea)) {
			// baseFrameArea.getMouseListeners()[0].mousePressed(e);
			// return;
			// }
			// fill additional frames
			this.additionalFrames.clear();
			if (baseFrameArea.getChildren() != null)
				for (FrameArea fa : baseFrameArea.getChildren()) {
					this.additionalFrames.put(fa.getX(), fa);
				}
			this.lastCreatedFrameArea = CalendarView.this.findLastFrameArea(baseFrameArea);
			/* ------------------------------------------------------- */
			this.maybeShowPopup(e);
		}
		
		/**
		 * Removes the frame area from the additionalFrames hashmap
		 * 
		 * @param fa
		 */
		private void removeAdditionalArea(FrameArea fa) {
			/* ================================================== */
			List<Integer> keys = new ArrayList<Integer>();
			for (Integer key : this.additionalFrames.keySet())
				if (this.additionalFrames.get(key).equals(fa))
					keys.add(key);
			for (Integer k : keys) {
				this.additionalFrames.remove(k);
			}
			/* ================================================== */
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			/* ================================================== */
			FrameArea baseFrameArea = this.getBaseArea();
			if (!baseFrameArea.equals(this._frameArea)) {
				baseFrameArea.getMouseListeners()[0].mouseReleased(e);
				return;
			}
			/* ------------------------------------------------------- */
			// clear the deleted
			/* ------------------------------------------------------- */
			for (FrameArea fa : this.deletedFrameAreas) {
				fa.setVisible(false);
				CalendarView.this.calPanel.remove(fa);
				this.removeAdditionalArea(fa);
			}
			this.deletedFrameAreas.clear();
			CalendarView.this.getComponent().revalidate();
			/* ------------------------------------------------------- */
			try {
				/* ------------------------------------------------------- */
				if (CalendarView.this.listener != null) {
					if (isResizeable) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						FrameArea fa = CalendarView.this.findLastFrameArea(baseFrameArea);
						if (fa == null)
							fa = baseFrameArea;
						/*
						 * ------------------------------------------------------
						 * -
						 */
						Date movDate = CalendarView.this.getDate(
								fa.getX() + 5,
								fa.getY() + fa.getHeight());
						if (!movDate.equals(this._event.getStart())) {
							CalendarView.this.listener.resized(
									this._event,
									this._calId,
									this._event.getEnd(),
									CalendarView.this.getDate(
											fa.getX() + 5,
											fa.getY() + fa.getHeight()));
						}
						/*
						 * ------------------------------------------------------
						 * -
						 */
					} else {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// if the date has not changed, do nothing
						Date eventDateNew = CalendarView.this.getDate(
								baseFrameArea.getX() + 5,
								baseFrameArea.getY());
						// =============================================================
						// cut the seconds from both dates, they can differ but
						// are not significant for us because we create a
						// calendar
						// and not a scientific timetable
						// =============================================================
						if (this.dragged
								&& !(DateUtil.round2Minute(eventDateNew).equals(DateUtil.round2Minute(this._event.getStart())))) {
							// if (!eventDateNew.equals(_event.getStart())) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							// move
							CalendarView.this.listener.moved(
									this._event,
									this._calId,
									this._event.getStart(),
									this._calId,
									eventDateNew);
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// clicked event for isPopTrigger
						/*
						 * ------------------------------------------------------
						 * -
						 */
						if (e.getClickCount() == 1
								&& this._event.isSelectable()) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							FrameArea area = CalendarView.this.getFrameArea(
									this._calId,
									this._event);
							
							CalendarView.this.listener.eventClicked(
									this._calId,
									this._event,
									area,
									e);
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
					}
				}
				this.maybeShowPopup(e);
				/* ------------------------------------------------------- */
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			this._frameArea.setIsMoving(false);
			
			// reset the original frameArea
			originalClickedFrameArea = null;
			
			CalendarView.isMousePressed = false;
			try {
				CalendarView.this.refresh();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			/* ================================================== */
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			/* ================================================== */
			FrameArea baseFrameArea = this.getBaseArea();
			if (!baseFrameArea.equals(this._frameArea)) {
				baseFrameArea.getMouseListeners()[0].mouseEntered(e);
				return;
			}
			if (!CalendarView.isMousePressed)
				CalendarView.isResizeable = false;
			else
				return;
			/* ------------------------------------------------------- */
			try {
				if (!this._event.isSelectable())
					return;
				if (!this._frameArea.isSelected()) {
					// float alpha = _frameArea.getAlphaValue()+0.2f;
					
					if (this._frameArea.getChildren() != null)
						for (FrameArea fa : this._frameArea.getChildren()) {
							fa.setBrightness(true);
							fa.setBorder(true);
						}
					this._frameArea.setBrightness(true);
					this._frameArea.setBorder(true);
					
					CalendarView.this.calPanel.repaint();
				}
				
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			/* ================================================== */
			FrameArea baseFrameArea = this.getBaseArea();
			if (!baseFrameArea.equals(this._frameArea)) {
				baseFrameArea.getMouseListeners()[0].mouseExited(e);
				return;
			}
			/* ------------------------------------------------------- */
			if (CalendarView.isMousePressed)
				return;
			try {
				if (!this._event.isSelectable() || this._frameArea.isSelected())
					return;
				CalendarView.this.getComponent().setCursor(
						new Cursor(Cursor.DEFAULT_CURSOR));
				
				this._frameArea.setBrightness(false);
				if (this._frameArea.getChildren() != null)
					for (FrameArea fa : this._frameArea.getChildren()) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						fa.setBrightness(false);
						fa.setBorder(false);
						/*
						 * ------------------------------------------------------
						 * -
						 */
					}
				CalendarView.this.calPanel.repaint();
				
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			/* ================================================== */
			FrameArea baseFrameArea = this.getBaseArea();
			if (!baseFrameArea.equals(this._frameArea)) {
				baseFrameArea.getMouseListeners()[0].mouseClicked(e);
				return;
			}
			// ===================================================================
			// Pipe the mouse event to the calendar panel, if the event is
			// a background event. We want to have the selection of a timeslot
			// also available on background events.
			// ===================================================================
			if (this._event.isBackground()) {
				MouseEvent me = new MouseEvent(
						CalendarView.this.calPanel,
						e.getID(),
						e.getWhen(),
						e.getModifiers(),
						e.getX() + this._frameArea.getX(),
						e.getY() + this._frameArea.getY(),
						e.getClickCount(),
						e.isPopupTrigger(),
						e.getButton());
				
				CalendarView.this.calPanel.getMouseListeners()[0].mouseClicked(me);
			}
			/* ------------------------------------------------------- */
			try {
				if (e.getClickCount() == 1) {
					// TODO check
					// if (_event.isSelectable()) {
					// FrameArea area = getFrameArea(_calId, _event);
					// boolean isSelected = area.isSelected();
					// if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) ==
					// 0)
					// deselect();
					// select(_calId, _event, !isSelected);
					// }
				} else if (e.getClickCount() == 2) {
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.showEvent(
								this._calId,
								this._event);
				}
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
		
		private void maybeShowPopup(MouseEvent e) {
			/* ================================================== */
			try {
				if (e.isPopupTrigger()) {
					FrameArea area = CalendarView.this.getFrameArea(
							this._calId,
							this._event);
					if (this._event.isSelectable()) {
						if (!area.isSelected())
							CalendarView.this.deselect();
						CalendarView.this.select(this._calId, this._event, true);
					}
					CalendarView.this.showEventpopup(
							e,
							this._calId,
							this._event);
				}
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
		
		/**
		 * @return the base frame area, the area that is painted first for an
		 *         event
		 */
		private FrameArea getBaseArea() {
			/* ================================================== */
			if (this.baseArea == null)
				this.baseArea = CalendarView.this.frameAreaHash.get(this._event);
			return this.baseArea;
			/* ================================================== */
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			/* ================================================== */
			// filter events by time
			// to not let every drag position fire a new computation
			/* ------------------------------------------------------- */
			if (this.lastEventTime == 0)
				this.lastEventTime = System.currentTimeMillis();
			else {
				long current = System.currentTimeMillis();
				if ((current - this.lastEventTime) < 15) {
					return;
				}
				this.lastEventTime = current;
			}
			
			/* ------------------------------------------------------- */
			// get the baseframe and set dragged = true
			// to enable multiday events to be moved by dragging
			// all frameareas of this event
			/* ------------------------------------------------------- */
			FrameArea baseFrameArea = this.getBaseArea();
			
			try {
				((FrameAreaMouseListener) baseFrameArea.getMouseListeners()[0]).dragged = true;
			} catch (Exception ex) {}
			
			this.dragged = true;
			//
			// if (!baseFrameArea.equals(_frameArea)) {
			// e.setSource(baseFrameArea);
			// baseFrameArea.getMouseMotionListeners()[0].mouseDragged(e);
			// return;
			// }
			try {
				/* ------------------------------------------------------- */
				// DEBUG
				// setMousePos(e);
				/* ------------------------------------------------------- */
				// resizing
				/* ------------------------------------------------------- */
				if (CalendarView.isResizeable) {
					// TimeTracker.start("resize");
					this.resizeDrag(baseFrameArea, e);
					/* ------------------------------------------------------- */
					// TimeTracker.finish("resize");
				}
				// ######################################################################################
				// ######################################################################################
				// ===============================================================
				// Non - Resizing --> Moving
				//
				// ==============================================================
				else {
					/* ------------------------------------------------------- */
					this.moveDrag(baseFrameArea, e);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			// this.mouseXold = e.getPoint().x;
			// TimeTracker.finish(tracker);
			/* ------------------------------------------------------- */
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			/* ================================================== */
			FrameArea baseFrameArea = CalendarView.this.frameAreaHash.get(this._event);
			// if (!baseFrameArea.equals(_frameArea)) {
			// baseFrameArea.getMouseMotionListeners()[0].mouseMoved(e);
			// return;
			// }
			/* ------------------------------------------------------- */
			
			/* ------------------------------------------------------- */
			FrameArea areaToChange = null;
			areaToChange = CalendarView.this.findLastFrameArea(baseFrameArea);
			/* ------------------------------------------------------- */
			if (areaToChange == null)
				areaToChange = baseFrameArea;
			// if mouse is at the bottom, switch to resize mode
			
			if (!areaToChange.getCursor().equals(this.resizeCursor)) {
				if (e.getPoint().y > areaToChange.getHeight() - 15) {
					/* ------------------------------------------------------- */
					// this is the latest frame area
					if (e.getSource().equals(areaToChange)) {
						areaToChange.setCursor(this.resizeCursor);
						CalendarView.isResizeable = true;
						e.consume();
						return;
					}
					/* ------------------------------------------------------- */
				}
			} else {
				if (!areaToChange.getCursor().equals(this.handCursor)) {
					if (e.getPoint().y < areaToChange.getHeight() - 15) {
						areaToChange.setCursor(this.handCursor);
						CalendarView.isResizeable = false;
						e.consume();
						return;
					}
				}
			}
			
			/* ================================================== */
		}
		
		/**
		 * 
		 */
		private void moveDrag(FrameArea baseFrameArea, MouseEvent e) {
			/* ================================================== */
			// **************************************************************************
			//
			// compute values for detecting the crossing of a vertical line
			//
			/* ------------------------------------------------------- */
			int currX = this._frameArea.getX();
			// int currY = _frameArea.getY();
			int currWidth = this._frameArea.getWidth();
			/* ------------------------------------------------------- */
			int nextSmaller = CalendarView.this.findNextSmallerVerticalLine(currX
					+ LINE_OFFSET);
			int nextGreater = CalendarView.this.findNextGreaterVerticalLine(currX
					+ LINE_OFFSET);
			/* ------------------------------------------------------- */
			int gap2left = currX - nextSmaller;
			int gap2right = nextGreater - currX - currWidth;
			// **************************************************************************
			
			baseFrameArea.setIsMoving(true);
			// horizontal moving
			Integer newXPos = null;
			// <-----
			if (e.getPoint().x < 0) {
				/* ------------------------------------------------------- */
				// mousepointer has left the event to the left
				// compute the crossing of a vertical line
				if ((gap2left + e.getPoint().x) < 0) {
					// move to day before
					newXPos = CalendarView.this.findNextSmallerVerticalLine(baseFrameArea.getX() - 5);
					// smaller
				}
				/* ------------------------------------------------------- */
			} else {
				// ---->
				if (e.getPoint().x > currWidth)
					if (e.getPoint().x > currWidth + gap2right) {
						// /*
						// -------------------------------------------------------
						// */
						newXPos = CalendarView.this.findNextGreaterVerticalLine(baseFrameArea.getX());
						// greater
					}
				/* ------------------------------------------------------- */
			}
			
			if (newXPos != null
					&& newXPos <= CalendarView.this.calPanel.getX()
							+ CalendarView.this.calPanel.getWidth()) {
				/* ------------------------------------------------------- */
				// System.out.println("Moving <----> "+newXPos);
				int y = baseFrameArea.getY();
				int width = baseFrameArea.getWidth();
				int height = baseFrameArea.getHeight();
				
				baseFrameArea.setBounds(newXPos, y, width, height);
				// move additional frames
				//
				if (baseFrameArea.getChildren() != null
						&& baseFrameArea.getChildren().size() > 0) {
					/* ------------------------------------------------------- */
					int countX = 1;
					for (FrameArea ac : baseFrameArea.getChildren()) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						int acNewX = baseFrameArea.getX();
						for (int i = 0; i < countX; i++) {
							acNewX = CalendarView.this.findNextGreaterVerticalLine(acNewX);
						}
						/*
						 * ------------------------------------------------------
						 * -
						 */
						countX++;
						// int acNewX =
						// findNextSmallerVerticalLine(ac.getX()-5);
						ac.setBounds(acNewX, ac.getY(),
						// ac.getWidth(),
								width,
								ac.getHeight());
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// }
					}
				}
			} else {
				/* ------------------------------------------------------- */
				// vertical move
				// try {
				// System.out.println("k: " + _startDrag.y + " - " +
				// e.getPoint().y);
				// } catch (Exception ex) {
				// ex.printStackTrace();
				// }
				int diffPoint = (this._startDrag.y - e.getPoint().y);
				if (Math.abs(diffPoint) > CalendarView.this.getTimeSlotHeight()
						|| this._shiftKey) {
					/* ------------------------------------------------------- */
					int mov;
					// move without the line steps
					if (this._shiftKey)
						mov = Math.abs(diffPoint);
					else
						mov = CalendarView.this.getTimeSlotHeight();
					/* ------------------------------------------------------- */
					if (this._startDrag.y > e.getPoint().y) {
						mov = mov * (-1) - 1;
					}
					/* ------------------------------------------------------- */
					if (baseFrameArea.getY() + mov >= CalendarView.this.calPanel.getY()) {
						baseFrameArea.setBounds(
								baseFrameArea.getX(),
								baseFrameArea.getY() + mov,
								baseFrameArea.getWidth(),
								baseFrameArea.getHeight());
						
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// find last frame
						FrameArea lastArea = CalendarView.this.findLastFrameArea(baseFrameArea);
						// if the event lasts longer than a day
						if (baseFrameArea.getChildren() != null
								&& baseFrameArea.getChildren().size() > 0) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							// set the height of the base frame area to
							// the panels bottom
							baseFrameArea.setBounds(
									baseFrameArea.getX(),
									baseFrameArea.getY(),
									baseFrameArea.getWidth(),
									CalendarView.this.calPanel.getHeight()
											- baseFrameArea.getY());
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
						if (lastArea != null)
							lastArea.setBounds(
									lastArea.getX(),
									lastArea.getY(),
									lastArea.getWidth(),
									lastArea.getHeight() + mov);
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// recall the mousedragged event to the current
						// frame area if
						// this is not the first one, in order to update
						// the _startDrag
						// member
						// is this an evil hack?
						if (!this._frameArea.equals(baseFrameArea))
							this.mousePressed(e);
						/*
						 * ------------------------------------------------------
						 * -
						 */
					}
				}
			}
			try {
				this._frameArea.setMovingTimeString(CalendarView.this.getDate(
						this._frameArea.getX(),
						this._frameArea.getY()), CalendarView.this.getDate(
						this._frameArea.getX(),
						this._frameArea.getY() + this._frameArea.getHeight()));
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			/* ================================================== */
		}
		
		/**
		 * 
		 */
		private void resizeDrag(FrameArea baseFrameArea, MouseEvent e) {
			/* ================================================== */
			// **************************************************************************
			//
			// compute values for detecting the crossing of a vertical line
			//
			/* ------------------------------------------------------- */
			int currX = this._frameArea.getX();
			int currY = this._frameArea.getY();
			int currWidth = this._frameArea.getWidth();
			/* ------------------------------------------------------- */
			int nextSmaller = CalendarView.this.findNextSmallerVerticalLine(currX
					+ LINE_OFFSET);
			int nextGreater = CalendarView.this.findNextGreaterVerticalLine(currX
					+ LINE_OFFSET);
			/* ------------------------------------------------------- */
			int gap2leftColumn = currX - nextSmaller;
			int gap2rightColumn = nextGreater - currX - currWidth;
			// **************************************************************************
			
			baseFrameArea.setIsMoving(true);
			/* ------------------------------------------------------- */
			// try to make a new frame for a new day
			// or remove one
			// ###################################################################################
			// Adjustments for the current area
			// we assume, that it can only be the last child of the base area
			// that is in current state
			// to be resized.
			/* ------------------------------------------------------- */
			// if the baseFramearea owns some children, we take the last one as
			// current
			/* ------------------------------------------------------- */
			FrameArea currentArea = this._frameArea;
			Point currentPoint = e.getPoint();
			
			if (baseFrameArea.getChildren() != null
					&& baseFrameArea.getChildren().size() > 0) {
				/* ------------------------------------------------------- */
				currentArea = baseFrameArea.getChildren().get(
						baseFrameArea.getChildren().size() - 1);
				/* ------------------------------------------------------- */
				// convert the point from the mouseevent to the coordinate
				// system of the
				// current area
				/* ------------------------------------------------------- */
				currentPoint = convertPoint(
						e.getPoint(),
						this._frameArea,
						currentArea);
				/* ------------------------------------------------------- */
			} else if (!this._frameArea.isVisible()) {
				currentArea = baseFrameArea;
				currentPoint = convertPoint(
						e.getPoint(),
						this._frameArea,
						currentArea);
			}
			/* ------------------------------------------------------- */
			currX = currentArea.getX();
			currY = currentArea.getY();
			
			currWidth = currentArea.getWidth();
			gap2leftColumn = currX
					- CalendarView.this.findNextSmallerVerticalLine(currX
							+ LINE_OFFSET);
			gap2rightColumn = CalendarView.this.findNextGreaterVerticalLine(currX
					+ LINE_OFFSET)
					- currX
					- currWidth;
			// int pY =
			// findNextGreaterHorizontalLinePos(e.getPoint().y);
			/* ------------------------------------------------------- */
			// ensure, that the event area is at least as small as the
			// time slot height!
			/* ------------------------------------------------------- */
			if ((currentArea.getHeight() + currentPoint.y) < CalendarView.this.desc.getMinimumTimeSlotHeight()
					|| (currentArea.getHeight() + currentPoint.y) < CalendarView.this.getTimeSlotHeight()) {
				/* ------------------------------------------------------- */
				return;
				/* ------------------------------------------------------- */
			}
			// ###################################################################################
			
			/* ------------------------------------------------------- */
			// if the mouse pointer is not in the column of the clicked
			// frame area, we must check if we must delete or create new/old
			// FrameAreas
			//
			// e.getX() is relative to the boundaries of the clicked component.
			// So,
			// if the mousepointer is moved to the left out of the bounds,
			// the e.getX() will return a negative value.
			// Therefore, when the gap to the left column plus the (eventually)
			// negative
			// value of e.getX() if smaller than 0, we are in a column left to
			// the clicked
			// framearea. The same way for the other direction.
			//
			// gap2leftColumn/gap2rightColumn must be computed because we can
			// not ashure, that the
			// framearea is exactly that width as the column. e.G. if there are
			// overlapping events.
			/* ------------------------------------------------------- */
			if ((gap2leftColumn + currentPoint.x) < 0
					|| (currentPoint.x > currWidth + gap2rightColumn)) {
				/* ------------------------------------------------------- */
				// remove the last frame area, if the mouseX is smaller
				// than the boundX
				// ======================================================================
				// ======================================================================
				// <---- Resize DIRECTION
				//
				// ======================================================================
				// ======================================================================
				if (gap2leftColumn + currentPoint.x < 0) {
					/* ------------------------------------------------------- */
					// System.out.println("Direction <-----");
					// remove all areas that are greater than the
					// mousepointer
					if (baseFrameArea.getChildren() != null) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						List<FrameArea> deleteAreas = new ArrayList<FrameArea>();
						for (FrameArea fa : baseFrameArea.getChildren()) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							if (fa.getX() > CalendarView.this.findNextSmallerVerticalLine(currX
									+ currentPoint.x)) {
								// remove
								// we can not remove them from the
								// panel,
								// because we need the mouselistener
								// until the mouse released event
								fa.setVisible(false);
								deleteAreas.add(fa);
								this.deletedFrameAreas.add(fa);
								// removeAdditionalArea(fa);
							}
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
						// delete from the parent
						baseFrameArea.getChildren().removeAll(deleteAreas);
						// if (lastArea != null)
						// lastArea.getMouseMotionListeners()[0]
						// .mouseDragged(e);
					}
					/* ------------------------------------------------------- */
				} else {
					/* ------------------------------------------------------- */
					// ----> Resize DIRECTION
					//
					// remove the new areas
					/* ------------------------------------------------------- */
					// System.out.println("Direction ===>");
					// FrameArea currLast = findLastFrameArea(baseFrameArea);
					// currLast.setBounds(
					// currLast.getX(),
					// 0,
					// currWidth,
					// calPanel.getMaximumSize().height);
					// if (currLast != null && currX + gap2rightColumn +
					// currentPoint.x < currLast
					// .getX()) {
					// System.out.println("Wohoo unreachable code reached. Damn your so good.");
					// /*
					// -------------------------------------------------------
					// */
					// // we can not remove them from the panel,
					// // because we need the mouselistener
					// // until mouse released event
					// /*
					// -------------------------------------------------------
					// */
					// currLast.setVisible(false);
					// deletedFrameAreas.add(currLast);
					// System.out.println("     Deleted Area");
					// /*
					// -------------------------------------------------------
					// */
					// }
					
					// ##########################################################
					//
					// create new frame areas, if needed!
					/* ------------------------------------------------------- */
					// else
					{
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// if the mouse pointer has crossed the next
						// vertical line
						/*
						 * ------------------------------------------------------
						 * -
						 */
						int crossPoint = 0;
						crossPoint = currentPoint.x;
						//
						// if
						// (baseFrameArea.equals(CalendarView.originalClickedFrameArea))
						// {
						// crossPoint = currentPoint.x;
						// System.out.println("=============== Using currenPoint");
						// }
						// else {
						// crossPoint = currentPoint.x
						// + CalendarView.originalClickedFrameArea
						// .getX();
						// System.out.println("=============== Using originalPoint");
						// }
						/*
						 * ------------------------------------------------------
						 * -
						 */
						if (crossPoint > currWidth + gap2rightColumn) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							List<Integer> newLines = null;
							newLines = CalendarView.this.findUndrawnLines(
									currX + this.mouseXold,
									currX + currentPoint.x,
									baseFrameArea.getX());
							/*
							 * --------------------------------------------------
							 * -----
							 */
							if (newLines != null && newLines.size() > 0) {
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								// create new frame areas for each line
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								currentArea.setBounds(
										currentArea.getX(),
										0,
										currWidth,
										CalendarView.this.calPanel.getMaximumSize().height);
								for (Integer i : newLines) {
									/*
									 * ------------------------------------------
									 * -------------
									 */
									// if frame is present, continue
									if (this.additionalFrames.containsKey(i)) {
										/*
										 * --------------------------------------
										 * -----------------
										 */
										FrameArea afa = this.additionalFrames.get(i);
										/*
										 * --------------------------------------
										 * -----------------
										 */
										if (afa.isVisible()) {
											// afa.setBounds(afa.getX(),
											// 0,
											// currWidth,20);
											this.lastCreatedFrameArea = afa;
											continue;
										}
										if (!baseFrameArea.getChildren().contains(
												afa)) {
											/*
											 * ----------------------------------
											 * ---------------------
											 */
											baseFrameArea.addChild(afa);
											if (this.deletedFrameAreas.contains(afa))
												this.deletedFrameAreas.remove(afa);
											/*
											 * ----------------------------------
											 * ---------------------
											 */
										}
										// System.out.println("Setting available frame visible "
										// + i);
										afa.setVisible(true);
										afa.setBounds(
												afa.getX(),
												0,
												currWidth,
												CalendarView.this.calPanel.getMaximumSize().height);
										// System.out.println("MAX -> old " +
										// findNextGreaterVerticalLine(calPanel.getMaximumSize().height));
										this.lastCreatedFrameArea = afa;
										continue;
										/*
										 * --------------------------------------
										 * -----------------
										 */
									}
									/*
									 * ------------------------------------------
									 * -------------
									 */
									// create a new FrameArea
									FrameArea fa = new FrameArea();
									fa.setBounds(
											i,
											0,
											currWidth,
											CalendarView.this.findNextGreaterHorizontalLinePos(currY
													+ currentPoint.y));
									fa.setEvent(this._event);
									
									/*
									 * ------------------------------------------
									 * -------------
									 */
									CalendarView.this.calPanel.add(
											fa,
											Integer.valueOf(3));
									CalendarView.this.calPanel.validate();
									CalendarView.this.calPanel.updateUI();
									fa.setVisible(true);
									this.additionalFrames.put(i, fa);
									baseFrameArea.addChild(fa);
									
									/*
									 * ------------------------------------------
									 * -------------
									 */
									if (this.lastCreatedFrameArea != null) {
										/*
										 * --------------------------------------
										 * -----------------
										 */
										this.lastCreatedFrameArea.setBounds(
												this.lastCreatedFrameArea.getX(),
												0,
												currWidth,
												CalendarView.this.calPanel.getMaximumSize().height);
										// System.out.println("MAX -> new");
									}
									this.lastCreatedFrameArea = fa;
									this.lastCreatedKey = i;
									currentPoint = convertPoint(
											currentPoint,
											currentArea,
											fa);
									currentArea = fa;
									/*
									 * ------------------------------------------
									 * -------------
									 */
								}
							}
							
							/*
							 * --------------------------------------------------
							 * -----
							 */
						} // if
					} // else
				}// else
				/* ------------------------------------------------------- */
				// if (_frameArea != currentArea) {
				// _frameArea.setBounds(_frameArea.getX(), _frameArea.getX(),
				// _frameArea.getWidth(),
				// 800);
				// System.out.println("adjusting _frameArea "+_frameArea.getX()
				// + " -- " +_frameArea.getHeight() );
				// }
				/* ------------------------------------------------------- */
				// if (baseFrameArea.getChildren() != null &&
				// baseFrameArea.getChildren().size() > 1) {
				// FrameArea last = findLastFrameArea(baseFrameArea);
				// for (FrameArea fa : baseFrameArea.getChildren()) {
				// if (!fa.equals(last))
				// if (fa.getHeight() <= calPanel.getMaximumSize().height)
				// fa.setBounds(fa.getX(), fa.getY(), fa.getWidth(),
				// calPanel.getMaximumSize().height);
				// }
				// }
				
				/* ------------------------------------------------------- */
			} else {
				/* ------------------------------------------------------- */
				// the mouse pointer is in the same column as the original
				// dragged frame area and we must "only" adjust the bounds of
				// this
				// frame are
				/* ------------------------------------------------------- */
				// ==============================================================================
				// compute height
				// if shift is pressed, we take the current mouse y position
				// as new height.
				// otherwise we will use normal step wise height
				// ==============================================================================
				
				int newHeight = 0;
				if (this._shiftKey)
					newHeight = currentPoint.y;
				else
					newHeight = CalendarView.this.findNextGreaterHorizontalLinePos(currentPoint.y);
				
				currentArea.setBounds(currX, currY, currWidth, newHeight);
				// System.out.println("resizing " + newHeight);
			}
			// ==============================================================================
			// compute height
			// if shift is pressed, we take the current mouse y position
			// as new height.
			// otherwise we will use normal step wise height
			// ==============================================================================
			
			// int newHeight = 0;
			// if (_shiftKey)
			// newHeight = currentPoint.y;
			// else
			// newHeight = findNextGreaterHorizontalLinePos(currentPoint.y);
			
			// /* ------------------------------------------------------- */
			// // set bounds of the base frame area
			// if (baseFrameArea.getChildren() == null
			// || baseFrameArea.getChildren().size() < 1) {
			// /* ------------------------------------------------------- */
			// // adjust bounds only if there are changes -->
			// // performance
			// if (baseFrameArea.getHeight() != newHeight) {
			// /* ------------------------------------------------------- */
			// if (baseFrameArea.equals(CalendarView.originalClickedFrameArea))
			// {
			// baseFrameArea.setBounds(baseFrameArea.getX(),
			// baseFrameArea.getY(),
			// currWidth,
			// newHeight);
			// } else {
			// baseFrameArea.setBounds(baseFrameArea.getX(),
			// baseFrameArea.getY(),
			// currWidth,
			// findNextGreaterHorizontalLinePos(
			// currentPoint.y));
			// }
			// /* ------------------------------------------------------- */
			// }
			// /* ------------------------------------------------------- */
			// } else {
			// /* ------------------------------------------------------- */
			// // set baseframe height to max
			// /* ------------------------------------------------------- */
			// if (baseFrameArea.getHeight() != calPanel
			// .getMaximumSize().height)
			// baseFrameArea.setBounds(
			// baseFrameArea.getX(), baseFrameArea
			// .getY(), currWidth, calPanel
			// .getMaximumSize().height);
			// /* ------------------------------------------------------- */
			//
			// int diffPoint = (_startDrag.y - currentPoint.y);
			// FrameArea lfa = findLastFrameArea(baseFrameArea);
			// if (Math.abs(diffPoint) > getTimeSlotHeight()) {
			// /* ------------------------------------------------------- */
			// int mov = getTimeSlotHeight();
			// if (_startDrag.y > currentPoint.y) {
			// mov = mov * (-1);
			// }
			// /* ------------------------------------------------------- */
			// // make sure that the new boundaries are inside the
			// // calendar panel
			// if (baseFrameArea.getY() + mov >= calPanel.getY()) {
			// // FrameArea lfa = findLastFrameArea(baseFrameArea);
			// /* ------------------------------------------------------- */
			// if (lfa != null) {
			// /* ------------------------------------------------------- */
			// lfa.setBounds(
			// lfa.getX(),
			// lfa.getY(),
			// currWidth,
			// findNextGreaterHorizontalLinePos(currY
			// + currentPoint.y) - 1);
			// /* ------------------------------------------------------- */
			// }
			// /* ------------------------------------------------------- */
			// }
			// }
			// /* ------------------------------------------------------- */
			// // set all but the last children to max size
			// /* ------------------------------------------------------- */
			// // FrameArea lastArea = findLastFrameArea(baseFrameArea);
			// for (FrameArea fa : baseFrameArea.getChildren()) {
			// if (!fa.equals(lfa)) {
			// /* ------------------------------------------------------- */
			// fa.setBounds(fa.getX(), 0, fa.getWidth(),
			// calPanel.getMaximumSize().height);
			// /* ------------------------------------------------------- */
			// }
			// }
			// /* ------------------------------------------------------- */
			// }
			
			// this.mouseXold = currentPoint.x;
			// /* ------------------------------------------------------- */
			// // hide the deleted frame areas
			// /* ------------------------------------------------------- */
			// for (FrameArea hfa : deletedFrameAreas)
			// hfa.setVisible(false);
			//
			// FrameArea tempLast = null;
			// try {
			// tempLast = findLastFrameArea(baseFrameArea);
			// if (tempLast == null)
			// tempLast = baseFrameArea;
			// } catch (Exception e1) {
			// tempLast = baseFrameArea;
			// // e1.printStackTrace();
			// }
			//
			// enableCommit(baseFrameArea, true);
			// baseFrameArea.commitBounds();
			// if (baseFrameArea.getChildren() != null)
			// for (FrameArea f : baseFrameArea.getChildren())
			// f.commitBounds();
			//
			// // tempLast.setMovingTimeString(getDate(baseFrameArea
			// // .getX(), baseFrameArea.getY()),
			// // getDate(tempLast.getX(), tempLast
			// // .getY()
			// // + tempLast.getHeight()));
			/* ================================================== */
		}
		
	}
	
	/**
	 * This is the key listener that is attached to each FrameArea.
	 * It handles the copy/paste things
	 * 
	 * @author martin.heinemann@tudor.lu
	 *         20.06.2007
	 *         09:23:04
	 * 
	 * 
	 * @version
	 * <br>
	 *          $Log: CalendarView.java,v $ <br>
	 *          Revision 1.37 2008/10/30 10:42:52 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.36 2008/10/21 15:08:31 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.35 2008/10/09 12:33:09 heine_ <br>
	 *          shows now the summary of an event in the header of a FrameArea
	 *          and the the description is now in the body. <br>
	 * <br>
	 *          Revision 1.34 2008/08/12 12:47:27 heine_ <br>
	 *          fixed some bugs and made code improvements <br>
	 * <br>
	 *          Revision 1.33 2008/06/19 12:20:00 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.32 2008/06/10 13:16:36 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.31 2008/06/09 14:10:09 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.30 2008/05/30 11:36:47 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.29 2008/05/26 08:15:31 heine_ <br>
	 *          removed MainThread locking by swing worker thread <br>
	 * <br>
	 *          Revision 1.28 2008/04/24 14:17:37 heine_ <br>
	 *          Improved timeslot search when clicking and moving <br>
	 * <br>
	 *          Revision 1.27 2008/04/08 13:17:53 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.26 2008/03/28 08:45:12 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.25 2008/03/21 15:02:35 heine_ <br>
	 *          fixed problem when selecting lasso area in a region that was in
	 *          the bottom of the panel. <br>
	 * <br>
	 *          Removed all the evil getBounds() statements. Should run fast now
	 *          and use lesser heap. <br>
	 * <br>
	 *          Revision 1.24 2008/01/21 14:13:26 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.37 2008-01-21 14:06:22 heinemann <br>
	 *          code cleanup and java doc <br>
	 * 
	 */
	private class FrameAreaKeyListener extends KeyAdapter {
		
		@SuppressWarnings("unused")
		private Event _event;
		
		public FrameAreaKeyListener(Event event) {
			this._event = event;
		}
		
		@Override
		public void keyTyped(KeyEvent event) {
			
		}
		
		@Override
		public void keyPressed(KeyEvent event) {
			/* ================================================== */
			try {
				/* ------------------------------------------------------- */
				// copy
				if ((event.isControlDown())
						&& (event.getKeyCode() == KeyEvent.VK_C)) {
					/* ------------------------------------------------------- */
					CalendarView.this.copy();
					/* ------------------------------------------------------- */
				}
				// paste
				if ((event.isControlDown())
						&& (event.getKeyCode() == KeyEvent.VK_V)) {
					/* ------------------------------------------------------- */
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.paste(
								null,
								CalendarView.this.getSelectionDate());
					/* ------------------------------------------------------- */
				}
				// delete
				if (event.getKeyCode() == KeyEvent.VK_DELETE
						|| event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					/* ------------------------------------------------------- */
					// if (CalendarView.this.listener != null)
					// CalendarView.this.listener.deleteEvents(CalendarView.this._selectedEvents);
					/* ------------------------------------------------------- */
				}
			} catch (Exception exc) {
				/* ------------------------------------------------------- */
				throw BizcalException.create(exc);
				/* ------------------------------------------------------- */
			}
			/* ================================================== */
		}
		
		@Override
		public void keyReleased(KeyEvent event) {}
	}
	
	private class ActionDeleteEvents extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			try {
				if (CalendarView.this.listener != null)
					CalendarView.this.listener.deleteEvents(CalendarView.this._selectedEvents);
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
		}
		
	}
	
	private class ActionCompleteEvents extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			try {
				if (CalendarView.this.listener != null)
					CalendarView.this.listener.completeEvents(CalendarView.this._selectedEvents);
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
		}
		
	}
	
	/**
	 * This keylistener is for the underlying panel on which all FrameAreas are
	 * painted.
	 * 
	 * @author martin.heinemann@tudor.lu
	 *         20.06.2007
	 *         10:16:34
	 * 
	 * 
	 * @version
	 * <br>
	 *          $Log: CalendarView.java,v $ <br>
	 *          Revision 1.37 2008/10/30 10:42:52 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.36 2008/10/21 15:08:31 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.35 2008/10/09 12:33:09 heine_ <br>
	 *          shows now the summary of an event in the header of a FrameArea
	 *          and the the description is now in the body. <br>
	 * <br>
	 *          Revision 1.34 2008/08/12 12:47:27 heine_ <br>
	 *          fixed some bugs and made code improvements <br>
	 * <br>
	 *          Revision 1.33 2008/06/19 12:20:00 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.32 2008/06/10 13:16:36 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.31 2008/06/09 14:10:09 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.30 2008/05/30 11:36:47 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.29 2008/05/26 08:15:31 heine_ <br>
	 *          removed MainThread locking by swing worker thread <br>
	 * <br>
	 *          Revision 1.28 2008/04/24 14:17:37 heine_ <br>
	 *          Improved timeslot search when clicking and moving <br>
	 * <br>
	 *          Revision 1.27 2008/04/08 13:17:53 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.26 2008/03/28 08:45:12 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.25 2008/03/21 15:02:35 heine_ <br>
	 *          fixed problem when selecting lasso area in a region that was in
	 *          the bottom of the panel. <br>
	 * <br>
	 *          Removed all the evil getBounds() statements. Should run fast now
	 *          and use lesser heap. <br>
	 * <br>
	 *          Revision 1.24 2008/01/21 14:13:26 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.37 2008-01-21 14:06:22 heinemann <br>
	 *          code cleanup and java doc <br>
	 * 
	 */
	protected class ThisKeyListener extends KeyAdapter {
		
		private int SHIFT = 16;
		private int CTRL = 17;
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent event) {
			/* ================================================== */
			// set cursor for lasso
			if (event.getKeyCode() == this.SHIFT) {
				CalendarView.this.getComponent().setCursor(
						new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
			try {
				/* ------------------------------------------------------- */
				// copy
				if ((event.isControlDown())
						&& (event.getKeyCode() == KeyEvent.VK_C)) {
					/* ------------------------------------------------------- */
					CalendarView.this.copy();
					/* ------------------------------------------------------- */
				}
				// paste
				if ((event.isControlDown())
						&& (event.getKeyCode() == KeyEvent.VK_V)) {
					/* ------------------------------------------------------- */
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.paste(
								null,
								CalendarView.this.getSelectionDate());
					/* ------------------------------------------------------- */
				}
			} catch (Exception exc) {
				/* ------------------------------------------------------- */
				throw BizcalException.create(exc);
				/* ------------------------------------------------------- */
			}
			/* ================================================== */
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent event) {
			/* ================================================== */
			try {
				if (event.getKeyCode() == this.SHIFT
						|| event.getKeyCode() == this.CTRL)
					CalendarView.this.getComponent().setCursor(null);
				
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
	}
	
	/**
	 * @param xPos
	 * @param yPos
	 * @return
	 * @throws Exception
	 */
	protected abstract Date getDate(int xPos, int yPos) throws Exception;
	
	/**
	 * @author martin.heinemann@tudor.lu
	 *         20.06.2007
	 *         10:16:25
	 * 
	 * 
	 * @version
	 * <br>
	 *          $Log: CalendarView.java,v $ <br>
	 *          Revision 1.37 2008/10/30 10:42:52 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.36 2008/10/21 15:08:31 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.35 2008/10/09 12:33:09 heine_ <br>
	 *          shows now the summary of an event in the header of a FrameArea
	 *          and the the description is now in the body. <br>
	 * <br>
	 *          Revision 1.34 2008/08/12 12:47:27 heine_ <br>
	 *          fixed some bugs and made code improvements <br>
	 * <br>
	 *          Revision 1.33 2008/06/19 12:20:00 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.32 2008/06/10 13:16:36 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.31 2008/06/09 14:10:09 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.30 2008/05/30 11:36:47 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.29 2008/05/26 08:15:31 heine_ <br>
	 *          removed MainThread locking by swing worker thread <br>
	 * <br>
	 *          Revision 1.28 2008/04/24 14:17:37 heine_ <br>
	 *          Improved timeslot search when clicking and moving <br>
	 * <br>
	 *          Revision 1.27 2008/04/08 13:17:53 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.26 2008/03/28 08:45:12 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.25 2008/03/21 15:02:35 heine_ <br>
	 *          fixed problem when selecting lasso area in a region that was in
	 *          the bottom of the panel. <br>
	 * <br>
	 *          Removed all the evil getBounds() statements. Should run fast now
	 *          and use lesser heap. <br>
	 * <br>
	 *          Revision 1.24 2008/01/21 14:13:26 heine_ <br>
	 *          *** empty log message *** <br>
	 * <br>
	 *          Revision 1.37 2008-01-21 14:06:22 heinemann <br>
	 *          code cleanup and java doc
	 * 
	 */
	protected class ThisMouseListener extends MouseAdapter implements MouseMotionListener {
		
		private Point _startDrag;
		
		private boolean _dragging = false;
		
		private boolean _lasso = true;
		
		private Object _dragCalId = null;
		
		private int currPos = 0;
		
		private HashMap<Integer, FrameArea> additionalFrames = new HashMap<Integer, FrameArea>();
		
		private FrameArea lastCreatedFrameArea = null;
		
		private Integer lastCreatedKey = null;
		
		private int mouseXold = -1;
		
		private int startDragMouseY = -1;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			/* ================================================== */
			try {
				if (e.getClickCount() < 2) {
					/* ------------------------------------------------------- */
					// set the lasso area to the clicked cell
					int lx = CalendarView.this.findNextSmallerVerticalLine(e.getX());
					int ly = CalendarView.this.findNextSmallerHorizontalLinePos(e.getY());
					int lwidth = CalendarView.this.findNextGreaterVerticalLine(e.getX())
							- lx;
					int lheight = CalendarView.this.getTimeSlotHeight();
					CalendarView.this._lassoArea.setBounds(
							lx,
							ly,
							lwidth,
							lheight);
					CalendarView.this.setSelectionDate(lx + (lwidth / 2), ly);
					
					CalendarView.this._lassoArea.setVisible(true);
					/* ------------------------------------------------------- */
				} else {
					/* ------------------------------------------------------- */
					// on double click, create a new event
					/* ------------------------------------------------------- */
					// the date is in the range of the lasso area
					/* ------------------------------------------------------- */
					int newY = CalendarView.this.findNextSmallerHorizontalLinePos(e.getPoint().y);
					
					// Date date = getDate( e.getPoint().x, e.getPoint().y);
					Date date = CalendarView.this.getDate(e.getPoint().x, newY);
					Object id = CalendarView.this.getCalendarId(
							e.getPoint().x,
							e.getPoint().y);
					if (CalendarView.this.listener == null)
						return;
					if (!CalendarView.this.getModel().isInsertable(id, date))
						return;
					CalendarView.this.listener.newEvent(id, date);
					/* ------------------------------------------------------- */
				}
				/* ------------------------------------------------------- */
			} catch (Exception exc) {
				ErrorHandler.handleError(exc);
			}
			/* ================================================== */
		}
		
		private void maybeShowPopup(MouseEvent e) {
			try {
				if (e.isPopupTrigger()) {
					Object id = CalendarView.this.getCalendarId(
							e.getPoint().x,
							e.getPoint().y);
					CalendarView.this.showEmptyPopup(e, id);
				}
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			/* ================================================== */
			try {
				CalendarView.this.deselect();
				this._startDrag = e.getPoint();
				this._dragCalId = CalendarView.this.getCalendarId(
						e.getPoint().x,
						e.getPoint().y);
				this._lasso = (e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) != 0;
				this.maybeShowPopup(e);
				
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
			this.startDragMouseY = CalendarView.this.findNextSmallerHorizontalLinePos(e.getPoint().y);
			/* ================================================== */
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			/* ================================================== */
			try {
				/* ------------------------------------------------------- */
				this.maybeShowPopup(e);
				this._dragging = false;
				/* ------------------------------------------------------- */
				// if nothing had been dragged, do nothing
				/* ------------------------------------------------------- */
				if (CalendarView.this._dragArea == null)
					return;
				/* ------------------------------------------------------- */
				// get the calendar id
				/* ------------------------------------------------------- */
				Object calendarId = null;
				try {
					calendarId = CalendarView.this.getCalendarId(
							e.getPoint().x,
							e.getPoint().y);
				} catch (Exception e1) {
					return;
				}
				/* ------------------------------------------------------- */
				// find the date interval for a new event
				// start date is the left upper corner of the main drag area
				/* ------------------------------------------------------- */
				Date date1 = CalendarView.this.getDate(
						CalendarView.this._dragArea.getX() + 5,
						CalendarView.this._dragArea.getY());
				/* ------------------------------------------------------- */
				// if there are additionalFrameAreas, the end date is the last
				// position of the latest frame area
				/* ------------------------------------------------------- */
				Date date2 = null;
				if (this.additionalFrames != null
						&& this.additionalFrames.size() > 0) {
					/* ------------------------------------------------------- */
					// find the last frame
					/* ------------------------------------------------------- */
					List<Integer> keys = new ArrayList<Integer>(
							this.additionalFrames.keySet());
					Collections.sort(keys);
					/* ------------------------------------------------------- */
					// get the last frame
					/* ------------------------------------------------------- */
					FrameArea lastArea = this.additionalFrames.get(keys.get(keys.size() - 1));
					date2 = CalendarView.this.getDate(
							lastArea.getX() + 2,
							lastArea.getY() + lastArea.getHeight());
					/* ------------------------------------------------------- */
				} else {
					/* ------------------------------------------------------- */
					// we use the bounds of the _dragArea
					/* ------------------------------------------------------- */
					date2 = CalendarView.this.getDate(
							CalendarView.this._dragArea.getX() + 10,
							CalendarView.this._dragArea.getY()
									+ CalendarView.this._dragArea.getHeight());
					/* ------------------------------------------------------- */
				}
				if (this._lasso) {
					/* ------------------------------------------------------- */
					// we need 2 dates.
					// upper left and lower right
					// date1 is upper left
					/* ------------------------------------------------------- */
					// lower right
					int rightLowerCornerX = CalendarView.this._dragArea.getX()
							+ CalendarView.this._dragArea.getWidth();
					int rightLowerCornerY = CalendarView.this._dragArea.getY()
							+ CalendarView.this._dragArea.getHeight();
					Date lowerRightDate = CalendarView.this.getDate(
							rightLowerCornerX,
							rightLowerCornerY);
					/* ------------------------------------------------------- */
					CalendarView.this.lasso(calendarId, date1, lowerRightDate);
					/* ------------------------------------------------------- */
				}
				/* ------------------------------------------------------- */
				// notify the listener for a new event
				/* ------------------------------------------------------- */
				if (!this._lasso)// && (date1.before(date2)))
					if (CalendarView.this.listener != null)
						CalendarView.this.listener.newEvent(
								this._dragCalId,
								new DateInterval(date1, date2));
				// }
				CalendarView.this._dragArea.setVisible(false);
				/* ------------------------------------------------------- */
				// hide all additional lassos
				/* ------------------------------------------------------- */
				if (this.additionalFrames != null
						&& this.additionalFrames.values() != null)
					for (FrameArea a : this.additionalFrames.values())
						a.setVisible(false);
				/* ------------------------------------------------------- */
				// reset the mouse pointer
				/* ------------------------------------------------------- */
				CalendarView.this._dragArea.setCursor(new Cursor(
						Cursor.DEFAULT_CURSOR));
				/* ------------------------------------------------------- */
				// getCalenderArea().remove(_dragArea);
				/* ------------------------------------------------------- */
				this._lasso = false;
				CalendarView.this._dragArea = null;
				this._dragCalId = null;
				/* ------------------------------------------------------- */
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
			/* ------------------------------------------------------- */
			// enable new dragging
			/* ------------------------------------------------------- */
			draggingEnabled = true;
			/* ================================================== */
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			/* ================================================== */
			
			// **************************************************************************
			try {
				if (!this._dragging) {
					this._dragging = true;
					Object id = CalendarView.this.getCalendarId(
							e.getPoint().x,
							e.getPoint().y);
					Date date = CalendarView.this.getDate(
							e.getPoint().x,
							e.getPoint().y);
					if (!CalendarView.this.broker.isInsertable(id, date)) {
						return;
					}
					if (this._lasso) {
						CalendarView.this._dragArea = CalendarView.this._lassoArea;
					} else {
						CalendarView.this._dragArea = CalendarView.this._newEventArea;
					}
					CalendarView.this._dragArea.setVisible(true);
					CalendarView.this._dragArea.setBounds(
							e.getPoint().x,
							e.getPoint().y,
							1,
							CalendarView.this.getTimeSlotHeight());
					// getCalenderArea().add(_dragArea);
					CalendarView.this.getComponent().revalidate();
				}
				
				if (CalendarView.this._dragArea == null) {
					return;
				}
				Object calId = null;
				try {
					calId = CalendarView.this.getCalendarId(
							e.getPoint().x,
							e.getPoint().y);
				} catch (Exception et) {
					return;
				}
				if (!calId.equals(this._dragCalId)) {
					e.consume();
					return;
				}
				int y = this.startDragMouseY;
				
				/* ------------------------------------------------------- */
				
				int pX = e.getPoint().x;
				int pY = CalendarView.this.findNextGreaterHorizontalLinePos(e.getPoint().y);
				Integer offset = null;
				
				/* ------------------------------------------------------- */
				/* ------------------------------------------------------- */
				if (draggingEnabled) {
					CalendarView.this._dragArea.setCursor(new Cursor(
							Cursor.S_RESIZE_CURSOR));
					if (pX >= this._startDrag.x) {
						
						// if the mouse is in the first column, the x value is 0
						if (pX < CalendarView.this.findSmallestLine().getX())
							this.currPos = 0;
						else
							for (JLabel l : CalendarView.this.vLines) {
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								Integer xpos = l.getX();
								if (pX >= xpos)
									if (offset == null) {
										offset = pX - xpos;
										this.currPos = xpos;
									} else {
										if (offset > (pX - xpos)) {
											offset = pX - xpos;
											this.currPos = xpos;
										}
									}
							}
						/*
						 * ------------------------------------------------------
						 * -
						 */
					}
					// set start time
					if (CalendarView.this._dragArea instanceof FrameArea) {
						((FrameArea) CalendarView.this._dragArea).setStartTime(CalendarView.this.getDate(
								this.currPos,
								this.startDragMouseY));
					}
				}
				/* ------------------------------------------------------- */
				
				// ==================================================================
				// dragging of FrameArea
				// ==================================================================
				int gap;
				try {
					gap = CalendarView.this.vLines.get(0).getX();
				} catch (Exception ec) {
					gap = CalendarView.this.calPanel.getWidth();
				}
				
				// if (pX >= _startDrag.x) {
				if (pX >= this.currPos) {
					
					/* ------------------------------------------------------- */
					if (!(pX > this.currPos && pX < (this.currPos + gap))) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// =================================================================
						// the lasso has a different behaviour than the normal
						// FrameArea
						// it just spans over the columns
						// =================================================================
						if (this._lasso) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							
							List<Integer> newLines = CalendarView.this.findUndrawnLines(
									this.mouseXold,
									e.getPoint().x,
									this.currPos);
							
							// find greatest new line
							int dx = CalendarView.this._dragArea.getX();
							Integer max = dx;
							try {
								max = Collections.max(newLines);
							} catch (Exception e2) {}
							
							int dy = CalendarView.this._dragArea.getY();
							int dw = max
									- dx
									+ CalendarView.this.getColumnWidth();
							
							CalendarView.this._dragArea.setBounds(
									dx,
									dy,
									dw,
									CalendarView.this.findNextGreaterHorizontalLinePos(e.getPoint().y)
											- dy);
							
							CalendarView.this.getComponent().revalidate();
							return;
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
						/*
						 * ------------------------------------------------------
						 * -
						 */
						// formerly known as else
						/*
						 * ------------------------------------------------------
						 * -
						 */
						{
							// remove the last frame area, if the mouseX is
							// smaller
							// than the boundX
							if (this.lastCreatedFrameArea != null
									&& pX <= this.lastCreatedFrameArea.getX()) {
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								// remove
								this.additionalFrames.values().remove(
										this.lastCreatedFrameArea);
								this.lastCreatedFrameArea.setVisible(false);
								CalendarView.this.calPanel.remove(this.lastCreatedFrameArea);
								this.additionalFrames.remove(this.lastCreatedKey);
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								// but now we must get the next smaller frame
								// find the biggest key
								Integer biggest = 0;
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								for (Integer k : this.additionalFrames.keySet())
									if (k > biggest)
										biggest = k;
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								this.lastCreatedFrameArea = this.additionalFrames.get(biggest);
								this.lastCreatedKey = biggest;
								/*
								 * ----------------------------------------------
								 * ---------
								 */
							}
							
							/*
							 * --------------------------------------------------
							 * -----
							 */
							// ##########################################################
							//
							// create new frame areas, if needed!
							/*
							 * --------------------------------------------------
							 * -----
							 */
							List<Integer> newLines = null;
							if (this.lastCreatedKey == null)
								newLines = CalendarView.this.findUndrawnLines(
										this.mouseXold,
										e.getPoint().x,
										this.currPos);
							else
								newLines = CalendarView.this.findUndrawnLines(
										this.mouseXold,
										e.getPoint().x,
										this.lastCreatedKey);
							/*
							 * --------------------------------------------------
							 * -----
							 */
							if (newLines != null && newLines.size() > 0) {
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								// create new frame areas for each line
								for (Integer i : newLines) {
									/*
									 * ------------------------------------------
									 * -------------
									 */
									// if frame is present, continue
									if (this.additionalFrames.containsKey(i))
										continue;
									/*
									 * ------------------------------------------
									 * -------------
									 */
									// create a new FrameArea
									FrameArea fa = new FrameArea();
									fa.setBounds(i, 0, gap, pY);
									/*
									 * ------------------------------------------
									 * -------------
									 */
									CalendarView.this.calPanel.add(
											fa,
											Integer.valueOf(3));
									fa.setVisible(true);
									this.additionalFrames.put(i, fa);
									/*
									 * ------------------------------------------
									 * -------------
									 */
									if (this.lastCreatedFrameArea != null) {
										/*
										 * --------------------------------------
										 * -----------------
										 */
										this.lastCreatedFrameArea.setBounds(
												this.lastCreatedFrameArea.getX(),
												0,
												gap,
												CalendarView.this.calPanel.getMaximumSize().height);
									}
									this.lastCreatedFrameArea = fa;
									this.lastCreatedKey = i;
									/*
									 * ------------------------------------------
									 * -------------
									 */
								}
								CalendarView.this._dragArea.setBounds(
										this.currPos,
										y,
										gap,
										CalendarView.this.calPanel.getMaximumSize().height);
								/*
								 * ----------------------------------------------
								 * ---------
								 */
							}
							/*
							 * --------------------------------------------------
							 * -----
							 */
							
							/*
							 * --------------------------------------------------
							 * -----
							 */
							try {
								this.lastCreatedFrameArea.setBounds(
										this.lastCreatedFrameArea.getX(),
										0,
										gap,
										CalendarView.this.findNextGreaterHorizontalLinePos(e.getPoint().y));
								/*
								 * ----------------------------------------------
								 * ---------
								 */
								this.lastCreatedFrameArea.setEndTime(CalendarView.this.getDate(
										this.currPos,
										this.lastCreatedFrameArea.getY()
												+ this.lastCreatedFrameArea.getHeight()));
							} catch (Exception e2) {}
						}
						
					} else {
						for (Integer k : this.additionalFrames.keySet()) {
							this.additionalFrames.get(k).setVisible(false);
							CalendarView.this.calPanel.remove(this.additionalFrames.get(k));
						}
						this.additionalFrames.clear();
						this.lastCreatedFrameArea = null;
						this.lastCreatedKey = null;
						/*
						 * ------------------------------------------------------
						 * -
						 */
						CalendarView.this._dragArea.setBounds(
								this.currPos,
								y,
								gap,
								CalendarView.this.findNextGreaterHorizontalLinePos(e.getPoint().y)
										- y);
						if (CalendarView.this._dragArea instanceof FrameArea)
							((FrameArea) CalendarView.this._dragArea).setEndTime(CalendarView.this.getDate(
									this.currPos,
									CalendarView.this._dragArea.getY()
											+ CalendarView.this._dragArea.getHeight()));
						
					}
				}
				
				// ensure, that the event area is at leat as small as the
				// time slot height!
				if (CalendarView.this._dragArea.getHeight() < CalendarView.this.getTimeSlotHeight())
					CalendarView.this._dragArea.setBounds(
							CalendarView.this._dragArea.getX(),
							CalendarView.this._dragArea.getY(),
							CalendarView.this._dragArea.getWidth(),
							CalendarView.this.getTimeSlotHeight());
				
				/* ------------------------------------------------------- */
				CalendarView.this.getComponent().revalidate();
				draggingEnabled = false;
				this.mouseXold = e.getPoint().x;
				/* ------------------------------------------------------- */
			} catch (Exception exc) {
				exc.printStackTrace();
				throw BizcalException.create(exc);
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			CalendarView.this.getComponent().requestFocusInWindow();
		}
		
	}
	
	/**
	 * Returns the last FrameArea that is connected as a child to the given
	 * FrameArea. Crucial factor is the x bound.
	 * 
	 * Returns null if there are no children.
	 * 
	 * @param base
	 * @return
	 */
	private synchronized FrameArea findLastFrameArea(FrameArea base) {
		/* ================================================== */
		if (base.getChildren() == null || base.getChildren().size() < 1)
			return null;
		
		return base.getChildren().get(base.getChildren().size() - 1);
		
		// /* ------------------------------------------------------- */
		// FrameArea last = null;
		// for (FrameArea fa : base.getChildren()) {
		// /* ------------------------------------------------------- */
		// if (last == null)
		// if (fa.isVisible())
		// last = fa;
		// else
		// continue;
		// /* ------------------------------------------------------- */
		// if (fa.getX() > last.getX() && fa.isVisible())
		// last = fa;
		// /* ------------------------------------------------------- */
		// }
		// // if (last == null)
		// // return base;
		// return last;
		/* ================================================== */
	}
	
	// /**
	// * Returns the first frame after the base frame
	// *
	// * @param base
	// * @return
	// */
	// private FrameArea findFirstFrameArea(FrameArea base) {
	// /* ================================================== */
	// if (base.getChildren() == null)
	// return null;
	// /* ------------------------------------------------------- */
	// FrameArea first = null;
	// for (FrameArea fa : base.getChildren()) {
	// /* ------------------------------------------------------- */
	// if (first == null)
	// first = fa;
	// /* ------------------------------------------------------- */
	// if (fa.getX() < first.getX())
	// first = fa;
	// /* ------------------------------------------------------- */
	// }
	// return first;
	// /* ================================================== */
	// }
	
	/**
	 * Returns the position for stepwise dragging
	 * 
	 * @param mouseY
	 * @return
	 */
	private int findNextGreaterHorizontalLinePos(int mouseY) {
		/* ================================================== */
		if (this.hLines == null)
			return -1;
		/* ------------------------------------------------------- */
		int linePos = 100000000;
		for (JLabel l : this.hLines) {
			/* ------------------------------------------------------- */
			if (l.getY() > mouseY) {
				if (l.getY() < linePos)
					linePos = l.getY();
			}
			/* ------------------------------------------------------- */
		}
		if (linePos == 100000000)
			return -1;
		return linePos;
		/* ================================================== */
	}
	
	/**
	 * 
	 * Gets the next smaller horizontal line according to the mouse pointer
	 * 
	 * @param mouseY
	 * @return
	 */
	private int findNextSmallerHorizontalLinePos(int mouseY) {
		/* ================================================== */
		if (this.hLines == null)
			return -1;
		/* ------------------------------------------------------- */
		// if the pointer is in the first row, return the startY of the panel
		/* ------------------------------------------------------- */
		if (mouseY < this.getTimeSlotHeight())
			return this.calPanel.getY();
		/* ------------------------------------------------------- */
		int linePos = this.calPanel.getHeight();
		// System.out.println("======================================================================");
		for (JLabel l : this.hLines) {
			/* ------------------------------------------------------- */
			// System.out.println("LineY: " + l.getY());
			if (l.getY() < linePos
					&& l.getY() >= mouseY - this.getTimeSlotHeight())
				linePos = l.getY();
			/* ------------------------------------------------------- */
		}
		// System.out.println("======================================================================");
		return linePos;
		/* ================================================== */
	}
	
	/**
	 * Find all lines that are unprinted between the last printed frame area and
	 * the current mouspointer
	 * 
	 * @param mouseXold
	 * @param mouseXnew
	 * @param gap
	 * @return
	 */
	private List<Integer> findUndrawnLines(
			int mouseXold,
			int mouseXnew,
			Integer lastFrameX) {
		/* ================================================== */
		List<Integer> returnList = new ArrayList<Integer>();
		// can only find lines if the current mouseposition is greater
		// than the last one
		if (mouseXnew > mouseXold)
			/* ------------------------------------------------------- */
			for (JLabel l : this.vLines) {
				/* ------------------------------------------------------- */
				if (l.getX() > lastFrameX) {
					if (l.getX() < mouseXnew && !returnList.contains(l.getX())) {
						returnList.add(l.getX());
					}
				}
				/* ------------------------------------------------------- */
			}
		return returnList;
		/* ================================================== */
	}
	
	/**
	 * Find the next vertical line
	 * 
	 * @param mouseX
	 * @return
	 */
	private int findNextGreaterVerticalLine(int mouseX) {
		/* ================================================== */
		if (this.vLines != null) {
			/* ------------------------------------------------------- */
			int linePos = this.calPanel.getWidth();
			for (JLabel l : this.vLines) {
				if (l.getX() > mouseX)
					if (l.getX() < linePos)
						linePos = l.getX();
			}
			return linePos;
			/* ------------------------------------------------------- */
		}
		System.out.println("Return -1");
		return -1;
		/* ================================================== */
	}
	
	/**
	 * Returns the next smalles vertical line position
	 * 
	 * @param mouseX
	 * @return
	 */
	private int findNextSmallerVerticalLine(int mouseX) {
		/* ================================================== */
		if (this.vLines != null) {
			/* ------------------------------------------------------- */
			int linePos = -1;
			for (JLabel l : this.vLines) {
				if (l.getX() < mouseX)
					if (l.getX() > linePos)
						linePos = l.getX();
			}
			return linePos;
			/* ------------------------------------------------------- */
		}
		return -1;
		/* ================================================== */
	}
	
	/**
	 * Returns the first line in the list
	 * 
	 * @return
	 */
	private JLabel findSmallestLine() {
		/* ================================================== */
		if (this.vLines == null)
			return null;
		/* ------------------------------------------------------- */
		// for single day view, there are no lines
		if (this.vLines.size() == 0) {
			JLabel sL = new JLabel();
			sL.setBounds(this.calPanel.getWidth(), 0, 0, 0);
			this.vLines.add(sL);
			return sL;
		}
		if (this.vLines.size() == 1) {
			this.vLines.get(0).setBounds(this.calPanel.getWidth(), 0, 0, 0);
		}
		
		/* ------------------------------------------------------- */
		JLabel smallest = this.vLines.get(0);
		for (JLabel l : this.vLines) {
			/* ------------------------------------------------------- */
			if (l.getX() < smallest.getX())
				smallest = l;
			/* ------------------------------------------------------- */
		}
		return smallest;
		/* ================================================== */
	}
	
	public void addVerticalLine(JLabel line) {
		/* ================================================== */
		this.vLines.add(line);
		/* ================================================== */
	}
	
	public void resetVerticalLines() {
		/* ================================================== */
		this.vLines.clear();
		/* ================================================== */
	}
	
	public void addHorizontalLine(JLabel line) {
		/* ================================================== */
		this.hLines.add(line);
		/* ================================================== */
	}
	
	public void resetHorizontalLines() {
		/* ================================================== */
		this.hLines.clear();
		/* ================================================== */
	}
	
	protected void addDraggingComponents(JComponent calPanel) throws Exception {
		this._lassoArea = new LassoArea();
		calPanel.add(this._lassoArea, 1000);
		this._newEventArea = new FrameArea();
		this._newEventArea.setRoundedRectangle(false);
		
		this._newEventArea.setVisible(false);
		calPanel.add(this._newEventArea, Integer.valueOf(2));
		this.calPanel = calPanel;
	}
	
	protected Object getCalendarId(int x, int y) throws Exception {
		return null;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean visible) throws Exception {
		this.visible = visible;
		if (visible)
			this.refresh();
	}
	
	protected int getXOffset() {
		return 0;
	}
	
	protected int getCaptionRowHeight() {
		return 0;
	}
	
	public void setCursor(Cursor cursor) {
		// rootPanel.setCursor(cursor);
		this.getComponent().setCursor(cursor);
	}
	
	@SuppressWarnings("unchecked")
	protected void register(Object calId, Event event, FrameArea area) {
		this._frameAreaMap.put(""
				+ calId
				+ event.getId()
				+ event.getStart().getTime(), area);
		List list = (List) this._eventMap.get(calId);
		if (list == null) {
			list = new ArrayList();
			this._eventMap.put(calId, list);
		}
		list.add(event);
	}
	
	protected FrameArea getFrameArea(Object calId, Event event) {
		return this._frameAreaMap.get(""
				+ calId
				+ event.getId()
				+ event.getStart().getTime());
	}
	
	/**
	 * @param calId
	 * @param event
	 * @param flag
	 * @throws Exception
	 */
	public void select(Object calId, Event event, boolean flag)
			throws Exception {
		/* ================================================== */
		// FrameArea area = getFrameArea(calId, event);
		FrameArea area = this.frameAreaHash.get(event);
		if (area != null) {
			/* ------------------------------------------------------- */
			area.setSelected(flag);
			if (area.getChildren() != null)
				for (FrameArea fa : area.getChildren())
					fa.setSelected(true);
			/* ------------------------------------------------------- */
		}
		if (flag)
			this._selectedEvents.add(event);
		else
			this._selectedEvents.remove(event);
		/* ------------------------------------------------------- */
		// inform the listener
		if (this.listener != null) {
			this.listener.eventsSelected(this._selectedEvents);
			this.listener.eventSelected(calId, event);
		}
		
		this.setSelectionDate(event.getStart());
		/* ================================================== */
	}
	
	/**
	 * Deselect frame areas.
	 * FIXME not working
	 * 
	 * @throws Exception
	 */
	public void deselect() throws Exception {
		/* ================================================== */
		this._selectedEvents.clear();
		Iterator iCal = this.broker.getSelectedCalendars().iterator();
		while (iCal.hasNext()) {
			bizcal.common.Calendar cal = (bizcal.common.Calendar) iCal.next();
			Object calId = cal.getId();
			List events = (List) this._eventMap.get(calId);
			if (events == null)
				return;
			Iterator i = events.iterator();
			while (i.hasNext()) {
				Event event = (Event) i.next();
				// FrameArea area = getFrameArea(calId, event);
				FrameArea area = this.frameAreaHash.get(event);
				// if (area.isSelected())
				// area.setAlphaValue(area.getAlphaValue()-0.2f);
				if (area != null) {
					area.setSelected(false);
					if (area.getChildren() != null)
						for (FrameArea fa : area.getChildren())
							fa.setSelected(false);
				}
				
			}
		}
		if (this.listener != null) {
			/* ------------------------------------------------------- */
			this.listener.eventsSelected(this._selectedEvents);
			this.listener.selectionReset();
			/* ------------------------------------------------------- */
		}
		this.calPanel.requestFocus();
		/* ================================================== */
	}
	
	public void copy() throws Exception {
		this.listener.copy(this._selectedEvents);
	}
	
	protected boolean supportsDrag() {
		return true;
	}
	
	/*
	 * protected void addDraggingComponents() throws Exception { _lassoArea =
	 * new LassoArea(); calPanel.add(_lassoArea, 1000); _newEventArea = new
	 * FrameArea(); _newEventArea.setVisible(false); calPanel.add(_newEventArea,
	 * new Integer(2)); }
	 */
	
	/**
	 * Select the events surrounded by the lasso
	 * 
	 * @param id
	 * @param date1
	 * @param date2
	 * @throws Exception
	 */
	private void lasso(Object id, Date date1, Date date2) throws Exception {
		/* ================================================== */
		// deselect all
		this.deselect();
		/* ------------------------------------------------------- */
		if (DateUtil.round2Day(date1).getTime() != DateUtil.round2Day(date2).getTime()) {
			/* ------------------------------------------------------- */
			TimeOfDay startTime = DateUtil.getTimeOfDay(date1);
			TimeOfDay endTime = DateUtil.getTimeOfDay(date2);
			Date date = date1;
			// date = DateUtil.getDiffDay(date, +1);
			while (true) {
				/* ------------------------------------------------------- */
				Date start = DateUtil.setTimeOfDate(date, startTime);
				Date end = DateUtil.setTimeOfDate(date, endTime);
				if (end.after(date2))
					break;
				this._selectedEvents.addAll(this.getEditibleEvents(
						id,
						new DateInterval(start, end)));
				date = DateUtil.getDiffDay(date, +1);
				/* ------------------------------------------------------- */
			}
			/* ------------------------------------------------------- */
		} else
			this._selectedEvents.addAll(this.getEditibleEvents(
					id,
					new DateInterval(date1, date2)));
		Iterator i = this._selectedEvents.iterator();
		while (i.hasNext()) {
			Event event = (Event) i.next();
			FrameArea area = this.getFrameArea(id, event);
			area.setSelected(true);
			if (this.listener != null)
				this.listener.eventSelected(id, event);
		}
		if (this.listener != null)
			this.listener.eventsSelected(this._selectedEvents);
		/* ================================================== */
	}
	
	/**
	 * @param calId
	 * @param interval
	 * @return
	 * @throws Exception
	 */
	private List<Event> getEditibleEvents(Object calId, DateInterval interval)
			throws Exception {
		/* ================================================== */
		List<Event> result = new ArrayList<Event>();
		List events = (List) this._eventMap.get(calId);
		/* ------------------------------------------------------- */
		if (events == null || events.size() < 1)
			return result;
		/* ------------------------------------------------------- */
		Iterator i = events.iterator();
		while (i.hasNext()) {
			/* ------------------------------------------------------- */
			Event event = (Event) i.next();
			if (event.isEditable()) {
				DateInterval eventInterval = new DateInterval(
						event.getStart(),
						event.getEnd());
				boolean overlap = eventInterval.overlap(interval);
				if (overlap)
					result.add(event);
			}
			/* ------------------------------------------------------- */
		}
		return result;
		/* ================================================== */
	}
	
	private boolean isSelected(Event event) {
		if (event == null)
			return false;
		Iterator i = this._selectedEvents.iterator();
		while (i.hasNext()) {
			Event tmpEvent = (Event) i.next();
			if (tmpEvent.getId().equals(event.getId()))
				return true;
			
		}
		return false;
	}
	
	public void setDescriptor(CalendarViewConfig desc) {
		this.desc = desc;
	}
	
	public CalendarViewConfig getDescriptor() {
		return this.desc;
	}
	
	protected JComponent createCorner(boolean left, boolean top)
			throws Exception {
		String direction = GradientArea.LEFT_RIGHT;
		if (!left && top)
			direction = GradientArea.TOP_BOTTOM;
		else if (left && top)
			direction = GradientArea.TOPLEFT_BOTTOMRIGHT;
		GradientArea area = new GradientArea(
				direction,
				Color.WHITE,
				ColumnHeaderPanel.GRADIENT_COLOR);
		area.setOpaque(true);
		area.setBorder(false);
		return area;
	}
	
	protected int getInitYPos() throws Exception {
		return 0;
	}
	
	protected class CalHeaderMouseListener extends MouseAdapter {
		
		private Object calId;
		
		public CalHeaderMouseListener(Object calId) {
			this.calId = calId;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			this.maybeShowPopup(e);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			this.maybeShowPopup(e);
		}
		
		private void maybeShowPopup(MouseEvent e) {
			try {
				if (e.isPopupTrigger()) {
					JPopupMenu popup = CalendarView.this.popupMenuCallback.getCalendarPopupMenu(this.calId);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			} catch (Exception exc) {
				throw BizcalException.create(exc);
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// rootPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// rootPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	// /**
	// * @author martin.heinemann@tudor.lu
	// * 08.04.2008
	// * 12:56:59
	// *
	// *
	// * @version
	// * <br>$Log: CalendarView.java,v $
	// * <br>Revision 1.37 2008/10/30 10:42:52 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.36 2008/10/21 15:08:31 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.35 2008/10/09 12:33:09 heine_
	// * <br>shows now the summary of an event in the header of a FrameArea and
	// the the description is now in the body.
	// * <br>
	// * <br>Revision 1.34 2008/08/12 12:47:27 heine_
	// * <br>fixed some bugs and made code improvements
	// * <br>
	// * <br>Revision 1.33 2008/06/19 12:20:00 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.32 2008/06/10 13:16:36 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.31 2008/06/09 14:10:09 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.30 2008/05/30 11:36:47 heine_
	// * <br>*** empty log message ***
	// * <br>
	// * <br>Revision 1.29 2008/05/26 08:15:31 heine_
	// * <br>removed MainThread locking by swing worker thread
	// * <br>
	// * <br>Revision 1.28 2008/04/24 14:17:37 heine_
	// * <br>Improved timeslot search when clicking and moving
	// * <br>
	// * <br>Revision 1.27 2008/04/08 13:17:53 heine_
	// * <br>*** empty log message ***
	// * <br>
	// *
	// */
	// protected class DateLabelGroup extends ComponentAdapter {
	//
	// private List<JLabel> labels = new ArrayList<JLabel>();
	//
	// private List<Date> dates = new ArrayList<Date>();
	//
	// private List<DateFormat> patterns = new ArrayList<DateFormat>();
	//
	// public void addLabel(JLabel label, Date date) {
	// labels.add(label);
	// dates.add(date);
	// }
	//
	// public void addPattern(String pattern) {
	// patterns.add(new SimpleDateFormat(pattern));
	// }
	//
	// public void addFormat(DateFormat format) {
	// patterns.add(format);
	// }
	//
	// public void componentResized(ComponentEvent event) {
	// /* ================================================== */
	// try {
	// if (patterns.size() == 0) {
	// /* ------------------------------------------------------- */
	// Locale l = LocaleBroker.getLocale();
	// patterns
	// .add(DateFormat.getDateInstance(DateFormat.LONG, l));
	// patterns.add(DateFormat.getDateInstance(DateFormat.MEDIUM,
	// l));
	// patterns.add(DateFormat
	// .getDateInstance(DateFormat.SHORT, l));
	// /* ------------------------------------------------------- */
	// }
	// int maxPatternIndex = 0;
	// for (int i = 0; i < labels.size(); i++) {
	// JLabel label = (JLabel) labels.get(i);
	// Date date = (Date) dates.get(i);
	// for (int j = 0; j < patterns.size(); j++) {
	// DateFormat format = (DateFormat) patterns.get(j);
	// FontMetrics metrics = label.getFontMetrics(label
	// .getFont());
	// int width = metrics.stringWidth(format.format(date));
	// if (width < event.getComponent().getWidth()) {
	// if (j > maxPatternIndex)
	// maxPatternIndex = j;
	// break;
	// }
	// if (j == patterns.size() - 1)
	// maxPatternIndex = patterns.size() - 1;
	// }
	// }
	// DateFormat format = (DateFormat) patterns.get(maxPatternIndex);
	// // DateFormat format = (DateFormat) patterns.get(0);
	// for (int i = 0; i < labels.size(); i++) {
	// JLabel label = (JLabel) labels.get(i);
	// Date date = (Date) dates.get(i);
	// label.setText(TextUtil.formatCase(format.format(date)));
	// }
	// } catch (Exception e) {
	// ErrorHandler.handleError(e);
	// }
	// }
	// /* ================================================== */
	// }
	
	protected List getSelectedCalendars() throws Exception {
		return this.broker.getSelectedCalendars();
	}
	
	protected DateInterval getInterval() throws Exception {
		return this.broker.getInterval();
	}
	
	public CalendarModel getModel() {
		return this.broker;
	}
	
	protected FrameArea getBaseFrameArea(Event e) {
		return this.frameAreaHash.get(e);
	}
	
	/**
	 * @param calId
	 * @return
	 * @throws Exception
	 */
	protected Map<Date, List<Event>> createEventsPerDay(Object calId)
			throws Exception {
		return this.createEventsPerDay(calId, false);
	}
	
	/**
	 * @param calId
	 * @return
	 * @throws Exception
	 */
	protected Map<Date, List<Event>> createEventsPerDay(
			Object calId,
			boolean checkStartOnly) throws Exception {
		/* ================================================== */
		Map<Date, List<Event>> map = new HashMap<Date, List<Event>>();
		/* ------------------------------------------------------- */
		// iterate over all events
		/* ------------------------------------------------------- */
		List<Event> eventList = this.getModel().getEvents(calId);
		
		if (eventList != null)
			for (Event event : eventList) {
				/* ------------------------------------------------------- */
				Date date = DateUtil.round2Day(event.getStart());
				List<Event> events = map.get(date);
				if (events == null) {
					/* ------------------------------------------------------- */
					events = new ArrayList<Event>();
					map.put(date, events);
					/* ------------------------------------------------------- */
				}
				events.add(event);
				/* ------------------------------------------------------- */
				// check if the event takes place in more than one day
				/* ------------------------------------------------------- */
				if (!checkStartOnly
						&& !DateUtil.isSameDay(event.getStart(), event.getEnd())) {
					/* ------------------------------------------------------- */
					// we iterate over the time as long as its finished
					/* ------------------------------------------------------- */
					Date next = DateUtil.move(event.getStart(), 1);
					// as long end date is not the same day as the next,
					// continue
					while (DateUtil.isBeforeDay(next, event.getEnd())
							|| DateUtil.isSameDay(event.getEnd(), next)) {
						/*
						 * ------------------------------------------------------
						 * -
						 */
						date = DateUtil.round2Day(next);
						events = map.get(date);
						if (events == null) {
							/*
							 * --------------------------------------------------
							 * -----
							 */
							events = new ArrayList<Event>();
							map.put(date, events);
							/*
							 * --------------------------------------------------
							 * -----
							 */
						}
						events.add(event);
						
						next = DateUtil.move(next, 1);
						/*
						 * ------------------------------------------------------
						 * -
						 */
					}
					/* ------------------------------------------------------- */
				}
			}
		return map;
		/* ================================================== */
	}
	
	public abstract JComponent getComponent();
	
	public void clear() {
		this._selectedEvents.clear();
	}
	
	/**
	 * Converts a point from the source components coordinates system to the
	 * target components coordinates system.
	 * 
	 * @param p
	 *            the point to convert
	 * @param source
	 *            the source component from which the point is inherited
	 * @param target
	 *            the component for which the point should be converted
	 * @return
	 */
	public static Point convertPoint(Point p, Component source, Component target) {
		/* ================================================== */
		Point pNew = new Point(p);
		
		// convert point from source to screen
		SwingUtilities.convertPointToScreen(pNew, source);
		// convert point from screen to target
		SwingUtilities.convertPointFromScreen(pNew, target);
		
		return pNew;
		/* ================================================== */
	}
	
}
