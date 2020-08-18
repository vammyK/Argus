package com.healthcheck.argus.model;

import java.util.List;

public class Groups {
    String name;
    List<Nodes> nodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<Nodes> nodes) {
        this.nodes = nodes;
    }
}
