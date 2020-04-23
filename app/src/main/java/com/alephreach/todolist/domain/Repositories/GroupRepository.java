package com.alephreach.todolist.domain.Repositories;

import com.alephreach.todolist.domain.Entities.Group;
import com.alephreach.todolist.domain.Entities.GroupItemJoin;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface GroupRepository {

    Single<Group> getGroupById(int id);

    Single<List<Group>> getAllGroups();

    Completable addGroup(Group group);

    Completable updateGroupById(int id, Group group);

    Completable deleteGroup(Group group);

    Single<GroupItemJoin> getItemsByGroup(int id);

}
