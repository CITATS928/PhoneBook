package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    //create a new HashMap
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {

        this(new LinkedHashMap<>());
    }

    //add an entry to the composite associate data type
    public void add(String name, String phoneNumber) {
        List<String> numbers = phonebook.getOrDefault(name,new ArrayList<>());
        numbers.add(phoneNumber);
        //System.out.println(numbers);
        phonebook.put(name,numbers);
        //System.out.println(phonebook);

    }

    //Adds many phone numbers to a single name entry
    public void addAll(String name, String... phoneNumbers) {
        for(String i:phoneNumbers){
            add(name,i);
        }
        System.out.println(phonebook);
    }

    //removes an entry to the composite associate data type
    public void remove(String name) {

        phonebook.remove(name);
    }

    //removes an entry to the composite associate data type
    public Boolean hasEntry(String name) {
        if(phonebook.containsKey(name)){
            return true;
        }else {
        return false;}
    }

    //returns a phone number for the respective input name
    public List<String> lookup(String name) {
        List<String> number;
        number = phonebook.get(name);
        return number;
    }

    //returns a name for the respective input phonenumber
    public String reverseLookup(String phoneNumber)  {

        for(Map.Entry<String,List<String>> i :phonebook.entrySet()){
            if(i.getValue().contains(phoneNumber)){
                String name = i.getKey();
                System.out.println(name);
                return name;
            }
        }

        return null;
    }

    //returns a list of all names in this phonebook
    public List<String> getAllContactNames() {
        List<String> result= new ArrayList<>();

        for(Map.Entry<String,List<String>> i: phonebook.entrySet()){
            result.add(i.getKey());
        }
        //Collections.sort(result);
        return result;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
