package genericCollection.sec12;

public class Member2 {
    public String name;
    public int age;

    public Member2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same object

        if (obj == null || getClass() != obj.getClass()) return false; // Check for null or different class

        Member2 member = (Member2) obj; // Cast to Member2
        return age == member.age && name.equals(member.name); // Compare fields
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + age; // Return combined hash code
    }
}
