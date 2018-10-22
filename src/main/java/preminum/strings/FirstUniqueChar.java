package preminum.strings;

import java.util.ArrayList;
import java.util.List;

public class FirstUniqueChar {

    //TODO: 可以从26个字母的维度去考虑，可以减少遍历数量
    public int firstUniqChar(String s) {
        if (s.length() == 0){
            return -1;
        }

        int[] charPositionLocations = new int[26];
        List<CharPosition> charPositions = new ArrayList<>(26);
        for (int i = 0; i < s.length(); i++){
            char chr = s.charAt(i);
            int loc = (int)(chr - 'a');
            if (charPositionLocations[loc] == 0){
                CharPosition charPosition = new CharPosition();
                charPosition.occurTimes = 1;
                charPosition.pos = i;
                charPositions.add(charPosition);
                charPositionLocations[loc] = charPositions.size();
            }else{
                int index = charPositionLocations[loc] - 1;
                charPositions.get(index).occurTimes++;
            }
        }

        for (CharPosition charPosition :charPositions){
            if (charPosition.occurTimes == 1){
                return charPosition.pos;
            }
        }

        return -1;
    }

    private class CharPosition{
        int occurTimes;
        int pos;
    }
}
