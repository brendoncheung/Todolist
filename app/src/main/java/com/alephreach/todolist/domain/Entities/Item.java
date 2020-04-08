package com.alephreach.todolist.domain.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "items", foreignKeys = {
        @ForeignKey(entity = Item.class,
                parentColumns = "id",
                childColumns = "group_id")
})
public class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int mId;

    @ColumnInfo(name = "taskname")
    public String mTaskname;

    @ColumnInfo(name = "created_at")
    public LocalDateTime mCreatedDate;

    @ColumnInfo(name = "modified_at")
    public LocalDateTime mModifiedDate;

    @ColumnInfo(name = "group_id")
    public int mGroupId;

    public Item() {
        // default room initializer
    }

    @Ignore
    public Item(String taskname, int groupId) {
        mTaskname = taskname;
        mGroupId = groupId;
        mCreatedDate = LocalDateTime.now();
    }

}
