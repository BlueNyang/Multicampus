package genericCollection.sec15;

public class Student {
    private int sNo;
    private String name;

    public Student(int sNo, String name) {
        this.sNo = sNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return sNo == other.sNo && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant
        result = 31 * result + Integer.hashCode(sNo);
        result = 31 * result + name.hashCode();
        System.out.println("hash: " + result);
        return result;
    }

    @Override
    public String toString() {
        return "{Student - sNo: " + sNo + ", Name: " + name + "}";
    }
}
