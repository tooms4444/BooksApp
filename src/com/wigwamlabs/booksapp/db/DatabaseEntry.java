/*
 * Copyright 2011 Jonas Bengtsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wigwamlabs.booksapp.db;

import android.content.ContentValues;

public class DatabaseEntry {
	private final String mTableName;
	protected final ContentValues mValues = new ContentValues();

	protected DatabaseEntry(String tableName) {
		mTableName = tableName;
	}

	public long executeInsert(DatabaseAdapter db, int t) {
		return db.insertOrThrow(t, mTableName, mValues);
	}

	public void executeUpdate(DatabaseAdapter db, int t, long id) {
		db.update(t, mTableName, mValues, "_id=" + id);
	}
}