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
package com.leclercb.taskunifier.gui.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags.Flag;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jdesktop.swingx.JXErrorPane;
import org.jdesktop.swingx.error.ErrorInfo;

import com.leclercb.taskunifier.api.models.Contact;
import com.leclercb.taskunifier.api.models.Note;
import com.leclercb.taskunifier.api.models.Task;
import com.leclercb.taskunifier.api.models.beans.ContactListBean;
import com.leclercb.taskunifier.api.models.beans.ContactListBean.ContactItemBean;
import com.leclercb.taskunifier.gui.api.models.beans.ComBean;
import com.leclercb.taskunifier.gui.api.models.beans.ComNoteBean;
import com.leclercb.taskunifier.gui.api.models.beans.ComTaskBean;
import com.leclercb.taskunifier.gui.components.notes.NoteColumnList;
import com.leclercb.taskunifier.gui.components.tasks.TaskColumnList;
import com.leclercb.taskunifier.gui.constants.Constants;
import com.leclercb.taskunifier.gui.main.frames.FrameUtils;
import com.leclercb.taskunifier.gui.translations.Translations;

public final class MailUtils {
	
	private MailUtils() {
		
	}
	
	public static boolean mail(
			Address[] to,
			Address[] cc,
			Address[] bcc,
			Note[] notes) {
		try {
			ComBean bean = new ComBean();
			
			List<ComNoteBean> noteBeans = new ArrayList<ComNoteBean>();
			for (Note note : notes) {
				ComNoteBean b = new ComNoteBean(note.toBean());
				b.loadTitles(true);
				noteBeans.add(b);
			}
			
			bean.setApplicationName(Constants.TITLE);
			bean.setNotes(noteBeans.toArray(new ComNoteBean[0]));
			
			File attachment = File.createTempFile("taskunifier_mail_", ".xml");
			FileOutputStream attachmentOs = new FileOutputStream(attachment);
			bean.encodeToXML(attachmentOs);
			attachmentOs.close();
			
			return mail(
					to,
					cc,
					bcc,
					getSubject(notes),
					getBody(notes, false),
					getBody(notes, true),
					"notes.tue",
					attachment);
		} catch (Exception e) {
			ErrorInfo info = new ErrorInfo(
					Translations.getString("general.error"),
					Translations.getString("error.cannot_open_mail_client"),
					null,
					"GUI",
					e,
					Level.WARNING,
					null);
			
			JXErrorPane.showDialog(FrameUtils.getCurrentWindow(), info);
			
			return false;
		}
	}
	
	public static boolean mail(
			Address[] to,
			Address[] cc,
			Address[] bcc,
			Task[] tasks) {
		try {
			ComBean bean = new ComBean();
			
			List<ComTaskBean> taskBeans = new ArrayList<ComTaskBean>();
			for (Task task : tasks) {
				ComTaskBean b = new ComTaskBean(task.toBean());
				
				Contact currentUser = ContactUtils.getCurrentUser();
				
				if (currentUser != null) {
					if (b.getContacts() == null)
						b.setContacts(new ContactListBean());
					
					b.getContacts().add(
							new ContactItemBean(
									currentUser.getModelId(),
									Translations.getString("general.assigned_by")));
				}
				
				b.loadTitles(true);
				taskBeans.add(b);
			}
			
			bean.setApplicationName(Constants.TITLE);
			bean.setTasks(taskBeans.toArray(new ComTaskBean[0]));
			
			File attachment = File.createTempFile("taskunifier_mail_", ".xml");
			FileOutputStream attachmentOs = new FileOutputStream(attachment);
			bean.encodeToXML(attachmentOs);
			attachmentOs.close();
			
			return mail(
					to,
					cc,
					bcc,
					getSubject(tasks),
					getBody(tasks, false),
					getBody(tasks, true),
					"tasks.tue",
					attachment);
		} catch (Exception e) {
			ErrorInfo info = new ErrorInfo(
					Translations.getString("general.error"),
					Translations.getString("error.cannot_open_mail_client"),
					null,
					"GUI",
					e,
					Level.WARNING,
					null);
			
			JXErrorPane.showDialog(FrameUtils.getCurrentWindow(), info);
			
			return false;
		}
	}
	
	public static boolean mail(
			Address[] to,
			Address[] cc,
			Address[] bcc,
			String subject,
			String textBody,
			String htmlBody,
			String attachmentName,
			File attachment) throws Exception {
		Properties p = System.getProperties();
		Session session = Session.getInstance(p);
		MimeMessage message = new MimeMessage(session);
		
		message.setSubject(subject);
		message.setFlag(Flag.DRAFT, true);
		
		Contact currentUser = ContactUtils.getCurrentUser();
		
		if (currentUser != null
				&& currentUser.getEmail() != null
				&& currentUser.getEmail().length() != 0)
			message.setFrom(new InternetAddress(currentUser.getEmail()));
		
		if (to != null)
			message.setRecipients(javax.mail.Message.RecipientType.TO, to);
		
		if (cc != null)
			message.setRecipients(javax.mail.Message.RecipientType.CC, cc);
		
		if (bcc != null)
			message.setRecipients(javax.mail.Message.RecipientType.BCC, bcc);
		
		Multipart multipart = new MimeMultipart();
		
		BodyPart bodyPart;
		
		bodyPart = new MimeBodyPart();
		multipart.addBodyPart(bodyPart);
		bodyPart.setText(textBody);
		bodyPart.setContent(htmlBody, "text/html");
		
		bodyPart = new MimeBodyPart();
		multipart.addBodyPart(bodyPart);
		DataSource source = new FileDataSource(attachment);
		bodyPart.setDataHandler(new DataHandler(source));
		bodyPart.setFileName(attachmentName);
		
		message.setContent(multipart);
		
		File emlFile = File.createTempFile("taskunifier_mail_", ".eml");
		FileOutputStream emlOs = new FileOutputStream(emlFile);
		message.writeTo(emlOs);
		emlOs.close();
		
		DesktopUtils.open(emlFile);
		
		return true;
	}
	
	private static String getSubject(Note[] notes) {
		if (notes == null || notes.length == 0)
			return Constants.TITLE;
		
		if (notes.length == 1)
			return Constants.TITLE + ": " + notes[0].getTitle();
		
		return Constants.TITLE
				+ ": "
				+ notes.length
				+ " "
				+ Translations.getString("general.notes");
	}
	
	private static String getSubject(Task[] tasks) {
		if (tasks == null || tasks.length == 0)
			return Constants.TITLE;
		
		if (tasks.length == 1)
			return Constants.TITLE + ": " + tasks[0].getTitle();
		
		return Constants.TITLE
				+ ": "
				+ tasks.length
				+ " "
				+ Translations.getString("general.tasks");
	}
	
	private static String getBody(Note[] notes, boolean html) {
		String header = Translations.getString("mailto.notes.import_com_file");
		
		if (html)
			header = header + "<br /><hr /><br />";
		else
			header = header + "\n-------------------\n\n";
		
		return NoteUtils.toText(
				notes,
				NoteColumnList.getInstance().getUsedAccessors(),
				html,
				header,
				null);
	}
	
	private static String getBody(Task[] tasks, boolean html) {
		String header = Translations.getString("mailto.tasks.import_com_file");
		
		if (html)
			header = header + "<br /><hr /><br />";
		else
			header = header + "\n-------------------\n\n";
		
		return TaskUtils.toText(
				tasks,
				TaskColumnList.getInstance().getUsedAccessors(),
				html,
				header,
				null);
	}
	
}
