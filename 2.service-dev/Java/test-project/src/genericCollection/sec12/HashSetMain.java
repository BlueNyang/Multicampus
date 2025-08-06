package genericCollection.sec12;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String[] ignoredArgs) {
        // Create a HashSet to store Member objects
        HashSet<Member> members = new HashSet<>();

        // Add members to the HashSet
        // The field values are the same, but the object addresses are different.
        // HashSet does not allow duplicate objects based on equals() and hashCode() methods.
        members.add(new Member("Alice", 30));
        members.add(new Member("Alice", 30));

        // Display the members in the HashSet
        System.out.println("Members in HashSet:" + members.size());
        for (Member member : members) {
            System.out.println("Name: " + member.name + ", Age: " + member.age);
        }

        System.out.println("-------------------------------");

        // Create a HashSet to store Member2 objects
        HashSet<Member2> members2 = new HashSet<>();

        // Add members to the HashSet
        // The field values are the same, and the equals() and hashCode() methods are overridden.
        // HashSet will treat them as duplicates and not allow them to be added again.
        members2.add(new Member2("Bob", 25));
        members2.add(new Member2("Bob", 25));

        // Display the members in the HashSet
        System.out.println("Members2 in HashSet:" + members2.size());
        for (Member2 member : members2) {
            System.out.println("Name: " + member.name + ", Age: " + member.age);
        }
    }
}
