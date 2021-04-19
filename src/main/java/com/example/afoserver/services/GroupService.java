package com.example.afoserver.services;

import com.example.afoserver.models.Group;
import com.example.afoserver.models.UserGroup;
import com.example.afoserver.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public Group createGroup(Group group) {

        return groupRepository.save(group);
    }

    public List<Group> findAllGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    public Group findGroupById(Long groupId) {
        return groupRepository.findById(groupId).get();
    }


}
