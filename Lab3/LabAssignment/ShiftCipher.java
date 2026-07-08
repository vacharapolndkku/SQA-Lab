package CaesarCipher;

public class ShiftCipher {
	
	static final int num_char = 26;    //number of elements in the set (all characters in the set)
	
	public String shift(String message, int key){
		
        StringBuilder stbuilder = new StringBuilder();
        char currentChar;
        
        message = message.toUpperCase();
 
        int length = message.length();

        key = key%num_char;

        for(int i = 0; i < length; i++){
            currentChar = message.charAt(i);
           
            
            if (currentChar >= 'A' && currentChar <= 'Z'){
            	char shiftedChar = (char) (currentChar + key);
            	
            	if (shiftedChar > 'Z') {
            		shiftedChar = (char) (shiftedChar - num_char);
            	}
            	stbuilder.append(shiftedChar);
            }
               else {
				stbuilder.append(currentChar);
			}
        }

        return stbuilder.toString();
    }

}
