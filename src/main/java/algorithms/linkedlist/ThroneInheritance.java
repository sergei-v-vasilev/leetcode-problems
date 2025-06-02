package algorithms.linkedlist;

import java.util.*;

/**
 * 1600. Throne Inheritance
 */
public class ThroneInheritance {

    private static class Person {
        String parent;
        String name;
        LinkedHashSet<String> children;
        boolean isDead;

        Person(String parent, String name) {
            this.parent = parent;
            this.name = name;
            this.children = new LinkedHashSet<>();
        }
    }

    private Map<String, Person> personMap;
    private String king;

    public ThroneInheritance(String kingName) {
        this.personMap = new HashMap<>();
        this.king = kingName;
        birth(null, kingName);
    }

    public void birth(String parentName, String childName) {
        Person person = new Person(parentName, childName);
        if (parentName != null) {
            Person parent = personMap.get(parentName);
            parent.children.add(childName);
        }
        personMap.put(childName, person);
    }

    public void death(String name) {
        Person person = personMap.get(name);
        person.isDead = true;
    }

    public List<String> getInheritanceOrder() {
        LinkedList<String> inheritanceOrder = new LinkedList<>();
        Set<String> curOrder = new HashSet<>();
        curOrder.add(king);
        inheritanceOrder.add(king);
        String personName;
        do {
            personName = successor(inheritanceOrder.getLast(), curOrder);
            if (personName != null) {
                inheritanceOrder.add(personName);
                curOrder.add(personName);
            }
        } while (personName != null);
        Iterator<String> it = inheritanceOrder.iterator();
        while (it.hasNext()) {
            String name = it.next();
            Person person = personMap.get(name);
            if (person.isDead) {
                it.remove();
            }
        }
        return inheritanceOrder;
    }

    private String successor(String x, Set<String> curOrder) {
        Person person = personMap.get(x);
        if (person.children.isEmpty() || curOrder.containsAll(person.children)) {
            if (king.equals(x)) {
                return null;
            } else {
                return successor(person.parent, curOrder);
            }
        } else {
            for (String child : person.children) {
                if (!curOrder.contains(child)) {
                    return child;
                }
            }
            return null;
        }
    }
}
