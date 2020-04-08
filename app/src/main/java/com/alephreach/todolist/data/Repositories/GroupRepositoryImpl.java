package com.alephreach.todolist.data.Repositories;

import com.alephreach.todolist.data.Database.Dao.GroupDao;
import com.alephreach.todolist.domain.Entities.Group;
import com.alephreach.todolist.domain.Repositories.GroupRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GroupRepositoryImpl implements GroupRepository {

    public final GroupDao mGroupDao;

    public GroupRepositoryImpl(GroupDao groupDao) {
        mGroupDao = groupDao;
    }

    @Override
    public Single<Group> getGroupById(int id) {
        return mGroupDao.getGroupById(id)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<Group>> getAllGroups() {
        return mGroupDao.getAllGroups()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable addGroup(Group group) {
        return mGroupDao.addGroup(group)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable updateGroupById(int id, Group group) {
        return mGroupDao.updateGroupById(group)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable deleteGroup(Group group) {
        return mGroupDao.deleteGroup(group)
                .subscribeOn(Schedulers.io());
    }
}
