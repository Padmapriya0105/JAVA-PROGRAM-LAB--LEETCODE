import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.family = new HashMap<>();
        this.dead = new HashSet<>();
        family.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }
        List<String> children = family.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
