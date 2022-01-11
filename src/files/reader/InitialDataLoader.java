package files.reader;

import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public final class InitialDataLoader {
    private final List<ChildLoader> children;
    private final List<Gift> santaGiftsList;

    public InitialDataLoader() {
        this.children = new ArrayList<>();
        this.santaGiftsList = new ArrayList<>();
    }

    public List<ChildLoader> getChildren() {
        return children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }
}
