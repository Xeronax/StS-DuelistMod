package duelistmod.enums;

import java.util.HashMap;

public enum CharacterModel {
    ANIM_YUGI("Yugi"),
    ANIM_KAIBA("Kaiba"),
    STATIC_KAIBA("Kaiba (Static)"),
    STATIC_YUGI_NEW("Yugi (Static)"),
    STATIC_YUGI_OLD("Yugi (Original)");

    private final String displayName;
    public static final HashMap<CharacterModel, Integer> menuMapping;
    public static final HashMap<Integer, CharacterModel> menuMappingReverse;

    CharacterModel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    static {
        menuMapping = new HashMap<>();
        menuMappingReverse = new HashMap<>();
        int counter = 0;
        for (CharacterModel model : CharacterModel.values()) {
            menuMapping.put(model, counter);
            menuMappingReverse.put(counter, model);
            counter++;
        }
    }
}