import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public String[] bloodTypeGroups = {
            "A-",
            "B-",
            "A+",
            "B+",
            "AB-",
            "AB+",
            "O-",
            "O+"
    };

    public static class Laboratory{
        private int testNumber;
        private final int TOTAL_CASE = 3;
        private final int FATHER_COLUMN = 0;
        private final int MOTHER_COLUMN = 1;
        private final int CHILD_COLUMN = 2;
        private String[][] bloods;
        public Laboratory(int testNumber){
            this.testNumber = testNumber;
            bloods = new String[testNumber][TOTAL_CASE];
        }

        public void setFatherBlood(int row, String type){
            bloods[row][FATHER_COLUMN] = type;
        }

        public void setMotherBlood(int row, String type){
            bloods[row][MOTHER_COLUMN] = type;
        }

        public void setChildBlood(int row, String type){
            bloods[row][CHILD_COLUMN] = type;
        }

        private List<String> generateChildBloodTypes(int row){
            String fatherBlood = bloods[row][FATHER_COLUMN];
            String motherBlood = bloods[row][MOTHER_COLUMN];
            boolean hasA = false;
            boolean hasB = false;
            List<String> tempSubSet = new ArrayList<>();
            ArrayList<String> finalSubSet = new ArrayList<>();

            if( hasTypeA(fatherBlood, motherBlood) ){
                tempSubSet.add("A-");
                hasA = true;
            }
            if( hasTypeB(fatherBlood, motherBlood) ){
                tempSubSet.add("B-");
                hasB = true;
            }
            if( hasA && hasB)
                tempSubSet.add("AB-");

            for(String str: tempSubSet)
                finalSubSet.add(str);

            if( hasTypePlus(fatherBlood, motherBlood) ){
                for(String str: tempSubSet){
                    if(str.contains("A"))
                        finalSubSet.add("A+");
                    if (str.contains("B"))
                        finalSubSet.add("B+");
                    if(str.contains("AB"))
                        finalSubSet.add("AB+");
                }

                finalSubSet.add("O+");
            }

            finalSubSet.add("O-");

            return finalSubSet;
        }

        private boolean hasTypeA(String fatherBlood, String motherBlood){
            if( fatherBlood.contains("A") || motherBlood.contains("A"))
                return true;
            return false;
        }

        private boolean hasTypeB(String fatherBlood, String motherBlood){
            if( fatherBlood.contains("B") || motherBlood.contains("B"))
                return true;
            return false;
        }

        private boolean hasTypePlus(String fatherBlood, String motherBlood){
            if( fatherBlood.contains("+") || motherBlood.contains("+"))
                return true;
            return false;
        }

        public Validation getValidationResult(int row){
            List<String> childBloodSubSet = generateChildBloodTypes(row);
            String childBlood = bloods[row][CHILD_COLUMN];

            boolean flag = false;
            for(String str: childBloodSubSet)
                if(childBlood.equalsIgnoreCase(str)){
                    flag = true;
                    break;
                }

            if (flag)
                return Validation.valid;


            return Validation.invalid;
        }



    }

    enum Validation{
        valid,
        invalid
    }
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String fatherBlood, motherBlood, childBlood;
        String outPut;
        int t = userInput.nextInt();
        Laboratory laboratory = new Laboratory(t);

        for(int i = 0; i < t; ++i){
            fatherBlood = userInput.next();
            motherBlood = userInput.next();
            childBlood = userInput.next();
            laboratory.setFatherBlood(i, fatherBlood);
            laboratory.setMotherBlood(i, motherBlood);
            laboratory.setChildBlood(i, childBlood);
        }

        for(int i = 0; i < t; ++i){
            outPut = laboratory.getValidationResult(i).toString();
            System.out.println(outPut);
        }
    }
}
