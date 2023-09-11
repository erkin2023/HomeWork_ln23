package Ln_HomeWork_23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {
    private Map<KeyCharacter, List<String>> characteristics = new HashMap<>();

    public void addCharacter(KeyCharacter key, List<String> values) {
        characteristics.put(key, values);
    }

    public Map<KeyCharacter, List<String>> getCharacteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "characteristics=" + characteristics +
                '}';
    }
}
