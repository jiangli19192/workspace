package com.zjl.java8.study.methodReference;

import java.util.ArrayList;
import java.util.List;

public class StructureMethodInvoke {
	class User {
        String username;
 
        User(String username){
            this.username = username;
        }
 
        public String getUsername(){
            return username;
        }
    }
 
    @FunctionalInterface
    interface UserFactory<T extends User> {
        T create(String username);
    }
 
    public static void main(String[] args) {
    	StructureMethodInvoke t = new StructureMethodInvoke();
        t.structureMethodInvoke();
    }
 
    private void structureMethodInvoke() {
        UserFactory<User> uf = User::new;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            users.add(uf.create("user"+i));
        }
        users.stream().map(User::getUsername).forEach(System.out::println);
    }
}
