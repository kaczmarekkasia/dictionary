import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dictionary {
    private Map<String, List<String>> words = new HashMap<String, List<String>>();


    void addTranslation(String inPolish, String inEnglish) {
        if (!words.containsKey(inEnglish)) {
            words.put(inEnglish, new ArrayList<String>(Arrays.asList(inPolish)));
        } else {
            words.get(inEnglish).add(inPolish);
        }
        System.out.println("Tłumaczenie zostało dodane do słownika!");
    }

    String translate(String inPolish) {
        for (Map.Entry<String, List<String>> stringListEntry : words.entrySet()) {
            if (stringListEntry.getValue().contains(inPolish)){
                return stringListEntry.getKey();
            }
        }
        return null;

    }
}
//
//        for (String wordInEnglish : words.keySet()) {
//            for (List<String> wordInPolish : words.values()) {
//                if (wordInPolish.equals(inPolish)) {
//                    return wordInEnglish;
//                }
//            }
//        }
//        return null;
//    }



