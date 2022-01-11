package files.reader;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import enums.Category;
import enums.ElvesType;

import java.util.ArrayList;

@JsonDeserialize(as = ChildLoader.class)
public abstract class ChildUpdateLoader {
    private final Integer id;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;
    private final ElvesType elf;

    public ChildUpdateLoader() {
        this.id = 0;
        this.niceScore = 0.0;
        this.giftsPreferences = new ArrayList<>();
        this.elf = ElvesType.WHITE;
    }

    public final Integer getId() {
        return id;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public ElvesType getElf() {
        return elf;
    }
}
