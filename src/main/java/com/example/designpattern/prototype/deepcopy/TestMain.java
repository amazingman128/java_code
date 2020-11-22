package com.example.designpattern.prototype.deepcopy;

public class TestMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Phone phone = new Phone("13854565236", "华为MatePro30");
        User user1 = new User("amazingman", 26, phone);
        User user2 = (User) user1.clone();
        User user3 = (User) user1.clone();
        User user4 = (User) user1.clone();
        User user5 = (User) user1.clone();
        User user6 = (User) user1.clone();
        user1.setAge(28);
        user1.setUsername("heartless");

        System.out.println(user1 + "  " + user1.getPhone().getClass());
        System.out.println(user2 + " " + System.identityHashCode(user2) + " " + System.identityHashCode(user2.getPhone()));
        System.out.println(user3 + " " + System.identityHashCode(user3)+ " " + System.identityHashCode(user3.getPhone()));
        System.out.println(user4 + " " + System.identityHashCode(user4)+ " " + System.identityHashCode(user4.getPhone()));
        System.out.println(user5 + " " + System.identityHashCode(user5)+ " " + System.identityHashCode(user5.getPhone()));
        System.out.println(user6 + " " + System.identityHashCode(user6)+ " " + System.identityHashCode(user6.getPhone()));

    }
}
