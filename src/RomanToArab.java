public class RomanToArab {

        String str1;
        String str2;
        int con1;
        int con2;
        int result;
        String resultNew;
        int check1;
        int check2;

        RomanToArab(){
            this.str1 = str1;
            this.str2 = str2;
        }
        int convertFirst() {
            for (Roman r : Roman.values()) {
                if (r.name().equals(str1)) {
                    con1 = Roman.valueOf(str1).getValue();
                }
            }
            return con1;
        }
        int convertSecond() {
        for (Roman r : Roman.values()) {
            if (r.name().equals(str2)) {
                con2 = Roman.valueOf(str2).getValue();
            }
        }
        return con2;
    }
        String convertResult(){
           for (Roman roman: Roman.values()){
               if (roman.getValue() == result){
                    resultNew = roman.getNumber();
               }
           }
           return resultNew;
        }


}
