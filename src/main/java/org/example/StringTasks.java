package org.example;

public class StringTasks {

    // .
    //На вход подается текст . все предложения, которого начинаются с маленькой буквы. Вывести исправленный
    //текст на консоль
    // "hello world. this is text."
    public static void t1(String text){
        boolean flag = false;
        for (int index = 0; index < text.length(); index++){
            char ch = text.charAt(index);
            if(index == 0){
                System.out.print((ch+"").toUpperCase());
            } else if(ch == '.' || ch == '!' || ch == '?'){
                System.out.print(ch);
                flag = true;
            } else if(flag && ch != ' '){
                System.out.print((ch+"").toUpperCase());
                flag = false;
            } else {
                System.out.print(ch);
            }
        }
    }





    public static void main(String[] args) {

        String str3 = "What makes these topics problematic in terms of research?\n" +
                "Obesity\n" +
                "This is very broad. What about obesity? Causes? Effects? Relationship to other issues? Add concepts to build a topic that is a better research choice.\n" +
                "\n" +
                "Does mentoring improve the academic achievement of African American males in high school?\n" +
                "This is a fairly specific topic that includes concepts that are often researched. The topic may be fine for your paper, but you may need to remove some of the concepts when you search for articles. For example, many researchers will not limit their study to one gender, but they may include a gender breakdown in their results.\n" +
                "\n" +
                "Does maternal attachment affect the ability of future accountants to comply with Sarbanes Oxley?\n" +
                "This exact topic is probably not of interest to researchers. While there are some researchers looking at maternal attachment and others who research Sarbanes Oxley, it's extremely unlikely that research has tied the two together.\n" +
                "\n" +
                "What factors influence the growth of farmers' markets in Miami?\n" +
                "The addition of a location to this topic may result in very few results. Depending on the type of research you are doing (discussion, paper, dissertation), you may want to remove the geographic limit. Both the scope and the purpose of your research project will affect whether this topic needs to be refined.";

        String str4 = "What makes these topics problematic in terms of research?ObesityThis is very broad. What about obesity? Causes? Effects? Relationship to other issues? Add concepts to build a topic that is a better research choice.Does mentoring improve the academic achievement of African American males in high school?This is a fairly specific topic that includes concepts that are often researched. The topic may be fine for your paper, but you may need to remove some of the concepts when you search for articles. For example, many researchers will not limit their study to one gender, but they may include a gender breakdown in their results.Does maternal attachment affect the ability of future accountants to comply with Sarbanes Oxley?This exact topic is probably not of interest to researchers. While there are some researchers looking at maternal attachment and others who research Sarbanes Oxley, it's extremely unlikely that research has tied the two together.What factors influence the growth of farmers' markets in Miami?The addition of a location to this topic may result in very few results. Depending on the type of research you are doing (discussion, paper, dissertation), you may want to remove the geographic limit. Both the scope and the purpose of your research project will affect whether this topic needs to be refined.";


        t1(str4.toLowerCase());

        String example = "topics problematic ii";
        char search = 'i';
        int count = 0;
        while(example.indexOf(search) != -1){
            count++;
            example = example.substring(example.indexOf(search) + 1);
        };
        System.out.println();
        System.out.println(count);

        //str3.


        String example2 = "topics problematic ii";
//        for (int index = 0; index < example2.length(); index++){
//            char ch = example2.charAt(index);
//            int counter = 1;
//            String rest = new String(example2); // copy
//            while (rest.indexOf(ch, index + 1) != -1){
//                counter++;
//            }
//        }

        char [] arr = example2.toCharArray();
        for(int index = 0; index < arr.length; index++) {
            char ch = arr[index];
            int counter = 1;
            for(int j = index + 1; j < arr.length; j++) {
                if(ch == arr[j]){
                    counter++;
                }
            }
            if(counter == 2){
                System.out.println(ch);
            }
        }

        String example3 = "topics problematic ii word1 word2";
        String [] words = example3.split(" ");
        System.out.println(words.length);

    }
}
