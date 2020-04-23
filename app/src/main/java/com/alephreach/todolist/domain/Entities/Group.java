package com.alephreach.todolist.domain.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int mId;

    @ColumnInfo(name = "group_name")
    public String mGroupname;

    @ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
    public LocalDate mCreatedDate = LocalDate.now();

    public Group(String groupname) {
        mGroupname = groupname;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getGroupname() {
        return mGroupname;
    }

    public void setGroupname(String groupname) {
        mGroupname = groupname;
    }

    public LocalDate getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        mCreatedDate = createdDate;
    }
}
