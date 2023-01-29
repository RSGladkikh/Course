package qa.learning.model;

import java.util.Objects;

public final class GroupData {
    private final String name;

    private final String header;
    private final String footer;
    private int id;

    public GroupData(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public GroupData(String name, String header, String footer) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String name() {
        return name;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }


}