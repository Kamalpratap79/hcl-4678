package Day8;

public class CreatingSingleObject {
    public static void main(String[] args) {
        Student obj = Student.getInstance();
        System.out.println(obj);
        System.out.println(obj.hashCode());
        obj.setName("Kamal");

        String msg = obj.getMsg();
        System.out.println(msg);

        Student obj1 = Student.getInstance();
        System.out.println(obj1);
        System.out.println(obj1.hashCode());
        System.out.println(obj.getName());

    }

}
