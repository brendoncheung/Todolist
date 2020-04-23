package com.alephreach.todolist.domain.Entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class GroupItemJoin {

    @Embedded
    public Group mGroup;

    // select * from groups inner join items on groups.id = items.group_id where groups.id = 1;
    @Relation(parentColumn = "id", entityColumn = "group_id")
    public List<Item> mItems;

    public GroupItemJoin() {
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }
}
