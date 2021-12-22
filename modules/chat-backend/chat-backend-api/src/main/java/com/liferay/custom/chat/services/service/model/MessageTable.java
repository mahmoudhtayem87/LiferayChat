/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.custom.chat.services.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;CHAT_Message&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
public class MessageTable extends BaseTable<MessageTable> {

	public static final MessageTable INSTANCE = new MessageTable();

	public final Column<MessageTable, Long> messageId = createColumn(
		"messageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MessageTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Long> toUserId = createColumn(
		"toUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Long> fromUserId = createColumn(
		"fromUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, String> messageType = createColumn(
		"messageType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MessageTable, String> messageText = createColumn(
		"messageText", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MessageTable, Boolean> seen = createColumn(
		"seen", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private MessageTable() {
		super("CHAT_Message", MessageTable::new);
	}

}