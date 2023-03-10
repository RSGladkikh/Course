package qa.learning.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {


    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }


    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;

    }
    public Groups withoutDeleted(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;

    }

    public Groups withEdited (GroupData groupBefore, GroupData groupAfter){
        Groups groups = new Groups(this);
        groups.remove(groupBefore);
        groups.add(groupAfter);
        return groups;
    }
}
