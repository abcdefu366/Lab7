package utils.readers;

public abstract class Reader {

    private NameReader nameReader;
    public abstract String getNewLine();

    public NameReader getNameReader() {
        return nameReader;
    }
}
