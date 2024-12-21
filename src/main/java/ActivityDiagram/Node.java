// File: Node.java
package ActivityDiagram;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private String type; // start, end, activity, decision, merge, fork, join
    private String label;
    private List<String> outgoing;
    private int level; // For visualization purposes

    public Node(String id, String type, String label) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.outgoing = new ArrayList<>();
        this.level = 0;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getLabel() { return label; }
    public List<String> getOutgoing() { return outgoing; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public void addOutgoing(String targetId) {
        outgoing.add(targetId);
    }

    public String getSymbol() {
        switch (type) {
            case "start": return "(●)";
            case "end": return "(◉)";
            case "activity": return "[" + label + "]";
            case "decision": return "<>" + label;
            case "merge": return "<>";
            case "fork": return "===";
            case "join": return "===";
            default: return label;
        }
    }
}