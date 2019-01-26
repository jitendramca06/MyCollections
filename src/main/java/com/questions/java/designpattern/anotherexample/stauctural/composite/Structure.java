package com.questions.java.designpattern.anotherexample.stauctural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Structure implements Group{
    List<Group> groups = new ArrayList<>();

    public void add(Group group) {
        groups.add(group);
    }

    public void remove(Group group) {
        groups.remove(group);
    }

    @Override
    public void assemble() {
        for (Group group : groups) {
            group.assemble();
        }
    }
}
