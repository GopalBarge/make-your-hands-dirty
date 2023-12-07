package com.make.your.hands.dirty.common.service;

import com.make.your.hands.dirty.common.modal.Tutorial;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    static List<Tutorial> tutorials = new ArrayList<>();

    public List<Tutorial> findAll() {
       if (tutorials.isEmpty()){
           populateTutorials();
       }
        return tutorials;
    }

    public List<Tutorial> findByTitleContaining(String title) {
        return tutorials.stream().filter(tutorial -> tutorial.title().contains(title)).toList();
    }

    public Optional<Tutorial> findById(long id) {
        return tutorials.stream().filter(tutorial -> id == tutorial.id()).findAny();
    }

    public Tutorial save(Tutorial tutorial) {
        tutorials.add(tutorial);
        return tutorial;
    }

    public void deleteById(long id) {
        tutorials.removeIf(tutorial -> id == tutorial.id());
    }

   private void populateTutorials(){
        tutorials.add(new Tutorial(1,"Reverse String", """
                package com.make.your.hands.dirty.common.string;
                               
                import java.util.Scanner;
                               
                public class ReverseString {
                    public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter the String :: ");
                        String str = scanner.nextLine();
                        String reversedString = reverseString(str);
                        System.out.println("Reversed String is :: "+reversedString);
                        scanner.close();
                    }
                               
                    public static String reverseString(String str){
                        char[] charArray = str.toCharArray();
                        int j = charArray.length-1;
                        for(int i=0 ;i < charArray.length/2; i++, j--){
                            char temp = charArray[i];
                            charArray[i] = charArray[j];
                            charArray[j] = temp;
                        }
                        return new String(charArray);
                    }
                }
                               
                """, true));
    }
}
